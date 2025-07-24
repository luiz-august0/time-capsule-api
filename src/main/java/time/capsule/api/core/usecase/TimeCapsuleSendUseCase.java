package time.capsule.api.core.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.messaging.TimeCapsuleMessagingGateway;
import time.capsule.api.core.gateway.repository.TimeCapsuleRepositoryGateway;
import time.capsule.api.core.usecase.validators.TimeCapsuleValidator;

@Service
@RequiredArgsConstructor
public class TimeCapsuleSendUseCase {

    private final TimeCapsuleValidator timeCapsuleValidator;
    private final TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway;
    private final TimeCapsuleMessagingGateway timeCapsuleMessagingGateway;

    public Long send(TimeCapsuleEntity timeCapsule) {
        timeCapsuleValidator.validateSend(timeCapsule);

        TimeCapsuleEntity timePersisted = timeCapsuleRepositoryGateway.save(timeCapsule);
        timeCapsuleMessagingGateway.send(timePersisted);

        return timePersisted.getId();
    }

}
