package co.borucki.mycv.dto;


public class MailUserAuthorizationDTO {
    private String mailUserName;
    private String mailUserPassword;
    private String mailHost;
    private int mailSmtpPort;
    private String[] mailTo;

    public MailUserAuthorizationDTO() {
    }

    public MailUserAuthorizationDTO(String mailUserName, String mailUserPassword, String mailHost, int mailSmtpPort, String[] mailTo) {
        this.mailUserName = mailUserName;
        this.mailUserPassword = mailUserPassword;
        this.mailHost = mailHost;
        this.mailSmtpPort = mailSmtpPort;
        this.mailTo = mailTo;
    }

    public String getMailUserNameDTO() {

        return mailUserName;
    }

    public void setMailUserNameDTO(String mailUserName) {
        this.mailUserName = mailUserName;
    }

    public String getMailUserPasswordDTO() {
        return mailUserPassword;
    }

    public void setMailUserPasswordDTO(String mailUserPassword) {
        this.mailUserPassword = mailUserPassword;
    }

    public String getMailHostDTO() {
        return mailHost;
    }

    public void setMailHostDTO(String mailHost) {
        this.mailHost = mailHost;
    }

    public int getMailSmtpPortDTO() {
        return mailSmtpPort;
    }

    public void setMailSmtpPortDTO(int mailSmtpPort) {
        this.mailSmtpPort = mailSmtpPort;
    }

    public String[] getMailToDTO() {
        return mailTo;
    }

    public void setMailToDTO(String[] mailTo) {
        this.mailTo = mailTo;
    }
}
