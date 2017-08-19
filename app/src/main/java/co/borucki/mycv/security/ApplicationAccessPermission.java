package co.borucki.mycv.security;


public interface ApplicationAccessPermission {
    boolean isAccessPermission();

    void setAccessPermission(boolean accessPermission);

    String getAccessMail();

    void setAccessMail(String mail);

    String getAccessPassword();

    void setAccessPassword(String password);

    String getAppLanguage();

    void setAppLanguage(String language);

}
