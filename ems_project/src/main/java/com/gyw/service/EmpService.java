package com.gyw.service;

import com.gyw.pojo.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> queryAllEmp();

    Emp queryEmpById(String id);

    void addEmp(Emp emp);

    void deleteEmp(String id);

    void updateEmp(Emp emp);
}