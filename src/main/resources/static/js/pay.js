var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);
var addressId;
function submitOrder() {

    var arriveTime = $('#arriveTime').val();
    console.log("arrriveTime->",arriveTime)
    if (userInfo == null || userInfo == undefined){
        alert("请先登录");
        window.location.href="/fruitshop/user/login";
        return
    }
    if (addressId == null || addressId == undefined){
        alert("请选择地址")
        return
    }
    if (arriveTime == null || arriveTime == ''){
        alert("请输入到达时间")
        return
    }
    var userId = userInfo.id;
    var sub = confirm("确认提交订单吗？");
    if (!sub){
        return
    }else {
        console.log('addressid',addressId)
        var order = {"userId":userId,"addressId":addressId,"arriveTime":arriveTime}
        $.ajax({
            url: "/fruitshop/order/submitOrder",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(order),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                window.location.href="/fruitshop/order/paySuccess";
                console.log('data',data)
            }
        })
    }
}

function clickAddress(id) {
    addressId = id;
    console.log('id-->',id)
}
