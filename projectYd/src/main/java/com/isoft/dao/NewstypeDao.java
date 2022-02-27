package com.isoft.dao;

import com.isoft.entity.News;
import com.isoft.entity.Newstype;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewstypeDao {
    /**
     *查寻所有新闻类别
     * @return
     */
    @Select("select * from tb_newstype")
    public List<Newstype> all();

    /**
     * 添加新闻类别
     *
     */
    @Insert("insert into tb_newstype values(null,#{typename})")
    public int insert(String typename);

    /**
     * 删除新闻类别
     */
    @Delete(" delete from tb_newstype where id=#{id}")
    public int delById(Integer id);



    /**
     * 分页查看
     */

    @Select(
            "<script>"+
                    " select id , typename" +
                    " from tb_newstype" +
                    " <where>" +
                    " <if test=\"null != typename\">" +
                    " <bind name=\"typenamekey\" value=\"'%'+typename+'%'\"/>" +
                    " and typename like #{typenamekey}" +
                    " </if>" +
                    " </where>" +
                    " order by id desc" +
                    " limit #{offset} , #{size}"
                    +"</script>"
    )
    public List<Newstype> getPage(@Param("offset")Integer offset,@Param("size")Integer size , @Param("typename") String typename);

    /**
     * 查看满足条件的记录个数
     */

    @Select(
            "<script>"+
                    " select count(*)" +
                    " from tb_newstype" +
                    " <where>" +
                    " <if test=\"null != typename\">" +
                    " <bind name=\"typenamekey\" value=\"'%'+typename+'%'\"/>" +
                    " and typename like #{typenamekey}" +
                    " </if>" +
                    " </where>"
                    +"</script>"
    )
    public int getCount(@Param("typename")String typename);


    /**
     *更新
     */

    @Update("update tb_newstype set typename=#{typename}  where id=#{id}")
    public int updateById(Newstype newstype);



    /**
     * 根据id查看详情
     */

    @Select("select * from tb_newstype where id=#{id}")
    public Newstype getById(Integer id);




}


