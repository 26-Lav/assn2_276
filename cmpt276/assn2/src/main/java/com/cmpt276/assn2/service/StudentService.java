package com.cmpt276.assn2.service;

import com.cmpt276.assn2.entity.Student;
import com.cmpt276.assn2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudentById(Long id) {
    return studentRepository.findById(id);
  }

  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }

}

// package com.cmpt276.assn2.service;

// public class StudentService {

// }
