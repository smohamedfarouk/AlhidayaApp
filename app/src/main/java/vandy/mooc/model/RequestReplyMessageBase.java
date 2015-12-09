package vandy.mooc.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;

/**
 * Super class that defines common keys and methods used by the
 * RequestMessage and ReplyMessage subclasses.
 */
public class RequestReplyMessageBase {
    /**
     * String constant used to extract the pathname to a downloaded
     * image from a Bundle.
     */
    public static final String MESSAGE_ID = "MESSAGE_ID";

    /**
     * String constant used to extract the request code.
     */
    public static final String MESSAGE_TIME = "MESSAGE_TIME";

    /**
     * String constant used to extract the URL to an image from a
     * Bundle.
     */
    public static final String MESSAGE_TITLE = "MESSAGE_TITLE";

    /**
     * String constant used to extract the directory pathname to use
     * to store a downloaded image.
     */
    public static final String MESSAGE_DETAIL = "MESSAGE_DETAIL";

    /**
     * Message used to hold the information.
     */
    protected Message mMessage;

    /**
     * Constructor initializes the mMessage field.
     */
    protected RequestReplyMessageBase(Message message) {
        mMessage = message;
    }

    /**
     * Accessor method that returns the underlying Message.
     */
    public Message getMessage() {
        return mMessage;
    }

    /**
     * Accessor method that returns the Bundle that's part of the
     * underlying Message.
     */
    public Bundle getData() {
        return mMessage.getData();
    }

    /**
     * Sets provided Bundle as the data of the underlying Message
     *
     * @param data - the Bundle to set
     */
    public void setData(Bundle data) {
        mMessage.setData(data);
    }

    /**
     * Accessor method that returns the result code of the message, which
     * can be used to check if the download succeeded.
     */
    public int getResultCode() {
        return mMessage.arg1;
    }

    /**
     * Accessor method that sets the result code
     *
     * @param resultCode - the code too set
     */
    public void setResultCode(int resultCode) {
        mMessage.arg1 = resultCode;
    }

    /**
     * Accessor method that returns Messenger of the Message.
     */
    public Messenger getMessenger() {
        return mMessage.replyTo;
    }

    /**
     * Accessor method that sets Messenger of the Message
     *
     * @param messenger
     */
    public void setMessenger(Messenger messenger) {
        mMessage.replyTo = messenger;
    }


    public int getMessageId() {
        // Extract the data from Message, which is in the form of a
        // Bundle that can be passed across processes.
        Bundle data = mMessage.getData();
        // Extract the request code.
        return data.getInt(MESSAGE_ID);
    }

    public void setMessageId(int messageId) {
        mMessage.getData().putInt(MESSAGE_ID,
                messageId);
    }

    public String getMessageTime() {
        // Extract the data from Message, which is in the form of a
        // Bundle that can be passed across processes.
        Bundle data = mMessage.getData();
        // Extract the request code.
        return data.getString(MESSAGE_TIME);
    }

    public void setMessageTime(String dateTime) {
        mMessage.getData().putString(MESSAGE_TIME,
                dateTime);
    }

    public String getMessageTitle() {
        // Extract the data from Message, which is in the form of a
        // Bundle that can be passed across processes.
        Bundle data = mMessage.getData();
        // Extract the request code.
        return data.getString(MESSAGE_TITLE);
    }

    public void setMessageTitle(String messageTitle) {
        mMessage.getData().putString(MESSAGE_TITLE,
                messageTitle);
    }

    public String getMessageDetail() {
        // Extract the data from Message, which is in the form of a
        // Bundle that can be passed across processes.
        Bundle data = mMessage.getData();
        // Extract the request code.
        return data.getString(MESSAGE_DETAIL);
    }

    public void setMessageDetail(String messageDetail) {
        mMessage.getData().putString(MESSAGE_DETAIL,
                messageDetail);
    }


}