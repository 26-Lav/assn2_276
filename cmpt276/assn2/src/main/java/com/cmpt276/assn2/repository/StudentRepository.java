package com.cmpt276.assn2.repository;

import com.cmpt276.assn2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

// package com.cmpt276.assn2.repository;

// public class StudentRepository {

// }
