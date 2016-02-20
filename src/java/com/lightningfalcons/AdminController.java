package com.lightningfalcons;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 * This is a controller for admin feature
 *
 * @author Wing Yi Cheung
 */
@ManagedBean(eager = true)
@ViewScoped
public class AdminController implements Serializable {
    private static final long serialVersionUID = -403250971215465050L;
    private List<User> userList;

    /**
     * Get the list of user
     *
     * @return userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Set the userList
     *
     * @param userList list of user of our website
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @PostConstruct
    public void init() {
        userList = UserManager.getUserList();
    }

    /**
     * Return userList
     *
     * @return userList
     */
    public List<User> getUsers() {
        return userList;
    }

    /**
     * Change the status of an user
     *
     * @return index a page
     */
    public String commit() {
        for (User user : userList) {
            UserManager.updateUser(user);
        }
        System.out.print("redirect to index");
        return "index";
    }
}
