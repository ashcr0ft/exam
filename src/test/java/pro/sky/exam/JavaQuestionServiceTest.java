package pro.sky.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.exam.service.JavaQuestionService;
import pro.sky.exam.service.Question;
import pro.sky.exam.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.exam.Constants.*;


import java.util.List;
import java.util.stream.Stream;

public class JavaQuestionServiceTest {
    private final QuestionService out = new JavaQuestionService();

    @MethodSource("provideArguments")
    @ParameterizedTest
    public void addQuestionTest(String question, String answer, Question fullQuestion) {
        assertEquals(out.add(question, answer), fullQuestion);
    }

    @MethodSource("provideArguments")
    @ParameterizedTest
    public void removeQuestionTest(String question, String answer, Question fullQuestion) {
        out.add(question, answer);
        out.remove(question, answer);
        assertFalse(out.getAll().contains(fullQuestion));
    }

    @Test
    public void getAllTest() {
        out.add(QUESTION1, ANSWER1);
        out.add(QUESTION2, ANSWER2);
        out.add(QUESTION3, ANSWER3);
        assertTrue(out.getAll().containsAll(List.of(FULLQUESTION1, FULLQUESTION2, FULLQUESTION3)));
    }

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(QUESTION1, ANSWER1, FULLQUESTION1),
                Arguments.of(QUESTION2, ANSWER2, FULLQUESTION2),
                Arguments.of(QUESTION3, ANSWER3, FULLQUESTION3));
    }
}
