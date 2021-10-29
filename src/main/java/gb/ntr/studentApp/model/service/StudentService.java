package gb.ntr.studentApp.model.service;

import gb.ntr.studentApp.exceptions.NoSuchStudentException;


import java.util.List;

public interface StudentService {

    StudentDto findById(int id) throws NoSuchStudentException;

    List<StudentDto> getAll();

    void save(StudentDto studentDto);

    void deleteById(int id);

}
