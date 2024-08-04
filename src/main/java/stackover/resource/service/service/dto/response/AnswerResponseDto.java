package stackover.resource.service.service.dto.response;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import stackover.resource.service.entity.question.answer.VoteTypeAnswer;

import java.time.LocalDateTime;

@Schema(description = "запрос ответа")
public record AnswerResponseDto() {

    @Parameter(description = "id ответа на вопрос")
    private static Long id;

    @Parameter(description = "id пользователя")
    private static Long userId;

    @Parameter(description = "id вопроса")
    private static Long questionId;

    @Parameter(description = "текст ответа")
    @NotEmpty
    @NotBlank
    @NotNull
    private static String body;

    @Parameter(description = "дата создания ответа")
    private static LocalDateTime persistDate;

    @Parameter(description = "польза ответа")
    private static Boolean isHelpful;

    @Parameter(description = "дата решения вопроса")
    private static LocalDateTime dateAccept;

    @Parameter(description = "рейтинг ответа")
    private static Long countValuable;

    @Parameter(description = "рейтинг юзера")
    private static Long countUserReputation;

    @Parameter(description = "ссылка на картинку пользователя")
    private static String image;

    @Parameter(description = "никнейм пользователя")
    private static String nickname;

    @Parameter(description = "количество голосов")
    private static Long countVote;

    @Parameter(description = "тип голоса")
    private static VoteTypeAnswer voteTypeAnswer;


}
