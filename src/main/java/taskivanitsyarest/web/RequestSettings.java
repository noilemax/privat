package taskivanitsyarest.web;

/**
 * Created by Администратор on 23.06.2016.
 */
public class RequestSettings {

    private String userName;
    private String password;
    private Byte isActive;


    public RequestSettings() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}
