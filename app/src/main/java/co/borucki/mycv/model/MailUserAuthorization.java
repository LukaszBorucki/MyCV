package co.borucki.mycv.model;


public class MailUserAuthorization {
    private String mailUserName;
    private String mailUserPassword;
    private String mailHost;
    private int mailSmtpPort;
    private String[] mailTo;

    public MailUserAuthorization() {
    }

    public MailUserAuthorization(String mailUserName, String mailUserPassword, String mailHost, int mailSmtpPort, String[] mailTo) {
        this.mailUserName = mailUserName;
        this.mailUserPassword = mailUserPassword;
        this.mailHost = mailHost;
        this.mailSmtpPort = mailSmtpPort;
        this.mailTo = mailTo;
    }

    public String getMailUserName() {

        return mailUserName;
    }

    public void setMailUserName(String mailUserName) {
        this.mailUserName = mailUserName;
    }

    public String getMailUserPassword() {
        return mailUserPassword;
    }

    public void setMailUserPassword(String mailUserPassword) {
        this.mailUserPassword = mailUserPassword;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public int getMailSmtpPort() {
        return mailSmtpPort;
    }

    public void setMailSmtpPort(int mailSmtpPort) {
        this.mailSmtpPort = mailSmtpPort;
    }

    public String[] getMailTo() {
        return mailTo;
    }

    public void setMailTo(String[] mailTo) {
        this.mailTo = mailTo;
    }
}
