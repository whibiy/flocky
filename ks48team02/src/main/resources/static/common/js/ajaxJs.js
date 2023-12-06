/* main rank ajax code */
function rankAjax(param, callback){
    const request = $.ajax({
        url: '/user/ajax/rankCategory',
        method : 'POST',
        data : {"rankCategory" : param},
        dataType: 'json'
    })
    request.done(function(list){
        callback(list);
    });
    request.fail(function(err){
        console.log(err);
    })
}
// reload button click ajax
$('#rankReload').on('click', function(){
    rankAjax('achievementPercent', function(list){
        // console.log(list);
        $(`.main-rank-area`).addClass('active');
        $(`.main-rank-area ul li`).remove();

        $(list).each((idx, item) => {
            // append 로 수정해보기
            let listElement = "";
            listElement += "<li>";
            if(item.projectCode == '리워드'){
                listElement += `<a href="/user/reward/detail?rewardProjectCode=${item.projectCode}">`;
            } else if(item.projectCode == '기부'){
                listElement += `<a href="/user/donation/detail?donationCode=${item.projectCode}">`;
            } else {
                listElement += `<a href="/user/investment/detail/main?investmentCode=${item.projectCode}">`;
            }
            listElement += `      <em>${item.rankCount}</em>`;
            listElement += `      <div>`;
            listElement += `        <h5>${item.subject}</h5>`;
            listElement += "        <div class='product-detail-info'>";
            listElement += "			<p class='funding-percent'><span>"+item.achievementPercent+"</span>%</p>";
            listElement += "          	<p class='category'>";
            listElement += (item.categoryName == '')?"<span>카테고리 없음</span>":"<span>"+item.categoryName+"</span>";
            listElement += "            ·" ;
            listElement += "            <span>"+item.projectType+"</span>";
            listElement += "          	</p>";
            listElement += "        </div>";
            listElement += "        </div>";
            listElement += `      <div class="project-img" style="background-image: url('/summernoteImage/${item.imageUrl}'),url('/user/images/no-image.svg');"></div>`;
            listElement += "      </div>";
            listElement += "    </a>";
            listElement += "</li>";
            console.log(listElement);

            $(`.main-rank-area ul`).append(listElement);

        });
    })

    $('.tab-menu-btn li').removeClass('active');
    $('.tab-menu-btn li:first-child').addClass('active');
});



jQuery.fn.serializeObject = function() {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function() {
                    obj[this.name] = this.value;
                });
            }//if ( arr ) {
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }

    return obj;
};

// 검색 form queryString 반환 fn
function searchObject(){
    const $inputEls = $('.order-category-select input:checked');

    const arr = [];
    $($inputEls).each((idx, item) => {
        let checkBoxValue = $(item).attr('name');
        arr.push(checkBoxValue);
    });
    // console.log(arr, '<--arr');

    let amDateSettStartDate = $('input[name="amDateSettStartDate"]').val();
    let amDateSettEndDate = $('input[name="amDateSettEndDate"]').val();
    let userSearchKey = $('select[name="userSearchKey"]').val();
    let userSearchable = $('input[name="userSearchable"]').val();

    console.log(userSearchable, '<-- userSearchable');

    $('input[name="dateSettStartDate"]').val(amDateSettStartDate);
    $('input[name="dateSettEndDate"]').val(amDateSettEndDate);
    $('input[name="searchKey"]').val(userSearchKey);
    $('input[name="searchValue"]').val(userSearchable);

    let queryString = $('#searchForm').serializeObject();
    queryString.projectPartition = arr;

    return queryString;
}


// pager setting
function setPagerData(arr, currentPage, list){
    let lastPage = list.lastPage;
    let startPageNum = list.startPageNum;
    $('.list-btn-area button').removeClass('no-action');

    if(currentPage == startPageNum) {
        $('.prev-transfer').addClass('no-action');
    }
    if(currentPage == lastPage){
        $('.next-transfer').addClass('no-action');
    }

    $('.order-list-pager li').remove();
    $(arr).each((idx, item) => {
        let classArr = [];
        if(item == currentPage) {
            classArr.push('link-active');
            classArr.push('currentPage');
        }
        if(item == startPageNum) classArr.push('startPageNum');
        if(item == lastPage) classArr.push('lastPage');

        $('.order-list-pager').append(`<li class="${classArr.join(' ')}"><a data-value="${item}">${item}</a></li>`);
    });
}

// admin orderby default setting
function orderbyDefaultSet(){
    $('select[name="orderby"] option, select[name="count-select"] option').prop('selected',false);
    $('select[name="orderby"] option:first-child, select[name="count-select"] option:first-child').prop('selected', true);
}