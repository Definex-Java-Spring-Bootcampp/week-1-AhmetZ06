package com.patika.kredinbizdenservice.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
public class User {

    private static final Set<String> usedEmails = new HashSet<>();

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String password; //hash fonskiyonlarından biri ile hashlanecek.
    private String phoneNumber;
    private Boolean isActive;
    private List<Application> applicationList;


    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) throws Exception {
        if (!usedEmails.add(email)) {
            throw new Exception("Email kullanımda");
        }
        setPassword(password);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) throws Exception {
        if (!usedEmails.add(email)) {
            throw new Exception("Email kullanımda");
        }

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        setPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }


    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        setPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public void setPassword(String password) {
        try {
            this.password = getSHA512Hash(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    private String getSHA512Hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(String.format("%02x", aByte));
        }
        return sb.toString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }
}
