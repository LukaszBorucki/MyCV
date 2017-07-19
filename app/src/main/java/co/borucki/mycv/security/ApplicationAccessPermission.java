package co.borucki.mycv.security;


public interface ApplicationAccessPermission {
    boolean isAccessPermission();

    void setAccessPermission(boolean accessPermission);
}
