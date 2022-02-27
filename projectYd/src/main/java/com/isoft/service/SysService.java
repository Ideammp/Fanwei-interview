package com.isoft.service;

import com.isoft.dao.SysDao;
import com.isoft.entity.Newstype;
import com.isoft.entity.Sys;
import com.isoft.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysService {
    @Autowired
    SysDao sysDao;
    public Map<String,Object>login(String name, String password){

        Map<String,Object> map = new HashMap<String, Object>();

        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(password)){
            map.put("result",3);
            return map;
        }

        Sys sys = sysDao.getByName(name);
            if(null == sys){
            map.put("result",2);
            return map;

        }else {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            sys = sysDao.getByNamePwd(name,password);
            if(null == sys){
                map.put("result",1);
                return map;

            }else {
                map.put("result",0);
                sys.setPassword(null);
                map.put("data", sys);
                return map;
            }
        }

    }

    /**
     * 添加管理员
     */

    public boolean add(String name ,String mobile){
        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(mobile)){
            return false;
        }
        //默认密码与用户名相同并使用md5加密
        String password = DigestUtils.md5DigestAsHex(name.getBytes());
        return sysDao.add(name,password,mobile) > 0;

    }


    /**
     * 密码校验
     */

    public Integer checkPwd(Integer id,String password){
        if(StringUtil.isEmpty(password)){
            return null;
        }
        if (null == id || id < 1){
            return null;
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        return sysDao.checkPwd(id,password);

    }


    /**
     * 修改密码
     */

    public boolean repass(Integer id ,String newpass){
        if(StringUtil.isEmpty(newpass)){
            return false;
        }
        if (null == id || id < 1){
            return false;
        }

        newpass = DigestUtils.md5DigestAsHex(newpass.getBytes());
        int r = sysDao.checkPwd(id,newpass);
        if(r > 0){
            return false;
        }else {
            return sysDao.updatePwd(id, newpass) > 0;
        }

    }


    /**
     * 查看所有管理员
     */

    public List<Sys> getAll() {
        return sysDao.getAll() ;
    }



    /**
     * 修改状态
     */

    public boolean updateState(Sys sys){
        if(null == sys){
            return false;
        }
        if(sys.getState() == 0 && sys.getState() == 1){
            return false;
        }
        return sysDao.updateState(sys) > 0 ;
    }





}
