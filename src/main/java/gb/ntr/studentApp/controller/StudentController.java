package gb.ntr.studentApp.controller;

import gb.ntr.studentApp.exceptions.NoSuchStudentException;
import gb.ntr.studentApp.model.service.StudentDto;
import gb.ntr.studentApp.model.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("newStudent", new StudentDto());
        return "students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(Model model, @PathVariable("id") int id) throws NoSuchStudentException {
        model.addAttribute("student", studentService.findById(id));
        return "student_update";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") StudentDto studentDto) {
        studentService.save(studentDto);
        return "redirect:/student";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute("product") StudentDto studentDto,
                         @PathVariable("id") int id)  {
        studentDto.setId(id);
        studentService.save(studentDto);
        return "redirect:/student";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return "redirect:/student";
    }

}
