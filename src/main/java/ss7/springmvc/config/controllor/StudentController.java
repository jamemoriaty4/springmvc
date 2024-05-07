package ss7.springmvc.config.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ss7.springmvc.config.model.Student;
import ss7.springmvc.config.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController { // gọi sang service
    @Autowired
    private IStudentService studentService;
    //    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "name") String sort, @RequestParam(defaultValue = "ASC") String by,Model model) {
        List<Student> list = studentService.findAll(sort,by);
        model.addAttribute("students", list);
        return "student/list";
    }
    @RequestMapping("/add")
    public String add(){
        return "student/add";
    }
    @PostMapping("/add")
    public  String doAdd(@ModelAttribute Student student){ // mapping theo tên thuộc tính
        studentService.add(student);
        return "redirect:/students/list";
    }
    @GetMapping("/edit") // lấy ra thông tin cần sửa
    public  String edit(@RequestParam Integer id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "student/edit";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Student student){
        studentService.update(student);
        return "redirect:/students/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

}