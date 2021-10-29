package gb.ntr.studentApp.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoSuchStudentException extends Exception {

    private int id;

    @Override
    public String getMessage() {
        return "Student with id=" +  id + " does't exist. ";
    }
}
