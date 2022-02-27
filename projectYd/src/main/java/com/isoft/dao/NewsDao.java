package com.isoft.dao;

import com.isoft.entity.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {

    /**
     * 添加
     */

    @Insert("insert into tb_news values(null,#{typeid},#{title},#{content},#{publishdt},#{comefrom})")
    public int insert(News news);

    /**
     * 分页查看
     */

    @Select(
            "<script>"+
                    " select id , typeid , title , publishdt , comefrom" +
            " from tb_news" +
            " <where>" +
            " <if test=\"null != typeid\">" +
            " and typeid=#{typeid}" +
            " </if>" +
            " <if test=\"null != title\">" +
            " <bind name=\"titlekey\" value=\"'%'+title+'%'\"/>" +
            " and title like #{titlekey}" +
            " </if>" +
            " </where>" +
            " order by publishdt desc" +
            " limit #{offset} , #{size}"
                    +"</script>"
    )
    public List<News> getPage(@Param("offset")Integer offset,@Param("size")Integer size , @Param("title") String title,@Param("typeid")Integer typeid);




   // public List<News> getPage(@Param("offset")Integer offset,@Param("size"))


    /**
     * 查看满足条件的记录个数
     */

    @Select(
            "<script>"+
                    " select count(*)" +
                    " from tb_news" +
                    " <where>" +
                    " <if test=\"null != typeid\">" +
                    " and typeid=#{typeid}" +
                    " </if>" +
                    " <if test=\"null != title\">" +
                    " <bind name=\"titlekey\" value=\"'%'+title+'%'\"/>" +
                    " and title like #{titlekey}" +
                    " </if>" +
                    " </where>"
                    +"</script>"
    )
    public int getCount(@Param("title")String title,@Param("typeid")Integer typeid);

    /**
     * 根据id查看详情
     */

@Select("select * from tb_news where id=#{id}")
    public News getById(Integer id);


//6月15日 删除操作




    /**
     *  根据id更新新闻 title , content , comefrom
     */
    @Update("update tb_news set title=#{title} , content=#{content} , comefrom=#{comefrom} where id=#{id}")
    public int updateById(News news);

    /**
     *根据id删除单条新闻
     */
    @Delete(" delete from tb_news where id=#{id}")
    public int delById(Integer id);

    /**
     * 根据id删除多条记录
     */

    @Delete("<script>"+
                "delete from tb_news " +
            "    where id in " +
            "    <foreach collection=\"array\" item=\"id\" separator=\",\" open=\"(\" close=\")\" > " +
            "        #{id} " +
            "    </foreach>"
            +"</script>")
    public int delByIds(Integer[] ids);


    /**
     *  根据id更新新闻 点击量
     */
    @Update("update tb_news set addTop=addTop+1  where id=#{id}")
    public int updateTop(Integer id);


}



