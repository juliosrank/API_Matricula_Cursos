package com.julio.matricula.Matricula.Controller;


import com.julio.matricula.Matricula.DTO.CourseDto;
import com.julio.matricula.Matricula.DTO.CourseWithStudentsDto;
import com.julio.matricula.Matricula.DTO.CreateCourseRequestDto;
import com.julio.matricula.Matricula.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Criar novo curso @Post
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CreateCourseRequestDto requestDto) {
        CourseDto newCourse = courseService.createCourse(requestDto);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    //Listar todos os cursos @Get
    @GetMapping
    public ResponseEntity<List<CourseDto>> findAllCourses() {
        List<CourseDto> courses = courseService.findAllCourses();
        return ResponseEntity.ok(courses);
    }

    //Matricular aluno
    @PostMapping("/{courseId}/enroll/{studentId}")
    public ResponseEntity<CourseWithStudentsDto> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId) {

        CourseWithStudentsDto updatedCourse = courseService.enrollStudentInCourse(courseId, studentId);
        return ResponseEntity.ok(updatedCourse);
    }

    //Consultar alunos de um curso
    @GetMapping("/{courseId}/students")
    public ResponseEntity<CourseWithStudentsDto> findCourseWithStudents(@PathVariable Long courseId) {
        // O serviço retorna um Optional, então precisamos tratar o caso "não encontrado"
        return courseService.findCourseWithStudents(courseId)
                .map(courseDto -> ResponseEntity.ok(courseDto)) // Se encontrar, retorna 200 OK com o DTO
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }
}
