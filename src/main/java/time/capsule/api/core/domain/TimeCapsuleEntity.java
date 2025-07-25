package time.capsule.api.core.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "time_capsule")
public class TimeCapsuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

    @Column(name = "ia_question")
    private String iaQuestion;

    @Column(name = "ia_answer_now")
    private String iaAnswerNow;

    @Column(name = "ia_answer_future")
    private String iaAnswerFuture;

    @Column(name = "date_to_send")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateToSend;

    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public TimeCapsuleEntity(Long id, String email, String message, String iaQuestion, String iaAnswerNow,
            String iaAnswerFuture, Date dateToSend, Date sentDate, Date createdAt) {
        this.id = id;
        this.email = email;
        this.message = message;
        this.iaQuestion = iaQuestion;
        this.iaAnswerNow = iaAnswerNow;
        this.iaAnswerFuture = iaAnswerFuture;
        this.dateToSend = dateToSend;
        this.sentDate = sentDate;
        this.createdAt = createdAt;
    }
    
    public TimeCapsuleEntity() {
    }

}
