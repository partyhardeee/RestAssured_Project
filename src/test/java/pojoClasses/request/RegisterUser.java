package pojoClasses.request;


public class RegisterUser {
    private String email;
    private String password;

    public RegisterUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
