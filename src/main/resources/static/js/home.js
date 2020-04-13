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
    window.location.href="/fruitshop/cart/shopcart";
}
//搜索
function searchGoods(){
    $("[name='searchGoods']").submit();
}
$(function () {
    var userInfo = JSON.parse(localStorage.getItem("userInfo"));
    // console.log("userInfo:",userInfo);
    if (userInfo != null){
        $("#login").text('欢迎您!'+userInfo.nickname);
        $("#login").removeAttr('onclick');
        $("#register").text('注销');
        $("#register").attr('onclick','logout()');

        $("#name").text('昵 称：'+userInfo.nickname);
        $("#avatar").attr('src',userInfo.avatar);
    }
});