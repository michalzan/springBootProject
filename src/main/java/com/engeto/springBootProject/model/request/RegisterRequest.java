package com.engeto.springBootProject.model.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {

    @Size(min = 3, max = 255)
    private String login;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,128}$",
            message = "Password must be between 8 and 128 characters and contain at least one number, one lower case and one upper case letter."
    )
    private String password;

    public RegisterRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
