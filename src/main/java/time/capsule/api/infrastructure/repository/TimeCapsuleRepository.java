package time.capsule.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.repository.TimeCapsuleRepositoryGateway;

@Repository
public interface TimeCapsuleRepository extends JpaRepository<TimeCapsuleEntity, Integer>, TimeCapsuleRepositoryGateway {
}
