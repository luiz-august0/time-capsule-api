package time.capsule.api.core.domain;

import java.util.Date;

public class TimeCapsuleDomain {

    private String email;

    private String message;

    private String iaQuestion;

    private String iaAnswer;

    private Date dateToSend;

    private Date sentDate;

    private Date createdAt;

    public TimeCapsuleDomain() {
    }

    public TimeCapsuleDomain(String email, String message, String iaQuestion, Date dateToSend) {
        this.email = email;
        this.message = message;
        this.iaQuestion = iaQuestion;
        this.dateToSend = dateToSend;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIaQuestion() {
        return iaQuestion;
    }

    public void setIaQuestion(String iaQuestion) {
        this.iaQuestion = iaQuestion;
    }

    public String getIaAnswer() {
        return iaAnswer;
    }

    public void setIaAnswer(String iaAnswer) {
        this.iaAnswer = iaAnswer;
    }

    public Date getDateToSend() {
        return dateToSend;
    }

    public void setDateToSend(Date dateToSend) {
        this.dateToSend = dateToSend;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
