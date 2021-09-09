package com.gyw.service.impl;

import com.gyw.dao.EmpDao;
import com.gyw.pojo.Emp;
import com.gyw.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpDao empDao;


    @Override
    public List<Emp> queryAllEmp() {
        return empDao.queryAllEmp();
    }

    @Override
    public Emp queryEmpById(String id) {
        return empDao.queryEmpById(id);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.addEmp(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empDao.deleteEmp(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }
}