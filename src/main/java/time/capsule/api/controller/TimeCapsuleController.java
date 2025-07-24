package time.capsule.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import time.capsule.api.core.dto.TimeCapsuleDTO;
import time.capsule.api.core.dto.records.TimeCapsuleRecord;
import time.capsule.api.core.usecase.TimeCapsuleGetByEmailUseCase;
import time.capsule.api.core.usecase.TimeCapsuleSendUseCase;
import time.capsule.api.infrastructure.mapper.TimeCapsuleMapper;

import java.util.List;

@RequestMapping("${api.prefix.v1}/time-capsule")
@RequiredArgsConstructor
@RestController
public class TimeCapsuleController {

    private final TimeCapsuleSendUseCase timeCapsuleSendUseCase;
    private final TimeCapsuleGetByEmailUseCase timeCapsuleGetByEmailUseCase;

    @PostMapping("/send")
    public Long send(@RequestBody TimeCapsuleRecord timeCapsuleRecord) {
        return timeCapsuleSendUseCase.send(TimeCapsuleMapper.recordToEntity(timeCapsuleRecord));
    }

    @GetMapping("/get-by-email")
    public List<TimeCapsuleDTO> getAllByEmail(@RequestParam(name = "email") String email) {
        return TimeCapsuleMapper.toDTO(timeCapsuleGetByEmailUseCase.getAllByEmail(email));
    }

}
