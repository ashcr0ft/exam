package pro.sky.exam.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            questions.remove(newQuestion);
        } else throw new RuntimeException("Такого нет");
        return newQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public int getSize() {
        return questions.size();
    }

}
