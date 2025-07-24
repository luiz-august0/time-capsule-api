package time.capsule.api.infrastructure.messaging;

import org.springframework.stereotype.Service;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.messaging.TimeCapsuleMessagingGateway;

@Service
public class TimeCapsuleMessagingService implements TimeCapsuleMessagingGateway {

    public void send(TimeCapsuleEntity timeCapsule) {
        
    }

}
