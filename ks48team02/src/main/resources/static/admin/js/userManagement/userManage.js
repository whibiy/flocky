
const $chooseAll = document.getElementById('choose-all');
const $chooseOne = document.querySelectorAll('.choose-one');

$chooseAll.addEventListener('click', () => {
    $chooseOne.forEach(element => {
        element.checked = $chooseAll.checked;
    })
})

/* 체크박스 : 개별 항목 전부 체크시 전체동의 체크 */
$chooseOne.forEach(checkbox => { // 개별 항목마다 이벤트 리스너를 걸어 주기
    checkbox.addEventListener('change', () => {
        const $checkedBoxes = document.querySelectorAll('.choose-one[type="checkbox"]:checked');

        $chooseAll.checked = $checkedBoxes.length === $chooseOne.length;
    });
});