package Bean;

/**
 * Created by 白玉春 on 2017/9/10.
 */

public class UserYonghu {

    private String name;
    private String password;
    private String Email;

    public UserYonghu(String name, String password, String email) {
        this.name = name;
        this.password = password;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "UserYonghu{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
