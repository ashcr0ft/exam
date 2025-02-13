package pro.sky.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.service.Question;
import pro.sky.exam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {
        return service.remove(question, answer);
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

}
