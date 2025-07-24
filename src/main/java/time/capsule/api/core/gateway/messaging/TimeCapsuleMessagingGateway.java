package time.capsule.api.core.gateway.messaging;

import time.capsule.api.core.domain.TimeCapsuleEntity;

public interface TimeCapsuleMessagingGateway {

    void send(TimeCapsuleEntity timeCapsule);

}
