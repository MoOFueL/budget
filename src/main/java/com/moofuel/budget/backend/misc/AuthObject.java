package com.moofuel.budget.backend.misc;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by MoOFueL on 14.07.2016.
 */
public class AuthObject {

    @NotBlank
    private String fio;

    @NotBlank
    private String password;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthObject{" +
                "fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
