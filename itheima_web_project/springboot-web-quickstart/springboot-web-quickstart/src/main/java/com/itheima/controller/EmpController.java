package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
//    @RequestMapping("/listEmp")
//    public Result list(){
//        //1、加载并解析emp.xml
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);
//        //2、对数据进行转换处理
//        emplist.stream().forEach(emp -> {
//            String gender = emp.getGender();
//            if ("1".equals(gender)) {
//                emp.setGender("男");
//            }else if ("0".equals(gender)) {
//                emp.setGender("女");
//            }
//
//            String job = emp.getJob();
//            if("1".equals(job)) {
//                emp.setJob("讲师");
//            }else if ("2".equals(job)) {
//                emp.setJob("班主任");
//            }else if ("3".equals(job)) {
//                emp.setJob("就业指导");
//            }
//        });
//        //3、响应数据
//        return Result.success(emplist);
//    }

    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> emps = empService.listEmp();
        //3、响应数据
        return Result.success(emps);
    }
}
