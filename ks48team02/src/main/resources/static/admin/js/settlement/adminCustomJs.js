


// 선택된 체크박스 count add text
function checkedCount($checkedInput){

    $('.select-list-count').text($checkedInput.length);
}


// list count controller
let $formInInput = $('.settlement-log input[type="checkbox"]');
console.log($formInInput, '<--$formInInput')
$('.total-list').text($formInInput.length - 1);

$(document).on('click', '.settlement-log input[type="checkbox"]',function() {
    const $checkedInput = $('.settlement-log input:checked').not('#allSelectBtn');
    $formInInput = $('.settlement-log input[type="checkbox"]');
    // count add text
    checkedCount($checkedInput);

    // allcheckbox controls
    let checkedValidation = false;

    if($checkedInput.length == $formInInput.length - 1) checkedValidation = true;

    $('#allSelectBtn').prop('checked', checkedValidation);

});


