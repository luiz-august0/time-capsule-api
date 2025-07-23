package time.capsule.api.core.dto.records;

import java.util.Date;

public record TimeCapsuleRecord(
        String email,
        String message,
        String iaQuestion,
        Date dateToSend
) {
}
