package time.capsule.api.core.gateway;

import time.capsule.api.core.domain.TimeCapsuleDomain;

import java.util.List;

public interface TimeCapsuleRepositoryGateway {

    TimeCapsuleDomain save(TimeCapsuleDomain timeCapsule);

    List<TimeCapsuleDomain> findAllByEmail(String email);

}
