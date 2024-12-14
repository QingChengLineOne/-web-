package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    //public void deleteById(Integer id);
    public int deleteById(Integer id);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
    "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public int insert(Emp emp);


    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public int update(Emp emp);

//    @Results({
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime"),
//    })
    @Select("select * from emp where id = #{id}")
    public Emp selectById(Integer id);

//    @Select("select *\n" +
////            "from emp\n" +
////            "where name like '%${name}%'\n" +
////            "  and gender = #{gender}\n" +
////            "  and entrydate between #{begin} and #{end}\n" +
////            "order by update_time desc;")
//@Select("select *\n" +
//        "from emp\n" +
//        "where name like concat('%',#{name},'%')\n" +
//        "  and gender = #{gender}\n" +
//        "  and entrydate between #{begin} and #{end}\n" +
//        "order by update_time desc;")
//    public List<Emp> selectAll(String name, Short gender, LocalDate begin, LocalDate end);


    public List<Emp> selectAll(String name, Short gender, LocalDate begin, LocalDate end);

    public int update02(Emp emp);

    public void deleteByIds(List<Integer> ids);
}
