package time.capsule.api.core.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.repository.TimeCapsuleRepositoryGateway;
import time.capsule.api.core.usecase.validators.TimeCapsuleValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeCapsuleGetByEmailUseCase {

    private final TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway;
    private final TimeCapsuleValidator timeCapsuleValidator;

    public List<TimeCapsuleEntity> getAllByEmail(String email) {
        timeCapsuleValidator.validateEmail(email);
        return timeCapsuleRepositoryGateway.findAllByEmail(email);
    }

}
