package com.amzmall.project.qna.repository;

import com.amzmall.project.qna.domain.entity.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>  {
	Optional<Question> findByQuestionSq(Long QuestionSq);
    List<Question> findAllByCustomerEmail(String customerEmail, Pageable pageable);
}
