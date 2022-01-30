package spyra.lukasz.javaquizzes.feature.jsonparser;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import spyra.lukasz.javaquizzes.shared.Answer;
import spyra.lukasz.javaquizzes.shared.Question;
import spyra.lukasz.javaquizzes.shared.Quiz;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class QuizMapperMapStruct {

    abstract Quiz quizJsonToQuiz(QuizJson quizJson);

    abstract List<Question> questionJsonToQuestion(List<QuestionJson> questionsJson);

    abstract List<Answer> answerJsonToAnswer(List<AnswerJson> answersJson);

    @AfterMapping
    protected void bindQuestionsToQuiz(@MappingTarget Quiz quiz) {
        List<Question> questNotBound = quiz.getQuestions();
        List<Question> questBound = questNotBound.stream()
                .peek(q -> q.setQuiz(quiz))
                .map(this::bindAnswerToQuestion)
                .collect(Collectors.toUnmodifiableList());
        quiz.setQuestions(questBound);
    }

    private Question bindAnswerToQuestion(final Question question) {
        List<Answer> answersBound = question.getAnswers().stream()
                .peek(a -> a.setQuestion(question))
                .collect(Collectors.toUnmodifiableList());
        question.setAnswers(answersBound);
        return question;
    }
}
