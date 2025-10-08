package com.julio.matricula.Matricula.Service;

import com.julio.matricula.Matricula.DTO.CourseDto;
import com.julio.matricula.Matricula.DTO.CourseWithStudentsDto;
import com.julio.matricula.Matricula.DTO.CreateCourseRequestDto;
import com.julio.matricula.Matricula.DTO.StudentDto;
import com.julio.matricula.Matricula.Model.CourseModel;
import com.julio.matricula.Matricula.Model.StudentModel;
import com.julio.matricula.Matricula.Repository.CourseRepository;
import com.julio.matricula.Matricula.Repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public CourseDto createCourse(CreateCourseRequestDto requestDto) {

        CourseModel newCourse = new CourseModel();

        newCourse.setName(requestDto.name());
        newCourse.setInstructor(requestDto.instructor());

        CourseModel savedCourse = courseRepository.save(newCourse);

        return new CourseDto(
                savedCourse.getId(),
                savedCourse.getName(),
                savedCourse.getInstructor()
        );
    }

    public List<CourseDto> findAllCourses(){

            var coursesList = courseRepository.findAll();

            return coursesList.stream()
                    .map(course -> new CourseDto(
                            course.getId(),
                            course.getName(),
                            course.getInstructor()
                    ))
                    .toList();
    }

    public CourseWithStudentsDto enrollStudentInCourse (long courseId, long studentId){

        //Encontrar o curso e o aluno e lançar a exceção caso não encontrar algum dos dois.
        CourseModel course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course with id: " + courseId + " not found"));

        StudentModel student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id: " + studentId + " not found"));

        //Realizar a matrícula, adicionando o student ao conjunto de alunos do curso
        course.getEnrolledStudents().add(student);
        //Salvamos a entidade Course
        CourseModel updatedCourse = courseRepository.save(course);
        //Retornamos a resposta convertendo para o DTO
        return convertToCourseWithStudentsDto(updatedCourse);

    }

    // Método auxiliar para ajudar na conversão para DTO
    private CourseWithStudentsDto convertToCourseWithStudentsDto(CourseModel course) {
        // Converte a lista de entidades de alunos para uma lista de DTOs de alunos
        Set<StudentDto> studentDtos = course.getEnrolledStudents().stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .collect(Collectors.toSet());

        // Cria e retorna o DTO principal do curso com a lista de alunos convertida
        return new CourseWithStudentsDto(
                course.getId(),
                course.getName(),
                course.getInstructor(),
                studentDtos
        );
    }

    public Optional<CourseWithStudentsDto> findCourseWithStudents(long courseId){
        //Busca a entidade CourseModel pelo ID. O resultado é um Optional.
        Optional<CourseModel> courseOptional = courseRepository.findById(courseId);

        //Usa o método .map() do Optional para transformar o resultado.
        return courseOptional.map(this::convertToCourseWithStudentsDto);
    }

}


