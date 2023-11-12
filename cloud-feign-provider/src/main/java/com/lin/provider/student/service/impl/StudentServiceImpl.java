package com.lin.provider.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.provider.student.bo.Student;
import com.lin.provider.student.mapper.StudentMapper;
import com.lin.provider.student.service.IStudentService;
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
