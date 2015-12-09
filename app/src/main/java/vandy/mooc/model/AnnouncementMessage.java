package vandy.mooc.model;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by Admin on 12/11/2015.
 */
public class AnnouncementMessage {
    private int messageId;
    private String messageTime;
    private String messageTitle;
    private String messageDetail;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String dateTime) {
        this.messageTime = dateTime;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public AnnouncementMessage() {

    }

    public AnnouncementMessage(int messageId, String dateTime, String messageTitle, String messageDetail) {
        this.messageId = messageId;
        this.messageTime = dateTime;
        this.messageDetail = messageDetail;
        this.messageTitle = messageTitle;

    }


}