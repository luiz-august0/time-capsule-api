package time.capsule.api.core.validator;

import time.capsule.api.core.domain.TimeCapsuleDomain;
import time.capsule.api.core.util.DateUtil;
import time.capsule.api.core.util.StringUtil;
import time.capsule.api.infrastructure.exception.exceptions.ValidatorException;

public class TimeCapsuleValidator {

    public void validateSend(TimeCapsuleDomain timeCapsule) {
        validateEmail(timeCapsule.getEmail());

        if (StringUtil.isNullOrEmpty(timeCapsule.getMessage())) {
            throw new ValidatorException("Mensagem da capsula é obrigatória");
        }

        if (timeCapsule.getMessage().length() < 5) {
            throw new ValidatorException("Mensagem da capsula deve ser maior que 5 caracteres");
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
