package time.capsule.api.core.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.messaging.TimeCapsuleMessagingGateway;
import time.capsule.api.core.gateway.repository.TimeCapsuleRepositoryGateway;
import time.capsule.api.core.usecase.validators.TimeCapsuleValidator;
import time.capsule.api.core.util.DateUtil;

@Service
@RequiredArgsConstructor
public class TimeCapsuleSendUseCase {

    private final TimeCapsuleValidator timeCapsuleValidator;
    private final TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway;
    private final TimeCapsuleMessagingGateway timeCapsuleMessagingGateway;

    @Transactional
    public void send(TimeCapsuleEntity timeCapsule) {
        timeCapsuleValidator.validateSend(timeCapsule);
        timeCapsule.setCreatedAt(DateUtil.getDate());

        timeCapsuleRepositoryGateway.save(timeCapsule);
        timeCapsuleMessagingGateway.send(timeCapsule.getId());
    }

}
