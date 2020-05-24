var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);

//跳转到登录页面
function jumpToLogin() {
    window.location.href="/fruitshop/user/login";
}
//跳转到注册界面
function jumpToRegister() {
    window.location.href="/fruitshop/user/register";
}
//注销
function logout(){
    localStorage.clear();
    window.location.href="/fruitshop/home/index";
}
//跳转到购物车
function shopcart(){
    window.location.href="/fruitshop/cart/shopcart?userId="+userInfo.id;
}
//搜索
function searchGoods(){
    $("[name='searchGoods']").submit();
}
//跳转商城首页
function homeToIndex() {
    window.location.href="/fruitshop/home/index";
}
//进入商品详情页面
function toDetails(id){
    window.location.href="/fruitshop/goods/detail?id="+id;
}
$(function () {
    var userInfo = JSON.parse(localStorage.getItem("userInfo"));
    if (userInfo != null){
        $("#login").text('欢迎您!'+userInfo.nickname);
        $("#login").removeAttr('onclick');
        $("#register").text('注销');
        $("#register").attr('onclick','logout()');

        $("#name").text('昵 称：'+userInfo.nickname);
        $("#avatar").attr('src',userInfo.avatar);
    }
});

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