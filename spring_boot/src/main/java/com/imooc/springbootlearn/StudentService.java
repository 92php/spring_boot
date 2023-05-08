package com.imooc.springbootlearn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;


    public Student findStudent(Integer id){
        return studentMapper.findById(id);
    }
}
