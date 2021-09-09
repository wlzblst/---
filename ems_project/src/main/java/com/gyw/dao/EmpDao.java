package com.gyw.dao;

import com.gyw.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpDao {

    List<Emp> queryAllEmp();

    Emp queryEmpById(String id);

    void addEmp(Emp emp);

    void deleteEmp(String id);

    void updateEmp(Emp emp);


}