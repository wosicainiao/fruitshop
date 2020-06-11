var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);

//我的订单
function toMyOrder(){
    if (userInfo == null || userInfo == ''){
        window.location.href="/fruitshop/user/login";
    } else {
        window.location.href="/fruitshop/order/myOrder?userId="+userInfo.id;
    }
}