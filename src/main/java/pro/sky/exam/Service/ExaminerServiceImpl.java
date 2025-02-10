package pro.sky.exam.Service;

import org.springframework.stereotype.Service;
import pro.sky.exam.Exception.InvalidRequestException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <= 0 || size < amount) {
            throw new InvalidRequestException("Превышено запрашиваемое количество вопросов");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }

}
