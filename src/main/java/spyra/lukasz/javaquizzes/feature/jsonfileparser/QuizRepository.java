package spyra.lukasz.javaquizzes.feature.jsonfileparser;

import org.springframework.data.jpa.repository.JpaRepository;
import spyra.lukasz.javaquizzes.shared.Quiz;

interface QuizRepository extends JpaRepository<Quiz, Long> {
}
