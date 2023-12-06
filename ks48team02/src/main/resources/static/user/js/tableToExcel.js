/**
 * 테이블 contents json 배열로 전환
 * 규칙: check박스 존재시 첫번째 열로 위치
 * @param {*} css 선택자(테이블) 
 * @returns parsing json Array
 */
function tableToJson(selector){
    // 선택자 문자열 
    let context = `${selector}`;
    // 테이블의 checkbox 존재 여부
    let isExistCheckBox = $(`${selector} input[type="checkbox"]`).length > 0 ? true : false;
    let keyEle;
    let rowEles;
    
    // 테이블의 checkbox 존재 여부 context 변경
    if(isExistCheckBox){
        context = `${context} input[type="checkbox"]`;  // 체크된 항목이 없을 경우 전체 행 context
        let isChecked = $(`${context}:checked`).length > 0 ? true : false;
        if(isChecked) context = `${context}:checked`;   // 체크된 항목일 경우 체크한 행 context 변경
        keyEle = $(context).eq(0).closest('table').find('th:not(:eq(0))');
        rowEles = $(context);
    }else{
        keyEle = $(context).find('th');
        rowEles = $(`${context} tbody`).find('tr');
    }
    let data;
    if(rowEles.length > 1){
        // 테이블의 행을 JSON배열로 전환
        data = [...rowEles].reduce((acc, cur, idx, arr) => {
            // 체크박스가 있을 경우 체크박스를 제외한 셀 선택
            let tdSelector = isExistCheckBox ? 'td:not(:eq(0)):visible' : 'td:visible';

            const tdEles = $(cur).closest('tr').find(tdSelector);

            // 셀의 값과 일치된 열의 항목을 대상으로 객체 생성
            const rowContent = [...tdEles].reduce((acc, cur, idx, arr) => {
                const key = $(keyEle[idx]).text().replace(/\n/g,'').replace(/\s*/,'').replaceAll(' ','');
                const value = $(cur).text();
                acc[key] = value.replace(/\n/g,'').replace(/\s*/,'').replaceAll(' ','');
                return acc;
            },{});

            if(Object.keys(rowContent).length > 0) acc.push(rowContent);

            return acc;
        }, []);
    }else{
        const emtpyObj = [...keyEle].reduce((acc, cur, idx, arr) => {
            let key = $(cur).text().replace(/\n/g,'').replace(/\s*/,'').replaceAll(' ','');
            acc[key] = '';
            return acc;
        }, {})
        emtpyObj.empty = true;
        emtpyObj.emptyMsg = rowEles.find('td:visible').eq(0).text();
        data = [emtpyObj];
    }

    return data;
}

// 엑셀파일 다운로드
const download = async (workbook, fileName) => {

    const buffer = await workbook.xlsx.writeBuffer();
    const blob = new Blob([buffer], {
        type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
    });
    const url = window.URL.createObjectURL(blob);
    const anchor = document.createElement('a');
    anchor.href = url;
    anchor.download = fileName + '.xlsx';
    anchor.click();
    window.URL.revokeObjectURL(url);
};

/**
 * 엑셀 객체로 전환 후 엑셀 파일 다운로드
 * @param {*} jsonArray 
 * @param {*} fileName 파일명
 */
function exportExcel(jsonArray, fileName){
    // 엑셀 새 통합문서 객체 생성
    const workbook = new ExcelJS.Workbook();
    // 새 워크시트 객체 생성
    const sheet = workbook.addWorksheet(fileName);
    
    // excel에 추가할 행 배열 변환
    const excelData = jsonArray.reduce((acc, cur, idx, arr)=>{
        const rowDataArr = [];
        for(const key in cur){
            rowDataArr.push(cur[key]);
        }
        acc.push(rowDataArr);
        return acc;
    },[]);

    // json 객체의 속성 갯수
    let colLength = Object.keys(jsonArray[0]).length;

    // 아스키코드 대문자A:65, 초기값 64로 셋팅후 객체 속성의 갯수만큼 더함
    // data(속성) 가 없을 시 열의 크기 -2
    if (Object.keys(jsonArray[0]).includes('empty')) colLength -= 2;

    let mergeMaxCol = String.fromCharCode(64+colLength)
    
    // 제목행 병합 및 스타일 추가
    sheet.mergeCells(`A1:${mergeMaxCol}1`);
    sheet.getCell('A1').value = fileName;
    sheet.getCell('A1').font = { size: 15, bold: true};
    sheet.getCell('A1').alignment = { horizontal: 'center' };
    sheet.getCell('A1').fill = {
        type:'pattern',
        pattern: 'solid',
        fgColor : {argb: '00bfff00'},
        bgColor : {argb: 'ffffff00'}
    };

    // 머릿글행 파싱 후 추가
    const headCol = Object.keys(jsonArray[0]).reduce((acc, cur)=>{
        if(!cur.includes('empty') && !cur.includes('emptyMsg')){
            acc.push(cur);
        }
        return acc;
    },[]);
    sheet.getRow(3).values = headCol;
    
    // 데이터행 추가
    //['1','id001','제목','2023-11-03']
    if(jsonArray[0].empty){
        sheet.mergeCells(`A4:${mergeMaxCol}4`);
        sheet.getCell('A4').value = jsonArray[0].emptyMsg;
        sheet.getCell('A4').alignment = { horizontal: 'center' };
    }else{
        sheet.addRows(excelData);
    }

    sheet.columns.forEach((item, idx) => {
        const target = item.values.slice(3);
        let isCheckedKor = false; 
        const check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
        const lengths = target.map( (v, i) => {
            if(check.test(v.toString())) isCheckedKor = true;
            return v.toString().length;
        });
        const maxLength = Math.max(...lengths.filter(v => typeof v === 'number'));
        console.log(maxLength);
        console.log(isCheckedKor)
        // width 관련 직접 값 조정
        item.width = (isCheckedKor) ? maxLength * 3 : maxLength + 3;
    });
    
    
    // 전체 table 스타일 조정
    sheet.getRow(3).height = 20;
    for(let row = 3; row <= sheet._rows.length; row+=1){
        for(let col = 1; col <= colLength; col+=1){
            // 머리글 스타일 조정
            if(row == 3){
                sheet.getCell(row, col).fill = {
                    type: 'pattern',
                    pattern : 'solid',
                    fgColor : {argb: '00bfff00'},
                    bgColor : {argb: 'ffffff00'}
                }
                sheet.getCell(row, col).font = { size: 11, bold: true};
                sheet.getCell(row, col).alignment = { horizontal: 'center', vertical: 'middle' };
            }
            // 데이터 행 스타일 적용
            sheet.getCell(row, col).border = {
                top: {style:'thin', color: {argb:'00000000'}},
                left: {style:'thin', color: {argb:'00000000'}},
                bottom: {style:'thin', color: {argb:'00000000'}},
                right: {style:'thin', color: {argb:'00000000'}}
            }
        }
    }
    
    // 생성된 worksheet 엑셀 다운로드
    download(workbook, fileName).then(r => {});
}