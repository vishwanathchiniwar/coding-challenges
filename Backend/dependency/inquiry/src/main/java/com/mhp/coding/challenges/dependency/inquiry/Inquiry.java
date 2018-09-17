package com.mhp.coding.challenges.dependency.inquiry;

public class Inquiry {

    private String username;
    private String recipient;
    private String text;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "username='" + username + '\'' +
                ", recipient='" + recipient + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
