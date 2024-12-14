package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test() {
        int delete = empMapper.deleteById(16);
        System.out.println(delete);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("zhangsansan");
        emp.setName("张三");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("lisisi");
        emp.setName("李四");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.selectById(18);
        System.out.println(emp);
    }

    @Test
    public void testSelectAll() {
        //List<Emp> emp = empMapper.selectAll("张",(short)1,LocalDate.of(2000,1,1),LocalDate.of(2020,1,1));
        List<Emp> emp = empMapper.selectAll("张",null,null,null);
        System.out.println(emp);
    }

    @Test
    public void testUpdate02() {
        Emp emp = new Emp();
        emp.setId(1);
        emp.setUsername("你好呀");
        emp.setName("你好呀");
        emp.setGender((short)2);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update02(emp);
    }

    @Test
    public void delete() {
        List<Integer> ids = Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }




}
