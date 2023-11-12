package com.lin.student.controller;


import com.lin.common.vo.ApiR;
import com.lin.student.bo.Student;
import com.lin.student.service.IStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author linmengmeng
 * @since 2023-11-12
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @GetMapping("/queryList")
    public ApiR queryList(){
        List<Student> studentList = studentService.list();
        return ApiR.ok().data(studentList);
    }

}
