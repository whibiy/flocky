// 기간 선택 min value setting
$('input[name="amDateSettStartDate"]').on('change', function(){
    let startDate = $(this).val();
    $('input[name="amDateSettEndDate"]').prop('min',startDate);
});




let startDateValue = startDate(nowDateSet);
let endDateValue = `${nowDateSet.getFullYear()}-${String(nowDateSet.getMonth() + 1).padStart(2, '0')}-${String(nowDateSet.getDate()).padStart(2, '0')}`;


$('input[name="amDateSettStartDate"]').val(startDateValue);
$('input[name="amDateSettEndDate"]').val(endDateValue);

let startMinDate = $('input[name="amDateSettStartDate"]').val();
$('input[name="amDateSettEndDate"]').prop('min',startMinDate);

// loaded category checkbox all checked
const $categoryEls = $('.order-category-select input');
$($categoryEls).prop('checked', true);

// price form
const priceEls = $('input[name="orderPrice"]');
payFormat(priceEls);