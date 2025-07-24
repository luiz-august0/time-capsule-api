package time.capsule.api.core.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TimeCapsuleDTO {

    private Long id;

    private String email;

    private String message;

    private String iaQuestion;

    private String iaAnswerNow;

    private String iaAnswerFuture;

    private Date dateToSend;

    private Date sentDate;

    private Date createdAt;

}
