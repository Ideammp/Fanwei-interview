//同步更新登录者信息



$(function (){

    var loginInfo = sessionStorage.getItem("login");
    var loginUser;
    if(loginInfo != null && loginInfo.length > 0){
        loginUser = JSON.parse(loginInfo);
    }






    if(loginUser.role == 0) {

        $("#menuSuper").css('display' , 'block') ;

    }

})




