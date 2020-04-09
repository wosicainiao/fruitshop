//账号密码登录
function loadLogin() {
    var username = localStorage.getItem("username");
    console.log("username",username)
    if (username != null && username != ""){

        $('#username').val(username);
    }
};
function accountLogin() {
    $.ajax({
        url:"/fruitshop/user/loginByPwd",
        type:'POST',
        data:$('#form_pwd').serialize(),
        success: function (result) {
            if (result.errorCode == 0){
                console.log("数据:",result.data);
                $("#errorMassage").empty();
                localStorage.setItem("userInfo",JSON.stringify(result.data));
                window.location.href="/fruitshop/home/index";
            } else {
                $("#errorMassage").text(result.errorMsg);
            }
        }
    })
}
//跳转到注册界面
function loginToRegister() {
    window.location.href="/fruitshop/user/register";
}
//账号密码登录验证
function verify() {
    
}