package com.lin.student.service.impl;

import com.lin.student.bo.Student;
import com.lin.student.mapper.StudentMapper;
import com.lin.student.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author linmengmeng
 * @since 2023-11-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
