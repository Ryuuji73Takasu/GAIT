package com.example.gtaidp;

public class InputInfo {

    String username, name,age,height,weight,email,password,toe,ankle,heel,foot;

    public InputInfo(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public InputInfo(String username, String name, String age, String weight, String email, String password) {
       this.username=username;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        //this.gender = gender;
        this.email = email;
        this.password = password;
       // this.toe= toe;
        //this.ankle= ankle;
        //this.heel= heel;
        //this.foot= foot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToe() {
        return toe;
    }

    public void setToe(String toe) {
        this.toe = toe;
    }

    public String getAnkle() {
        return ankle;
    }

    public void setAnkle(String ankle) {
        this.ankle = ankle;
    }

    public String getHeel() {
        return heel;
    }

    public void setHeel(String heel) {
        this.heel = heel;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }


}


