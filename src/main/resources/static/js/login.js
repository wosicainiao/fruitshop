//账号密码登录
function accountLogin() {
    $.ajax({
        url:"/fruitshop/user/loginByPwd",
        type:'POST',
        data:$('#form_pwd').serialize(),
        success: function (result) {
            console.log("result:",result);
            if (result.errorCode == 0){

            } else {
                $("#errorMassage").text(result.errorMsg);
            }
            // window.location.href="/fruitshop/home/index";
        }
    })
}
//账号密码登录验证
function verify() {
    
}