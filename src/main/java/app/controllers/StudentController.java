package app.controllers;

import app.model.Student;
import app.services.StudentServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stud")
public class StudentController {

    private final StudentServis studentServis;

    @Autowired
    public StudentController(StudentServis studentServis) {
        this.studentServis = studentServis;
    }

//    @GetMapping
//    public ModelAndView showIndex(HttpSession session, HttpServletRequest request){
//        ModelAndView result = new ModelAndView("index");
//        result.addObject("path", request.getContextPath());
//        return result;
//    }

//    @GetMapping
//    public String showIndex(HttpSession session, HttpServletRequest request){
////        ModelAndView result = new ModelAndView("index");
////        result.addObject("path", request.getContextPath());
//        return "index";
//    }

    @GetMapping("/showall")
    public String show(Model model){
        model.addAttribute("studentList",studentServis.getList());
        return "index";
    }

//    @GetMapping("/showall")
//    public ModelAndView show(HttpSession session, HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("studentList",studentServis.getList());
//        return modelAndView;
//    }

    @PostMapping("/add")
    public String add(@RequestParam("id" ) Long id, @RequestParam("name" ) String name, @RequestParam("age" ) Integer age){
        Student student = new Student(id, name, age);
        studentServis.addStudent(student);
        return "redirect:/stud/showall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        studentServis.remove(id);
        return "redirect:/stud/showall";
    }
}