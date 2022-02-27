package com.isoft.controller;

import com.isoft.bean.ResponseData;
import com.isoft.entity.News;
import com.isoft.entity.Newstype;
import com.isoft.service.NewstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/newstype")
public class NewstypeController {

    @Autowired
    NewstypeService newstypeService;

    @GetMapping("all")
    public ResponseData getAll(){
        List<Newstype> list = newstypeService.getAll();
        return new ResponseData(
                list != null && list.size() > 0 ? 0 : 1,
                list != null && list.size() > 0 ? "查询成功"  : "查无数据",
                list
        );
    }

    @PostMapping("add")
    public ResponseData add(String typename){
        boolean r = newstypeService.add(typename);
        return new ResponseData(
                r ? 0 : 1,
                r ? "添加成功" : "添加失败",
                r
        );
    }


    @GetMapping("del/{id}")
    public ResponseData delById (@PathVariable("id") Integer id){
        boolean r = newstypeService.delById(id);
        return new ResponseData(
                r ? 0 : 1,
                r ? "删除成功" : "删除失败",
                r
        );

    }



    @GetMapping("data")
    public Map<String,Object> page(Integer page , Integer size , String typename){
        Map<String , Object> map = newstypeService.getPage(page,size,typename);
        List<Newstype> list = (List<Newstype>) map.get("data");
        if(list != null && list.size() > 0){

            map.put("code",0);
            map.put("msg","查询成功");
        }else {

            map.put("code",1);
            map.put("msg","查询失败");

        }

             return map;

    }



    @PostMapping("update/{id}")
    public ResponseData update(@PathVariable("id") Integer id,Newstype newstype){
        boolean r = newstypeService.updateById(newstype);
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "修改成功" : "修改失败",
                r
        );
    }


    @GetMapping("get/{id}")
    public ResponseData getById (@PathVariable("id") Integer id){
        Newstype newstype = newstypeService.getById(id);
        return new ResponseData(
                newstype != null ? 0 : 1 ,
                newstype != null ? "查找成功" : "查找失败",
                newstype
        );

    }



}
