package time.capsule.api.core.usecase;

import time.capsule.api.core.domain.TimeCapsuleDomain;
import time.capsule.api.core.gateway.TimeCapsuleMessagingGateway;
import time.capsule.api.core.gateway.TimeCapsuleRepositoryGateway;
import time.capsule.api.core.validator.TimeCapsuleValidator;

public class TimeCapsuleSendUseCase {

    private final TimeCapsuleValidator timeCapsuleValidator;
    private final TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway;
    private final TimeCapsuleMessagingGateway timeCapsuleMessagingGateway;

    public TimeCapsuleSendUseCase(TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway,
                                  TimeCapsuleMessagingGateway timeCapsuleMessagingGateway) {
        this.timeCapsuleRepositoryGateway = timeCapsuleRepositoryGateway;
        this.timeCapsuleMessagingGateway = timeCapsuleMessagingGateway;
        this.timeCapsuleValidator = new TimeCapsuleValidator();
    }

    public TimeCapsuleDomain send(TimeCapsuleDomain timeCapsule) {
        timeCapsuleValidator.validateSend(timeCapsule);

        TimeCapsuleDomain timePersisted = timeCapsuleRepositoryGateway.save(timeCapsule);
        timeCapsuleMessagingGateway.send(timePersisted);

        return timePersisted;
    }

}
