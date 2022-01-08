package spyra.lukasz.javaquizzes.quizselector.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
class QuizView {

    private long id;

    private String title;

    private int score;

    private LocalDateTime created;

    private LocalDateTime updated;

}
