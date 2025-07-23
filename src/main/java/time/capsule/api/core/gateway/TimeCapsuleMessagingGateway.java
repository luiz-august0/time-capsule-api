package time.capsule.api.core.gateway;

import time.capsule.api.core.domain.TimeCapsuleDomain;

public interface TimeCapsuleMessagingGateway {

    void send(TimeCapsuleDomain timeCapsule);

}
