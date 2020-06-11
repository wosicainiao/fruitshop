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
//跳转到个人中心
function toPersonIndex(){
    if (userInfo == null || userInfo == ''){
        window.location.href="/fruitshop/user/login";
    } else {
        window.location.href="/fruitshop/home/personIndex?userId="+userInfo.id;
    }

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
