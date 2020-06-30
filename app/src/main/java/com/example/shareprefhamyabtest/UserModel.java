package com.example.shareprefhamyabtest;

public class UserModel {
    private String name;
    private String family;
    private Boolean run = false;

    public UserModel(String name, String family, Boolean run) {
        this.name = name;
        this.family = family;
        this.run = run;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }
}
