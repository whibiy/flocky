var subsetContentHeight = function () {
    // reset height
    $RIGHT_COL.css('min-height', $(window).height());

    var bodyHeight = $BODY.outerHeight(),
        footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
        leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
        contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;

    // normalize content
    contentHeight -= $NAV_MENU.height() + footerHeight;

    $RIGHT_COL.css('min-height', contentHeight);
};

// 서브 메뉴 active
$SIDEBAR_MENU.find('a').filter(function () {
    console.log(this.href == document.referrer, '<--??');
    return this.href == document.referrer;
}).parent('li').addClass('current-page').parents('ul').slideDown(function() {
    subsetContentHeight();
}).parent().addClass('active');

// recompute content when resizing
$(window).smartresize(function(){
    subsetContentHeight();
});

subsetContentHeight();