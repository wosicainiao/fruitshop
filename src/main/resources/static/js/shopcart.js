var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);
var allNumber = $("[name = 'number']").val();
//选中商品个数
var goodsCount = 0;
allNumber = parseInt(allNumber);

//减少
function cut(_this){
    //获取结算数据

    var settlement = $(".top-right").find("span").text();
    var setMoney = settlement.replace(/[^0-9\\.\\^0-9]/ig,"");
    //获取数量
    var value = $(_this).next().attr("value");
    value--;
    //获取会员价格
    var money = $(_this).parent().parent().parent().parent().prev().find(".active-price").text();
    //截取数字
    var finMoney = money.replace(/[^0-9\\.\\^0-9]/ig,"");
    var zhi = parseFloat(finMoney*value);
    //获取小数点后两位
    var sumMoney = zhi.toFixed(2);
    //总金额减少
    var jia = setMoney-finMoney;

    if (value < 1) {
        alert("已经减到底啦，不能再减啦！");
        value = 1;
        //再次赋值
        var oneValue = $(_this).parent().parent().parent().parent().prev().find(".active-price").text();
        //截取数字
        var oneMoney = oneValue.replace(/[^0-9\\.\\^0-9]/ig,"");
        $(_this).parent().parent().parent().parent().next().text("￥"+oneMoney);
    } else {
        //金额计算
        $(_this).parent().parent().parent().parent().next().text("￥"+sumMoney);
        //输入框
        $(_this).next().attr("value",value);
        $(".top-right").find("span").text("￥"+jia.toFixed(2));
        return
    }
}
//增加
function add(_this){
    //获取结算数据
    var settlement = $(".top-right").find("span").text();
    var setMoney = settlement.replace(/[^0-9\\.\\^0-9]/ig,"");
    setMoney = parseFloat(setMoney);
    //获取输入框
    var value = $(_this).prev().attr("value");
    //获取货品ID
    var id = $(_this).prev().attr("name");
    value++;
    $.ajax({
        url:"/fruitshop/goods/findProductStock",
        type: 'get',
        dataType: 'json',
        data:{
            "id":id
        },
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            //总金额
            var jia;
            if (data.result == "success") {
                if (value <= data.product.goodsNum) {
                    //获取会员单价
                    var money = $(_this).parent().parent().parent().parent().prev().find(".active-price").text();
                    //截取数字
                    var finMoney = money.replace(/[^0-9\\.\\^0-9]/ig,"");
                    var zhi = parseFloat(finMoney*value);
                    var sumMoney = zhi.toFixed(2);
                    //总金额增加
                    jia = (parseFloat(setMoney)+parseFloat(finMoney));
                    //金额计算
                    $(_this).parent().parent().parent().parent().next().text("￥"+sumMoney);
                    //输入框
                    $(_this).prev().attr("value",value);
                    //总金额
                    $(".top-right").find("span").text("￥"+jia.toFixed(2));
                } else {
                    alert("数字太大啦，已经没有库存啦！");
                    //获取金额
                    var zong = $(_this).parent().parent().next().text();
                    zong = zong.replace(/[^0-9\\.\\^0-9]/ig,"");
                    //获取结算数据
                    setMoney = parseFloat(setMoney) - parseFloat(zong);
                    //获取单价
                    var singleMoney = $(_this).parent().parent().prev().find(".top-price").text();
                    singleMoney = singleMoney.replace(/[^0-9\\.\\^0-9]/ig,"");
                    value = $(_this).prev().attr("alt");
                    jia = parseFloat(setMoney) + parseFloat(value*singleMoney);
                    //返还数据
                    var yuan = $(_this).parent().parent().next().attr("name");
                    $(_this).parent().parent().next().text("￥"+yuan);
                    $(_this).prev().attr("value",$(_this).prev().attr("alt"));
                    $(".top-right").find("span").text("￥"+jia.toFixed(2));
                }

            } else {
                console.log("失败！");
            }
        }
    })

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

//去结算
function toSettleAccount() {
    window.location.href="/fruitshop/cart/toSettleAccount?userId="+userInfo.id
}

//选中当前
function getCurrentGoods(_this){
    //th:onclick="'javascript:getCurrentGoods('+${shopcart.id}+')'"
    var check = $(_this).attr("checked");
    if (check == "checked") {
        goodsCount++;
        $(".amount-sum").find("[name='count']").text(goodsCount);
        $(_this).parent().parent().next().find("input[type='checkbox']").attr("checked",true);
    } else {
        goodsCount--;
        $(".amount-sum").find("[name='count']").text(goodsCount);
        $("[name='items']").attr("checked",false);
        $(_this).parent().parent().next().find("input[type='checkbox']").attr("checked",false);
    }
    console.log("_this:::",_this)
}