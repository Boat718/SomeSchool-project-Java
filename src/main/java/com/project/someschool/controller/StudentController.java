package com.project.someschool.controller;

import ch.qos.logback.core.model.Model;
import com.project.someschool.model.Person;
import com.project.someschool.repository.CoursesRepository;
import com.project.someschool.repository.EazyClassRepository;
import com.project.someschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession httpSession){
        Person person = (Person) httpSession.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        modelAndView.addObject("person",person);
        return modelAndView;
    }

}
