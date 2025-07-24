package time.capsule.api.infrastructure.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import time.capsule.api.core.domain.TimeCapsuleEntity;
import time.capsule.api.core.dto.TimeCapsuleDTO;
import time.capsule.api.core.dto.records.TimeCapsuleRecord;

import java.util.List;

public class TimeCapsuleMapper {

    public static TimeCapsuleEntity recordToEntity(TimeCapsuleRecord timeCapsuleRecord) {
        return TimeCapsuleEntity.builder()
                .email(timeCapsuleRecord.email())
                .iaQuestion(timeCapsuleRecord.iaQuestion())
                .dateToSend(timeCapsuleRecord.dateToSend())
                .message(timeCapsuleRecord.message())
                .build();
    }

    public static List<TimeCapsuleDTO> toDTO(List<TimeCapsuleEntity> capsules) {
        ObjectMapper objectMapper = new ObjectMapper();

        return capsules.stream()
                .map(capsule -> objectMapper.convertValue(capsule, TimeCapsuleDTO.class))
                .toList();
    }

}
