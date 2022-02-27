package com.isoft.dao;

import com.isoft.entity.Sys;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDao {

    //检查账号是否存在
    @Select("select * from tb_sys where name=#{name}")
    public Sys getByName(@Param("name")String name);



    //检查账号密码

    @Select("select * from tb_sys where name=#{name} and password=#{password}")
    public Sys getByNamePwd(@Param("name")String name,@Param("password")String password);



    /**
     * 新增管理员
     *
     */
    @Insert("insert into tb_sys(name,password,mobile) values(#{name}, #{password} , #{mobile})")
    public int add(@Param("name") String name,@Param("password") String password , @Param("mobile") String mobile) ;



    /**
     * 检查name是否存在
     */

    @Select("select count(*) from tb_sys where name=#{name}")
    public int getCountByName(@Param("name")String name);



    /**
     * id+password的校验
     */
    @Select("select count(*) from tb_sys where id=#{id} and password=#{password}")
    public int checkPwd(@Param("id")Integer id,@Param("password")String password);



    /**
     * 根据id，检查型密码和旧密码是否一致
     */
    @Update("update tb_sys set password=#{password} where id=#{id}")
    public int updatePwd(@Param("id")Integer id,@Param("password")String password);


    /**
     * 查看所有管理员
     */
    @Select("select id ,name , photourl, mobile, email, role, state from tb_sys")
    public List<Sys> getAll();


    /**
     *更新任务状态
     */
    @Update("update tb_sys set state=#{state} where id=#{id}")
    public int updateState(Sys sys);






}
