package com.julio.matricula.Matricula.Service;

import com.julio.matricula.Matricula.DTO.CreateStudentRequestDto;
import com.julio.matricula.Matricula.DTO.StudentDto;
import com.julio.matricula.Matricula.Model.StudentModel;
import com.julio.matricula.Matricula.Repository.StudentRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto createStudent(CreateStudentRequestDto requestDto) {
        //Validação se o email já existe
        if (studentRepository.existsByEmail(requestDto.email())) {
            throw new EntityExistsException("Já existe um aluno cadastrado com este email " + requestDto.email());
        }
        //Criação de uma nova instancia da Entidade StudentModel
        StudentModel newStudent = new StudentModel();

        //Copiar os dados do DTO de requisição para a nova entidade
        newStudent.setName(requestDto.name());
        newStudent.setEmail(requestDto.email());

        //Salvar a nova entidade no banco de dados
        StudentModel savedStudent = studentRepository.save(newStudent);

        //Converter a entidade salva para o DTO de resposta e retorna-lo
        return new StudentDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getEmail()
        );
    }

    public List<StudentDto> findAllStudents(){
        //List<StudentModel> studentList = studentRepository.findAll();
        var studentList = studentRepository.findAll();

        return studentList.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }
}