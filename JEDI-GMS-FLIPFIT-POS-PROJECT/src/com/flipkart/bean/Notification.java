package com.flipkart.bean;

/**
 * The Notification class represents a notification in the system.
 */
public class Notification {

    // Attributes related to a notification
    private Integer notificationId; // Unique identifier for the notification
    private Integer userId; // Unique identifier for the user associated with the notification
    private String message; // Message content of the notification
    private Boolean isRead; // Flag indicating whether the notification has been read or not

    /**
     * Constructor to initialize a Notification object with relevant details.
     *
     * @param notificationId Unique identifier for the notification.
     * @param userId         Unique identifier for the user associated with the notification.
     * @param message        Message content of the notification.
     * @param isRead         Flag indicating whether the notification has been read or not.
     */
    public Notification(Integer notificationId, Integer userId, String message, Boolean isRead) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.isRead = isRead;
    }

    // Getter and setter methods for Notification attributes

    /**
     * Getter method to retrieve the unique identifier for the notification.
     *
     * @return The notification's unique identifier.
     */
    public Integer getNotificationId() {
        return notificationId;
    }

    /**
     * Setter method to set the unique identifier for the notification.
     *
     * @param notificationId The unique identifier to set for the notification.
     */
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Getter method to retrieve the unique identifier for the user associated with the notification.
     *
     * @return The user's unique identifier.
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Setter method to set the unique identifier for the user associated with the notification.
     *
     * @param userId The unique identifier to set for the user.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter method to retrieve the message content of the notification.
     *
     * @return The message content of the notification.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method to set the message content of the notification.
     *
     * @param message The message content to set for the notification.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method to check if the notification has been read.
     *
     * @return True if the notification has been read, false otherwise.
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     * Setter method to set the read status of the notification.
     *
     * @param isRead True if the notification has been read, false otherwise.
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}
