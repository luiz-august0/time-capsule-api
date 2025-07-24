package time.capsule.api.core.gateway.repository;

import time.capsule.api.core.domain.TimeCapsuleEntity;

import java.util.List;

public interface TimeCapsuleRepositoryGateway {

    TimeCapsuleEntity save(TimeCapsuleEntity timeCapsule);

    List<TimeCapsuleEntity> findAllByEmail(String email);

}
