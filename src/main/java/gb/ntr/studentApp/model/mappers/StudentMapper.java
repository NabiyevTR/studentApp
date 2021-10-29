package gb.ntr.studentApp.model.mappers;

import gb.ntr.studentApp.model.repository.Student;
import gb.ntr.studentApp.model.service.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    public static Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    public static StudentDto fromStudent(Student student) {
        var studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }

    public static List<Student> toStudents(List<StudentDto> studentsDto) {
        return studentsDto.stream()
                .map(s -> toStudent(s))
                .collect(Collectors.toList());
    }

    public static List<StudentDto> fromStudents(List<Student> students) {
        return students.stream()
                .map(s -> fromStudent(s))
                .collect(Collectors.toList());
    }
}
