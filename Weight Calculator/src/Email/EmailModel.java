package Email;

public class EmailModel {

    private String senderGmailEmailAddress;
    private String senderPassword;
    private String receiverMobileNumber;

    private String emailSubject;
    private String emailBody;

    public EmailModel(String senderGmailEmailAddress, String senderPassword,
                      String receiverMobileNumber, String emailSubject,
                      String emailBody) {
        this.senderGmailEmailAddress = senderGmailEmailAddress;
        this.senderPassword = senderPassword;
        this.receiverMobileNumber = receiverMobileNumber;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

    public String getSenderGmailEmailAddress() {
        return senderGmailEmailAddress;
    }

    public void setSenderGmailEmailAddress(String senderGmailEmailAddress) {
        this.senderGmailEmailAddress = senderGmailEmailAddress;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public String getReceiverMobileNumber() {
        return receiverMobileNumber;
    }

    public void setReceiverMobileNumber(String receiverMobileNumber) {
        this.receiverMobileNumber = receiverMobileNumber;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
