package time.capsule.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import time.capsule.api.core.domain.TimeCapsuleEntity;

import java.util.List;

@Repository
public interface TimeCapsuleRepository extends JpaRepository<TimeCapsuleEntity, Integer> {

    List<TimeCapsuleEntity> findAllByEmail(String email);

}
