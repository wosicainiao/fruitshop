//注册
function register(){
    var check = $("#reader-me-d").val();
d
    console.log("check->>",check)
    debugger
    $.ajax({
        url: "/fruitshop/user/registerUser",
        type: 'POST',
        data:$('#register_email').serialize(),
        // data:$('#register_email').serialize(),
        success: function (result) {
            console.log("result:",result);
            if (result.errorCode == '0'){
                localStorage.setItem("username",$('#email').val());
                window.location.href="/fruitshop/user/login"
            }else {
                $("#errorRegisterMassage").text(result.errorMsg);
            }
        }
    })
}

//跳转到登录页面
function jumpToLogin() {
    window.location.href="/fruitshop/user/login";
}

//跳转商城首页
function RegisterToIndex() {
    window.location.href="/fruitshop/home/index";
}