package time.capsule.api.core.usecase;

import time.capsule.api.core.domain.TimeCapsuleDomain;
import time.capsule.api.core.gateway.TimeCapsuleRepositoryGateway;
import time.capsule.api.core.validator.TimeCapsuleValidator;

import java.util.List;

public class TimeCapsuleGetByEmail {

    private final TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway;
    private final TimeCapsuleValidator timeCapsuleValidator;

    public TimeCapsuleGetByEmail(TimeCapsuleRepositoryGateway timeCapsuleRepositoryGateway) {
        this.timeCapsuleRepositoryGateway = timeCapsuleRepositoryGateway;
        this.timeCapsuleValidator = new TimeCapsuleValidator();
    }

    public List<TimeCapsuleDomain> getAllByEmail(String email) {
        timeCapsuleValidator.validateEmail(email);
        return timeCapsuleRepositoryGateway.findAllByEmail(email);
    }

}
