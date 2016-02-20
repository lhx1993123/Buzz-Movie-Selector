/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import java.util.Properties;
//import javax.faces.bean.SessionScoped;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

/**
 *
 * @author xinmin
 */
@ManagedBean(eager = true)
@ViewScoped
public class ForgetPasswordController {

    private String email;
    private User forgotUser;

    /**
     * Get email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Send email to user
     *
     * @return login page
     */
    public String send() {
        System.out.println(email);
        System.out.println("hi!!!!");
        forgotUser = UserManager.searchUserWithName(email);
        if (forgotUser != null) {
            SendEmail sm = new SendEmail();
            System.out.println(email);
            sm.setHost("smtp.163.com"); // 指定要使用的邮件服务器
            sm.setAccount("bzmovie@163.com", "clusfwzuqvoplydw"); // 指定帐号和密码
        /*
* @param String 发件人的地址
*
* @param String 收件人地址
*
* @param String 邮件标题
*
* @param String 邮件正文
*/
            String password = "your password is ";
            password = password + forgotUser.getPassword();
            sm.send("bzmovie@163.com", email, "bzmovie forgot password",
                password);
            System.out.println("success!");

        }
        return "login";
    }
}
