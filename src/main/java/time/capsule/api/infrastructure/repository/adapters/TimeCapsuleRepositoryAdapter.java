package time.capsule.api.infrastructure.repository.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.gateway.repository.TimeCapsuleRepositoryGateway;
import time.capsule.api.infrastructure.repository.TimeCapsuleRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TimeCapsuleRepositoryAdapter implements TimeCapsuleRepositoryGateway {

    private final TimeCapsuleRepository timeCapsuleRepository;

    @Override
    public TimeCapsuleEntity save(TimeCapsuleEntity timeCapsule) {
        return timeCapsuleRepository.save(timeCapsule);
    }

    @Override
    public List<TimeCapsuleEntity> findAllByEmail(String email) {
        return timeCapsuleRepository.findAllByEmail(email);
    }

}
