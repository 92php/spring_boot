package com.imooc.springbootlearn;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from students where id = #{id}")
    Student findById(Integer id);
}
