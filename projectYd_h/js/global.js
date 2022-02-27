var ip = "127.0.0.1"
var port = "8080"
var appname = "projectYd"

var serverBase = "http://" + ip + ":" + port + "/" + appname + "/";



//取出数据

function parseSysUser(){
    var loginInfo = sessionStorage.getItem("login");
    var loginUser;
    if(loginInfo != null && loginInfo.length > 0){
        loginUser = JSON.parse(loginInfo);
    }
    return loginUser;
}
