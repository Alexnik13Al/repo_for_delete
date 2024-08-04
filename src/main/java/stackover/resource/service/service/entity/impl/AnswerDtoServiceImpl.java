package stackover.resource.service.service.entity.impl;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stackover.resource.service.feign.AuthServiceClient;
import stackover.resource.service.repository.dto.AnswerDtoRepository;
import stackover.resource.service.service.dto.response.AnswerResponseDto;
import stackover.resource.service.service.entity.AnswerDtoService;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class AnswerDtoServiceImpl implements AnswerDtoService {

    @Parameter(description = "репозиторий DTO ответов")
    private final AnswerDtoRepository answerDtoRepository;

    @Parameter(description = "сервисный слой проверки авторизации")
    private final AuthServiceClient authServiceClient;

    @Transactional(readOnly = true)
    @Override
    public List<AnswerResponseDto> getAnswersDtoByQuestionId(Long questionId, Long accountId) {
        //todo реализовать поиск аккаунта по id через auth-service
        if (!authServiceClient.isAccountExist(accountId)) {
            //todo реализовать заглушку
            log.warn("Пользователь с id = {} не найден", accountId);
            accountId = 100L;
        }
        return answerDtoRepository.getAnswersDtoByQuestionId(questionId, accountId);
    }
}
