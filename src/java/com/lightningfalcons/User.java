package com.lightningfalcons;

import java.io.Serializable;
//import javax.faces.context.FacesContext;

/**
 * The user class holds the info of the user
 *
 * @author Yufan
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String interest;
    private String major;
    private String sex;
    private String status;
    private int attempts;
    private static final long serialVersionUID = -403250971215465050L;
    private int role; //role = 0 customer, role =1 admin

    /**
     * Create a user instance
     *
     * @param uname a String
     * @param psw a String
     */
    public User(String uname, String psw) {
        username = uname;
        password = psw;
    }

    /**
     * Get the user sex
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the sex
     *
     * @param sex a String
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Control the sex display
     *
     * @return String sex
     */
    public String sexCtrl() {
        if ("1".equals(sex)) {
            return "Male";
        }
        if ("2".equals(sex)) {
            return "Female";
        }
        return "Unknown";
    }

    /**
     * Get the username
     *
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username
     *
     * @param username a String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password
     *
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password
     *
     * @param password a String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the first name
     *
     * @return String first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the first name
     *
     * @param firstname a String
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get the last name
     *
     * @return String last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the last name
     *
     * @param lastname a String
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get the interest
     *
     * @return String interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * Set the interest
     *
     * @param interest a String
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * Get the major
     *
     * @return String major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set the major
     *
     * @param major a String
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Get the role
     *
     * @return role
     */
    public int getRole() {
        return role;
    }

    /**
     * Set the role
     *
     * @param role an int
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Get the status
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status
     *
     * @param status a String
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *  Get attempts
     *
     * @return attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Set attempts
     *
     * @param attempts an int
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    /**
     * Increment attempts when login failed
     * @return output msg
     */
    public String checkAttempts() {
        attempts++;
        if (attempts >= 3) {
            setStatus("Locked");
            attempts = 0;
            return "Sorry. This account has been locked.";
        }
        return "Password incorrect. Please try again. Attemps remainning: "
            + (3 - attempts);
    }
}
