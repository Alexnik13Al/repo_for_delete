package stackover.resource.service.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stackover.resource.service.service.dto.response.AnswerResponseDto;
import java.util.List;

@Repository
public interface AnswerDtoRepository extends JpaRepository<AnswerResponseDto, Long> {

    @Query("""
                SELECT new stackover.resource.service.service.dto.response.AnswerResponseDto (
                    Answer.id,
                    Answer.account_id,
                    Answer.question_id,
                    Answer.html_body,
                    Answer.persist_date,
                    Answer.is_helpful,
                    Answer.date_accept_time,
                    (SELECT SUM(CAST(Votes_on_answers.vote_type_answer AS bigint)) AS count_valuable FROM Votes_on_answers JOIN Answer ON Votes_on_answers.answer_id = Answer.id),
                    (SELECT SUM(Reputation.count) AS count_user_reputation FROM Reputation JOIN Answer ON Reputation.answer_id = Answer.id),
                    (SELECT User_entity.image_link FROM User_entity JOIN Answer ON User_entity.id = Answer.account_id),
                    (SELECT User_entity.nickname FROM User_entity JOIN Answer ON User_entity.id = Answer.account_id),
                    (SELECT COUNT(Votes_on_answers.id) AS countVote FROM Votes_on_answers JOIN Answer ON Votes_on_answers.answer_id = Answer.id),
                    (SELECT Votes_on_answers.vote_type_answer FROM Votes_on_answers JOIN Answer ON Votes_on_answers.answer_id = Answer.id JOIN User_entity ON User_entity.id = Votes_on_answers.user_id WHERE User_entity.id = :accountId)
                ) FROM Answer WHERE Answer.question_id = :questionId
                """)
    List<AnswerResponseDto> getAnswersDtoByQuestionId(@Param("questionId") Long questionId, @Param("accountId") Long accountId);

}
