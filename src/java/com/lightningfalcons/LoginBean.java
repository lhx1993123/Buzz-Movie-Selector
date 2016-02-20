package com.lightningfalcons;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * The loginBean class is to control the session for a user
 *
 * @author Yufan
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String inputUsername;
    private String inputPassword;
    private String newPassword;
    private String newFirstname;
    private String newLastname;
    private String newSex;
    private String newInterest;
    private String newMajor;
    private User currentUser;
    private String outputMsg = " ";
    private static final long serialVersionUID = -403250971215465050L;

    /**
     * get the newMajor
     *
     * @return newMjor
     */
    public String getNewMajor() {
        return newMajor;
    }

    /**
     * set newMajor
     *
     * @param newMajor the newMajor to be set
     */
    public void setNewMajor(String newMajor) {
        this.newMajor = newMajor;
    }

    /**
     * get the newSex
     *
     * @return the newSex
     */
    public String getNewSex() {
        return newSex;
    }

    /**
     * set newSex
     *
     * @param newSex the newSex to be set
     */
    public void setNewSex(String newSex) {
        this.newSex = newSex;
    }

    /**
     * get the newFirstname
     *
     * @return the newFirstname
     */
    public String getNewFirstname() {
        return newFirstname;
    }

    /**
     * set the newFirstname
     *
     * @param newFirstname the newFirstname to be set
     */
    public void setNewFirstname(String newFirstname) {
        this.newFirstname = newFirstname;
    }

    /**
     * get the newLastname
     *
     * @return the new Lastname
     */
    public String getNewLastname() {
        return newLastname;
    }

    /**
     * set the newLastname
     *
     * @param newLastname a String
     */
    public void setNewLastname(String newLastname) {
        this.newLastname = newLastname;
    }

    /**
     * get the newInterest
     *
     * @ the newInterest
     */
    public String getNewInterest() {
        return newInterest;
    }

    /**
     * set newInterest
     *
     * @param newInterest the newInterest to be set
     */
    public void setNewInterest(String newInterest) {
        this.newInterest = newInterest;
    }

    /**
     * Get the new password
     *
     * @return　String　new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Set the password to the new one
     *
     * @param newPassword a new password
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Return the message
     *
     * @return　String　message
     */
    public String getOutputMsg() {
        return outputMsg;
    }

    /**
     * Set the message
     *
     * @param output_msg a message
     */
    public void setOutputMsg(String outputMsg) {
        this.outputMsg = outputMsg;
    }

    /**
     * Get the username
     *
     * @return String　inputUsername
     */
    public String getInputUsername() {
        return inputUsername;
    }

    /**
     * Set the username to the input one
     *
     * @param inputUsername username input by user
     */
    public void setInputUsername(String inputUsername) {
        this.inputUsername = inputUsername;
    }

    /**
     * Set the password to the input one
     *
     * @return　String　inputPassword
     */
    public String getInputPassword() {
        return inputPassword;
    }

    /**
     * Set the password
     *
     * @param inputPassword password input by user
     */
    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    /**
     * Return the current user
     *
     * @return User　current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Let the user to log into the system
     *
     * @return String　the home page or message
     */
    public String login() throws SQLException {
        String hash = MD5.md5(inputPassword);
        currentUser = UserManager.searchUser(inputUsername, hash);
        if (inputUsername.equals("") && inputPassword.equals("")) {
            outputMsg = "Please enter name and password";
            return "login?faces-redirect=true";
        }
        if (currentUser == null) {
            currentUser = UserManager.searchUserWithName(inputUsername);
            if (currentUser == null) {
                outputMsg = "Account does not exist. Please sign up.";
                return "login?faces-redirect=true";
            } else {
                if (currentUser.getStatus().equals("Locked")) {
                    outputMsg = "Sorry. This account has been locked";
                    return "login?faces-redirect=true";
                }
                outputMsg = currentUser.checkAttempts();
                UserManager.updateUser(currentUser);
                return "login?faces-redirect=true";
            }
        }
        if (currentUser.getStatus() != null && (currentUser.getStatus()
            .equals("Banned") || currentUser.getStatus().equals("Locked"))) {
            outputMsg = "Sorry. This account has been banned or locked";
            return "login?faces-redirect=true";
        }
        if (currentUser.getRole() == 1) { //currentUser.getUsername()
            outputMsg = "admin login";
            return "admin";
        } else {
            outputMsg = "username and password are correct";
            return "welcome";
        }
    }

    /**
     * Logout the system
     *
     * @return　String login page
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext()
            .invalidateSession();
        return "index";
    }

    /**
     * Update the password
     *
     * @return String　profile page
     */
    public String updatePassword() {
        currentUser.setPassword(newPassword);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the firstname
     *
     * @return profile page
     */
    public String updateFirstname() {
        currentUser.setFirstname(newFirstname);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the lastname
     *
     * @return profile page
     */
    public String updateLastname() {
        currentUser.setLastname(newLastname);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the sex
     *
     * @return profile page
     */
    public String updateSex() {
        currentUser.setSex(newSex);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the interest
     *
     * @return profile page
     */
    public String updateInterest() {
        currentUser.setInterest(newInterest);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the major
     *
     * @return profile page
     */
    public String updateMajor() {
        currentUser.setMajor(newMajor);
        UserManager.updateUser(currentUser);
        return "profile?faces-redirect=true";
    }

    /**
     * Update the user information
     *
     * @return String　next page
     */
    public String updateUser() {
        UserManager.updateUser(currentUser);
        return "welcome";
    }
    /**
     * Add the user to the Database
     *
     * @return String　next page
     */
    public String addUser() throws SQLException {
//        User exist = UserManager.searchUserWithName(inputUsername);
        String hash = MD5.md5(inputPassword);
        System.out.println(hash);
        User exist = UserManager.searchUserWithName(inputUsername);

        if (exist == null) {
            User newUser = new User(inputUsername, hash);
            UserManager.addUser(newUser);
            return "login";
        } else {
            outputMsg = "Username already exits. Please try another one";
            return "register?faces-redirect=true";
        }
    }

    /**
     * Get the message
     *
     * @return String　the system message
     */
    public String getMessage() {
        return outputMsg;
    }

}
