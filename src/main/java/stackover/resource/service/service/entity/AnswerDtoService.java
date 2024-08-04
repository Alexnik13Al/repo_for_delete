package stackover.resource.service.service.entity;

import stackover.resource.service.service.dto.response.AnswerResponseDto;
import java.util.List;

public interface AnswerDtoService {

    List<AnswerResponseDto> getAnswersDtoByQuestionId(Long questionId, Long accountId);

}
