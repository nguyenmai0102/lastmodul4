package ra.payload.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class SignupRequest {
    private String userName;
    private String password;
    private String email;
    private String phone;
@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date created = new Date();
    private boolean userStatus = true;
    private Set<String> listRoles;


    public SignupRequest() {
    }

    public SignupRequest(String userName, String password, String email, String phone, Date created, boolean userStatus, Set<String> listRoles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.created = created;
        this.listRoles = listRoles;
        this.userStatus= true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String dateNow = sdf.format(now);
        try {
        this.created = sdf.parse(dateNow);
        }catch (Exception ex){
            ex.printStackTrace();
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Set<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<String> listRoles) {
        this.listRoles = listRoles;
    }
}
