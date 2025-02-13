package pro.sky.exam.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.exam.service.ExaminerService;
import pro.sky.exam.service.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")

public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
