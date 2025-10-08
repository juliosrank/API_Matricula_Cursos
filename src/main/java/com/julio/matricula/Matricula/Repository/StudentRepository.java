package com.julio.matricula.Matricula.Repository;

import com.julio.matricula.Matricula.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    boolean existsByEmail(String email);
}
