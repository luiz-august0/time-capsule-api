package time.capsule.api.core.dto.records;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record TimeCapsuleRecord(
        String email,
        String message,
        String iaQuestion,
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm") Date dateToSend
) {
}
