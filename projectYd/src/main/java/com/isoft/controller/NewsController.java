package com.isoft.controller;

import com.isoft.bean.ResponseData;
import com.isoft.entity.News;
import com.isoft.service.NewsService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping("add")
    public ResponseData add(News news){
     boolean r = newsService.add(news);
     return new ResponseData(
             r ? 0 : 1,
             r ? "添加成功" : "添加失败",
             r
     );
    }

    @GetMapping("get/{id}")
    public ResponseData getById (@PathVariable("id") Integer id){
        News news = newsService.getById(id);
        return new ResponseData(
                news != null ? 0 : 1 ,
                news != null ? "查找成功" : "查找失败",
                news
        );

    }

    @GetMapping("data")
    public Map<String,Object> page(Integer page ,Integer size ,String title,Integer typeid){
        Map<String , Object> map = newsService.getPage(page,size,title,typeid);
        List<News> list = (List<News>) map.get("data");
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
    public ResponseData update(@PathVariable("id") Integer id,News news){
        boolean r = newsService.updateById(news);
        return new ResponseData(
                r ? 0 : 1 ,
                r ? "修改成功" : "修改失败",
                r
        );
    }

    @GetMapping("del/{id}")
    public ResponseData delById (@PathVariable("id") Integer id){
        boolean r = newsService.delById(id);
        return new ResponseData(
                r ? 0 : 1,
                r ? "删除成功" : "删除是失败",
                r
        );

    }

    @GetMapping("dels")
    public ResponseData dels (Integer[] id){
        boolean r = newsService.delByIds(id);
        return new ResponseData(
                r ? 0 : 1,
                r ? "删除成功" : "删除失败",
                r
        );

    }



    @GetMapping("updateTop/{id}")
    public ResponseData updateTop (@PathVariable("id") Integer id){
        boolean r = newsService.updateTop(id);
        return new ResponseData(
                r ? 0 : 1,
                r ? "查看成功" : "查看失败",
                r
        );

    }




}
