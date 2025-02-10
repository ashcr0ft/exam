package pro.sky.exam.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.Service.Question;
import pro.sky.exam.Service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public String addQuestion(@RequestParam String question, String answer) {
        return service.add(question, answer).toString();
    }

    @GetMapping("/java/remove")
    public String removeQuestion(@RequestParam String question, String answer) {
        return service.remove(question, answer).toString();
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

}
