package stackover.resource.service.rest.out;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stackover.resource.service.service.dto.response.AnswerResponseDto;
import stackover.resource.service.service.entity.AnswerDtoService;

import java.util.List;

@RestController
@Tag(name = "ResourceAnswerController", description = "Answer API")
@Slf4j
@AllArgsConstructor
@RequestMapping("api/user/question/{questionId}/answer")
public class ResourceAnswerController {

    @Parameter(description = "сервисный слой DTO ответов")
    private final AnswerDtoService answerDtoService;

    @Operation(description = "возвращение списка всех ответов на вопрос указанного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный возврат"),
            @ApiResponse(responseCode = "404", description = "Аккаунт не найден")
    })
    public ResponseEntity<List<AnswerResponseDto>> getAllAnswers(@Parameter(description = "идентификатор аккаунта пользователя") @RequestParam @Positive Long accountId, @Parameter(description = "идентификатор вопроса") @PathVariable @NotNull Long questionId) {

        log.info("Возврат списка AnswerResponseDTO пользователя с accountId = {} и с questionId = {}", accountId, questionId);
        List<AnswerResponseDto> answerResponseDtoList = answerDtoService.getAnswersDtoByQuestionId(questionId, accountId);
        return new ResponseEntity<>(answerResponseDtoList, HttpStatus.OK);

    }
}
