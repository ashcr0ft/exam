package pro.sky.exam;

import org.junit.jupiter.api.Test;
import pro.sky.exam.service.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.sky.exam.Constants.*;

public class ExaminerServiceImplTest {


    private final QuestionService questionService = new JavaQuestionService();
    private final ExaminerService out = new ExaminerServiceImpl(questionService);

    @Test
    public void getQuestionsTest() {
        questionService.add(QUESTION1, ANSWER1);
        questionService.add(QUESTION2, ANSWER2);
        questionService.add(QUESTION3, ANSWER3);
        assertTrue(out.getQuestions(3).containsAll(List.of(FULLQUESTION1, FULLQUESTION2, FULLQUESTION3)));

    }
}
