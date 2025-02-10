package pro.sky.exam.Service;

import java.util.Collection;

public interface QuestionService {
    Question getRandomQuestion();

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    int getSize();
}
