
var pageCurrent = $("[name='pageCurrent']").attr("value");
var total = $("[name='total']").attr("value");
var pageSum = $("[name='pageSum']").attr("value");
$(function () {
    console.log('total',total);
    console.log('total',pageSum);
    $("#recordCount").text(total)
    _mypage(pageSum,pageCurrent);

});

function _mypage(totalPage,pageCurrent){
    if(!pageCurrent){
        pageCurrent=1;
    }

    var options = {
        currentPage: pageCurrent ? pageCurrent : 0 ,
        totalPages: totalPage ? totalPage : 0,
        size:"normal",
        alignment:"right",
        /* pageUrl:function (type,page,current) {
             //是每个分页码变成一个超链接
             return '?page=' +page;
         },*/
        itemTexts: function (type, page) {
            switch (type) {
                case "first":
                    return "第一页";
                case "prev":
                    return "<";
                case "next":
                    return ">";
                case "last":
                    return "最后页";
                case "page":
                    return  page;
            }
        },
        onPageClicked: function (e, originalEvent, type, page) {
            // var category_id = $("[name='category_id']").val();
            location.href = "/fruitshop/home/index?page="+page;
        }
    }
    $('#_page').bootstrapPaginator(options);
}