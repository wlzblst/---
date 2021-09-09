package com.gyw.controller;

import com.gyw.pojo.Emp;
import com.gyw.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/findAll")
    public String queryAllEmp(Model model){
        model.addAttribute("emps",empService.queryAllEmp());
        return "ems/emplist";
    }

    @PostMapping("/save")
    public String save(Emp emp){
        empService.addEmp(emp);
        return "redirect:/emp/findAll";
    }

    @GetMapping("/delete")
    public String deleteEmp(String id){
        empService.deleteEmp(id);
        return "redirect:/emp/findAll";
    }

    @GetMapping("/find")
    public String findById(String id, Model model){
        Emp emp = empService.queryEmpById(id);
        model.addAttribute("emp",emp);
        return "ems/updateEmp";
    }

    @PostMapping("/update")
    public String updateEmp(Emp emp){
        System.out.println("emp = " + emp);
        empService.updateEmp(emp);
        return "redirect:/emp/findAll";
    }
}