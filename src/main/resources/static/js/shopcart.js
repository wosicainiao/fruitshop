var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);
var activePrice = $("[name = 'activePrice']").val();
var allNumber = $("[name = 'number']").val();
allNumber = parseInt(allNumber);
$(function () {
    $("#allPrice").text(activePrice * allNumber);
})

function minNumber(){
    if (allNumber >0){
        allNumber = allNumber -1
        $("#allPrice").text(activePrice * allNumber);
    }
}

function addNumber(){
    console.log('+++++',allNumber)
    allNumber = allNumber + 1;
    console.log('allumber',allNumber);
    console.log('activePrice',activePrice );
    $("#allPrice").text(activePrice * allNumber);
}

//删除购物车
function delCartByUser(){
    var cartId = $("[name= 'cartId']").val();
    console.log('cartId',cartId);
    var userId = userInfo.id;
    if (userId == null || userId == ''){
        alert("请先登录");
        window.location.href="/fruitshop/user/login";
    }
    var cart = {"userId":userId,"cartId":cartId}
    $.ajax({
        url: "/fruitshop/cart/deleteCart",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(cart),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            window.location.href="/fruitshop/cart/shopcart?userId="+userInfo.id
        }
    })

}