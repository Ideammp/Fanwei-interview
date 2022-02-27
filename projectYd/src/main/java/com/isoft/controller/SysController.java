package com.isoft.controller;

import com.isoft.bean.ResponseData;
import com.isoft.entity.News;
import com.isoft.entity.Sys;
import com.isoft.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin //允许跨域访问
@RestController//该类是Controller,而且所有请求方法结果序列化为json
@RequestMapping("/sys")//该类下所有方法请求的虚拟url都需要前置/sys
public class SysController {
    @Autowired
    SysService sysService;


    @PostMapping("login")
    public ResponseData login(String name,String password) {

        Map<String , Object> map = sysService.login(name,password);
        String msg = null;
        switch ((Integer) map.get("result")){
            case 0 : msg = "登录成功";break;
            case 1 : msg = "账号或密码错误";break;
            case 2 : msg = "账号不存在！"; break;
            case 3 : msg = "信息不完整"; break;


        }

        return new ResponseData  (
                (Integer)map.get("result"),
                msg,
                map.get("data")
        );







    }


    /**
     *
     * @param name
     * @param mobile
     * @return
     */

    @PostMapping("add")
    public ResponseData add(String name, String mobile){
        boolean r = sysService.add(name,mobile);
        ResponseData req = new ResponseData();
        req.setErrorCode(r ? 0 : 1);
        req.setMsg(r ? "添加成功" : "添加失败");
        req.setData(null);

        return req;

    }

    /**
     * 检查密码是否正确
     */

    @PostMapping("checkpwd")
    public ResponseData checkPwd (Integer id , String password){
        int count = sysService.checkPwd(id, password);
        ResponseData req = new ResponseData();
        req.setErrorCode(count > 0 ? 0 : 1);
        req.setMsg(count > 0 ? "原密码正确" : "原密码错误");
        req.setData(null);
        return req;
    }


    /**
     * 检查密码是否正确
     */

    @PostMapping("repass")
    public ResponseData repass (Integer id , String password){
        Boolean r = sysService.repass(id, password);
        ResponseData req = new ResponseData();
        req.setErrorCode(r  ? 0 : 1);
        req.setMsg(r ? "修改密码成功" : "新密码和旧密码一致，修改密码失败");
        req.setData(null);
        return req;
    }


    /**
     * 查看所有管理员
     */

    @GetMapping("all")
    public Map<String,Object> all(){
        List<Sys> list = sysService.getAll();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code" , null != list && list.size() > 0 ? 0 : 1);
        map.put("msg" , null != list && list.size() > 0 ? "查找数据成功！" : "朝朝数据失败！");
        map.put("data", list);
        return map;
    }


    /**
     * 修改状态
     */

    @PostMapping("updateState/{id}")
    public ResponseData updateState(@PathVariable("id") Integer id, Sys sys){
        boolean r = sysService.updateState(sys);
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "修改成功" : "修改失败",
                r
        );
    }









}
