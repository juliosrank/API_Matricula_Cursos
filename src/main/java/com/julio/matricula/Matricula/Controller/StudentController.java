package com.julio.matricula.Matricula.Controller;

import com.julio.matricula.Matricula.DTO.CreateStudentRequestDto;
import com.julio.matricula.Matricula.DTO.StudentDto;
import com.julio.matricula.Matricula.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Criar novo aluno
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentRequestDto createStudentRequestDto) {
        StudentDto newStudent = studentService.createStudent(createStudentRequestDto);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    //Listar todos os alunos @Get
    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<StudentDto> students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }

}
