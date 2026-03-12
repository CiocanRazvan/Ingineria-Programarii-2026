import java.time.LocalDateTime;

public class Notification {

    private Long notificationId;
    private String type;
    private String message;
    private boolean isRead;
    private LocalDateTime sentAt;

    public Notification(Long notificationId, String type, String message,
                        boolean isRead, LocalDateTime sentAt) {
        this.notificationId = notificationId;
        this.type = type;
        this.message = message;
        this.isRead = isRead;
        this.sentAt = sentAt;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}