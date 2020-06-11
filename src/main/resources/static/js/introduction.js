var userInfo = localStorage.getItem("userInfo");
userInfo = JSON.parse(userInfo);

//进入购物车页面
function toShopCart(){
    if (userInfo == null){
        alert("请先登录");
        window.location.href="/fruitshop/user/login";
        return
    }else{
        window.location.href="/fruitshop/cart/shopcart?userId="+userInfo.id
    }
}

$(function () {
  $("#LikBasket").click(function () {
      if (userInfo == null){
          alert("请先登录");
          window.location.href="/fruitshop/user/login";
          return
      }
      var userId = userInfo.id;
      var number = $("[name = 'number']").val();
      var goodsId =$("[name = 'goodsId']").val();
      var cart = {"number":number,"goodsId":goodsId,"number":number};
      if (userId === "" || userId === null){
          window.location.href = "/fruitshop/user/login";
      }else {
          if (number > 0){
              $.ajax({
                  url:"/fruitshop/cart/addCart?userId="+userId,
                  type: 'POST',
                  dataType: 'json',
                  async:false,
                  data: JSON.stringify(cart),
                  contentType: "application/json;charset=utf-8",
                  success: function (res) {
                      if (res.errorCode == 0){
                          alert("添加成功！")
                          // window.location.href="/fruitshop/cart/shopcart?userId="+userInfo.id
                      }
                  }
              })
          }
      }
  })
})