package com.julio.matricula.Matricula.DTO;

import java.util.Set;

public record CourseWithStudentsDto(
        Long id,
        String name,
        String instructor,
        Set<StudentDto> enrolledStudents) {
}
