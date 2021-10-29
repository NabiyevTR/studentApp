package gb.ntr.studentApp.model.service;

import gb.ntr.studentApp.exceptions.NoSuchStudentException;
import gb.ntr.studentApp.model.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static gb.ntr.studentApp.model.mappers.StudentMapper.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public StudentDto findById(int id) throws NoSuchStudentException {
        return fromStudent(
                repository.findById(id).orElseThrow(() -> new NoSuchStudentException(id))
        );
    }

    @Override
    public List<StudentDto> getAll() {
        return fromStudents(
                repository.findAll()
        );
    }

    @Override
    public void save(StudentDto studentDto) {
        repository.save(
                toStudent(studentDto)
        );
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }


}
