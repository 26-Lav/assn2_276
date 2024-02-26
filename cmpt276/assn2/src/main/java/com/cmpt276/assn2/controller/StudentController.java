package com.cmpt276.assn2.controller;

import com.cmpt276.assn2.entity.Student;
import com.cmpt276.assn2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/add")
  public String showAddStudentForm(Model model) {
    model.addAttribute("student", new Student());
    return "add-student";
  }

  @PostMapping
  public String addStudent(@ModelAttribute Student student) {
    studentService.saveStudent(student);
    return "redirect:/students";
  }

  @GetMapping("/edit/{id}")
  public String showEditStudentForm(@PathVariable Long id, Model model) {
    Student student = studentService.getStudentById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    model.addAttribute("student", student);
    return "edit-student";
  }

  @PostMapping("/update/{id}")
  public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
    student.setId(id);
    studentService.saveStudent(student);
    return "redirect:/students";
  }

  @GetMapping
  public String listStudents(Model model) {
    List<Student> students = studentService.getAllStudents();
    model.addAttribute("students", students);
    return "list-students";
  }

  @GetMapping("/{id}")
  public String getStudentById(@PathVariable Long id, Model model) {
    Student student = studentService.getStudentById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    model.addAttribute("student", student);
    return "student-detail";
  }

  // @PostMapping("/delete/{id}")
  // public String deleteStudent(@PathVariable Long id, Model model) {
  // studentService.deleteStudent(id);
  // return "redirect:/students";
  // }

  @DeleteMapping("/{id}")
  public String deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return "redirect:/students";
  }

}
