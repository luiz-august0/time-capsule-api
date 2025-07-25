package time.capsule.api.core.usecase.validators;

import org.springframework.stereotype.Component;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.util.DateUtil;
import time.capsule.api.core.util.StringUtil;
import time.capsule.api.infrastructure.exception.exceptions.ValidatorException;

@Component
public class TimeCapsuleValidator {

    public void validateSend(TimeCapsuleEntity timeCapsule) {
        validateEmail(timeCapsule.getEmail());

        if (StringUtil.isNullOrEmpty(timeCapsule.getMessage())) {
            throw new ValidatorException("Mensagem da capsula é obrigatória");
        }

        if (timeCapsule.getMessage().length() < 5) {
            throw new ValidatorException("Mensagem da capsula deve ser maior que 5 caracteres");
        }

        if (StringUtil.isNullOrEmpty(timeCapsule.getIaQuestion())) {
            throw new ValidatorException("Pergunta para IA é obrigatória");
        }

        if (timeCapsule.getIaQuestion().length() < 5) {
            throw new ValidatorException("Pergunta para IA deve ser maior que 5 caracteres");
        }

        if (timeCapsule.getDateToSend() == null) {
            throw new ValidatorException("Data da capsula é obrigatória");
        }

        if (timeCapsule.getDateToSend().before(DateUtil.getDate())) {
            throw new ValidatorException("Data da capsula deve ser uma data futura");
        }
    }

    public void validateEmail(String email) {
        if (!StringUtil.isValidEmail(email)) {
            throw new ValidatorException("E-mail não foi informado ou é inválido");
        }
    }

}
