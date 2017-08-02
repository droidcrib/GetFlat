
package com.blogspot.droidcrib.getflat.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplaintBoxConfig {

    @SerializedName("actionSendUrl")
    @Expose
    private String actionSendUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("options")
    @Expose
    private List<Option> options = null;
    @SerializedName("optionAdditionalIfIsOwner")
    @Expose
    private OptionAdditionalIfIsOwner optionAdditionalIfIsOwner;
    @SerializedName("emailInput")
    @Expose
    private EmailInput emailInput;
    @SerializedName("commentInput")
    @Expose
    private CommentInput commentInput;
    @SerializedName("sendButtonLabel")
    @Expose
    private String sendButtonLabel;
    @SerializedName("cancelButtonLabel")
    @Expose
    private String cancelButtonLabel;
    @SerializedName("complaintSendingErrorMessage")
    @Expose
    private String complaintSendingErrorMessage;
    @SerializedName("sendCompleted")
    @Expose
    private SendCompleted sendCompleted;
    @SerializedName("presets")
    @Expose
    private Presets presets;

    public String getActionSendUrl() {
        return actionSendUrl;
    }

    public void setActionSendUrl(String actionSendUrl) {
        this.actionSendUrl = actionSendUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public OptionAdditionalIfIsOwner getOptionAdditionalIfIsOwner() {
        return optionAdditionalIfIsOwner;
    }

    public void setOptionAdditionalIfIsOwner(OptionAdditionalIfIsOwner optionAdditionalIfIsOwner) {
        this.optionAdditionalIfIsOwner = optionAdditionalIfIsOwner;
    }

    public EmailInput getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(EmailInput emailInput) {
        this.emailInput = emailInput;
    }

    public CommentInput getCommentInput() {
        return commentInput;
    }

    public void setCommentInput(CommentInput commentInput) {
        this.commentInput = commentInput;
    }

    public String getSendButtonLabel() {
        return sendButtonLabel;
    }

    public void setSendButtonLabel(String sendButtonLabel) {
        this.sendButtonLabel = sendButtonLabel;
    }

    public String getCancelButtonLabel() {
        return cancelButtonLabel;
    }

    public void setCancelButtonLabel(String cancelButtonLabel) {
        this.cancelButtonLabel = cancelButtonLabel;
    }

    public String getComplaintSendingErrorMessage() {
        return complaintSendingErrorMessage;
    }

    public void setComplaintSendingErrorMessage(String complaintSendingErrorMessage) {
        this.complaintSendingErrorMessage = complaintSendingErrorMessage;
    }

    public SendCompleted getSendCompleted() {
        return sendCompleted;
    }

    public void setSendCompleted(SendCompleted sendCompleted) {
        this.sendCompleted = sendCompleted;
    }

    public Presets getPresets() {
        return presets;
    }

    public void setPresets(Presets presets) {
        this.presets = presets;
    }

}
