package com.isoft.service;

import com.isoft.dao.NewsDao;
import com.isoft.dao.NewstypeDao;
import com.isoft.entity.News;
import com.isoft.entity.Newstype;
import com.isoft.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewstypeService {
    @Autowired
    NewstypeDao newstypeDao;

    public List<Newstype> getAll(){
        return newstypeDao.all();
    }


    /**
     * 添加新闻类别
     * @param typename
     * @return
     */

    public boolean add(String typename){

        if (null == typename){
            return false;
        }
        if(StringUtil.isEmpty(typename)){
            return false;
        }


        return newstypeDao.insert(typename) > 0;


    }

    /**
     * 删除单条新闻类别
     */

    public boolean delById(Integer id){
        if(id == null || id < 0){
            return false;
        }
        return newstypeDao.delById(id) > 0;
    }



    /**
     * 分页查看数据
     */
    public Map<String,Object> getPage(Integer page , Integer size , String typename ){
        //如果前台title上传了一个空字符串做特殊处理赋值为NULL
        if(StringUtil.isEmpty(typename)){
            typename = null;
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
        int count = newstypeDao.getCount(typename);
        List<Newstype> list = newstypeDao.getPage(offset,size,typename);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count", count);
        map.put("data", list);
        return map;


    }


    /**
     * 编辑新闻
     */

    public boolean updateById(Newstype newstype){
        if(null == newstype){
            return false;
        }
        if(null == newstype.getId() || newstype.getId() < 1){
            return false;
        }
        if(StringUtil.isEmpty(newstype.getTypename())){
            return false;
        }
        return newstypeDao.updateById(newstype) > 0 ;
    }


    /**
     *     根据id查看详情
     */

    public Newstype getById(Integer id){
        if(null == id || id < 1){
            return null;
        }
        return newstypeDao.getById(id);
    }






}
