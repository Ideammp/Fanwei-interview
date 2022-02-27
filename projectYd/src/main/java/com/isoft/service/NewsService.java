package com.isoft.service;

import com.isoft.dao.NewsDao;
import com.isoft.entity.News;
import com.isoft.util.StringUtil;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {
    @Autowired
    NewsDao newsDao;

    /**
     * 添加新闻
     */

    public boolean add(News news){
        if( null == news){
            return false;
        }
        if(StringUtil.isEmpty(news.getTitle()) || StringUtil.isEmpty(news.getContent())){
            return false;
        }
        news.setPublishdt(new Date());
        return newsDao.insert(news) > 0;

    }

    /**
     *     根据id查看详情
     */

    public News getById(Integer id){
        if(null == id || id < 1){
            return null;
        }
        return newsDao.getById(id);
    }

    /**
     * 分页查看数据
     */
    public Map<String,Object> getPage(Integer page , Integer size , String title , Integer typeid){
        //如果前台title上传了一个空字符串做特殊处理赋值为NULL
        if(StringUtil.isEmpty(title)){
            title = null;
        }

        //如果前台上传一个空字符串的typeid做特殊处理赋值为NULL

        if(typeid != null && typeid < 0){

            typeid = null;
        }

        //设置初始的每页显示新闻条目是size

        if (null == size || size < 0){

            size = 10;

        }

        //设置分页page的初始值

        if(page == null || page < 0){

            page = 1;

        }

        int offset = (page - 1) * size;
        int count = newsDao.getCount(title,typeid);
        List<News> list = newsDao.getPage(offset,size,title,typeid);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count", count);
        map.put("data", list);
        return map;





    }

    /**
     * 编辑新闻
     */

    public boolean updateById(News news){
        if(null == news){
            return false;
        }
        if(null == news.getId() || news.getId() < 1){
            return false;
        }
        if(StringUtil.isEmpty(news.getTitle()) && StringUtil.isEmpty(news.getContent()) && StringUtil.isEmpty(news.getComefrom())){
            return false;
        }
        return newsDao.updateById(news) > 0 ;
    }


    /**
     * 删除一条记录
     */

    public boolean delById(Integer id){
        if(null == id || id < 0){
            return false;
        }
        return newsDao.delById(id) > 0;
    }

    /**
     * 删除多条记录
     */

    public boolean delByIds(Integer[] ids){
        if (null == ids || ids.length < 1){
            return false;
        }
        return newsDao.delByIds(ids) > 0;
    }



    /**
     * 点击ss增加
     */

    public boolean updateTop(Integer id){
        if(null == id || id < 0){
            return false;
        }
        return newsDao.updateTop(id) > 0;
    }




}
