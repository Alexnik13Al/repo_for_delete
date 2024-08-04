package stackover.resource.service.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stackover.resource.service.service.dto.response.AnswerResponseDto;
import java.util.List;

@Repository
public interface AnswerDtoRepository extends JpaRepository<AnswerResponseDto, Long> {

    @Query("select p from Post p where p.user.id=:id and p.title like :title")
    List<AnswerResponseDto> getAnswersDtoByQuestionId(@Param("questionId") Long questionId, @Param("accountId") Long accountId);

}
