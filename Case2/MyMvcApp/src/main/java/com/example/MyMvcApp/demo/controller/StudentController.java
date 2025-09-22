package com.example.MyMvcApp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MyMvcApp.demo.model.Student;
import com.example.MyMvcApp.demo.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // List
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", repo.findAll());
        return "students";
    }

    // Form thêm
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    // Lưu student
    @PostMapping
    public String save(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/students";
    }

// Form sửa
@GetMapping("/edit/{id}")
public String editForm(@PathVariable("id") Long id, Model model) {
    model.addAttribute("student", repo.findById(id).orElseThrow());
    return "student_form";
}


    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/students";
    }
}
