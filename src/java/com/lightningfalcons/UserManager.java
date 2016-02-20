package com.lightningfalcons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The userManager class is to manage the user instance in the Database
 *
 * @author Yufan
 */
public class UserManager {

    /**
     * Search the user in the database
     *
     * @param inputUsername a string
     * @param inputPassword a string
     * @return user the user instance
     */
    public static User searchUser(String inputUsername, String inputPassword) {
        //get connectiong to the database
        Connection myConn = null;
        User toReturn = null;
        PreparedStatement myStmt = null;
        try {
            myConn = Database.openConnection();

            String stm = "select * from User where username = ?";
            try {
                //create a statement
                myStmt = myConn.prepareStatement(stm);
                //execute a query
                myStmt.setString(1, inputUsername);
                myStmt.execute();
                ResultSet myRs = myStmt.getResultSet();
                //process the result
                if (myRs.next() && myRs.getString("password")
                    .equals(inputPassword)) {
//                    if (myRs.getString("password").equals(inputPassword)) {
                    toReturn = new User(inputUsername, inputPassword);
                    toReturn.setPassword(myRs.getString("password"));
                    toReturn.setFirstname(myRs.getString("firstname"));
                    toReturn.setLastname(myRs.getString("lastname"));
                    toReturn.setSex(myRs.getString("sex"));
                    toReturn.setMajor(myRs.getString("major"));
                    toReturn.setRole(myRs.getInt("role"));
                    toReturn.setStatus(myRs.getString("status"));
                    toReturn.setInterest(myRs.getString("interest"));
                    toReturn.setAttempts(myRs.getInt("attempts"));

//                    }
                }
            } catch (SQLException | RuntimeException e1) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, e1);
            } finally {
                if (myStmt != null) {
                    myStmt.close();
                }
            }
        } catch (SQLException | RuntimeException e1) {
            Logger.getLogger(
                    UserManager.class.getName()).log(Level.SEVERE, null, e1
                );
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException | RuntimeException ex) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return toReturn;
    }

    /**
     * Update the user info in the database
     *
     * @param updatedUser a User
     */
    public static void updateUser(User updatedUser) {
        //get connectiong to the database
        Connection myConn = null;
        PreparedStatement preparedStmt = null;
        try {
            myConn = Database.openConnection();
            try {
                //instert the value

                String query = "UPDATE User SET "
                        + "password = ?,"
                        + "firstname = ?,"
                        + "lastname = ?,"
                        + "interest = ?,"
                        + "major = ?,"
                        + "sex = ?,"
                        + "status = ?,"
                        + "attempts = ?"
                        + " WHERE username = " + "?" + "";
                preparedStmt = myConn.prepareStatement(query);
                //update the value
                preparedStmt.setString(1, updatedUser.getPassword());
                preparedStmt.setString(2, updatedUser.getFirstname());
                preparedStmt.setString(3, updatedUser.getLastname());
                preparedStmt.setString(4, updatedUser.getInterest());
                preparedStmt.setString(5, updatedUser.getMajor());
                preparedStmt.setString(6, updatedUser.getSex());
                preparedStmt.setString(7, updatedUser.getStatus());
                preparedStmt.setInt(8, updatedUser.getAttempts());
                preparedStmt.setString(9, updatedUser.getUsername());
                preparedStmt.execute();
            } catch (SQLException e1) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, e1);
            } finally {
                preparedStmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(
                    UserManager.class.getName()).log(Level.SEVERE, null, ex
                );
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Create a new user in the database
     *
     * @param newUser a User
     */
    public static void addUser(User newUser) {
        //get connectiong to the database
        Connection myConn = null;
        PreparedStatement preparedStmt = null;
        try {
            myConn = Database.openConnection();
            try {
                //execute a query
                String query = "INSERT INTO User(username, password)"
                        + "values(?, ?)";
                // create the mysql insert preparedstatement
                preparedStmt = myConn.prepareStatement(query);
                //instert the value
                preparedStmt.setString(1, newUser.getUsername());
                preparedStmt.setString(2, newUser.getPassword());
                // execute the preparedstatement
                preparedStmt.execute();

            } catch (SQLException e1) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, e1);
            } finally {
                preparedStmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    UserManager.class.getName()).log(Level.SEVERE, null, ex
                );
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Get the user list in the database
     *
     * @return user the user instance
     */
    public static List<User> getUserList() {
        //get connectiong to the database
        Connection myConn = null;
        Statement myStmt = null;
        try {
            myConn = Database.openConnection();
            try {
                //create a statement
                myStmt = myConn.createStatement();
                //execute a query
                ResultSet myRs = myStmt.executeQuery("select * from User");
                //process the result
                List<User> toReturn = new ArrayList<>();
                while (myRs.next()) {
                    User toAdd = new User(myRs.getString("username"),
                        myRs.getString("password"));
                    toAdd.setPassword(myRs.getString("password"));
                    toAdd.setFirstname(myRs.getString("firstname"));
                    toAdd.setLastname(myRs.getString("lastname"));
                    toAdd.setSex(myRs.getString("sex"));
                    toAdd.setMajor(myRs.getString("major"));
                    toAdd.setRole(myRs.getInt("role"));
                    toAdd.setStatus(myRs.getString("status"));
                    toAdd.setInterest(myRs.getString("interest"));
                    toReturn.add(toAdd);
                }
                return toReturn;
            } catch (SQLException e1) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, e1);
            } finally {
                myStmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    UserManager.class.getName()).log(Level.SEVERE, null, ex
                );
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Search the user in the database
     *
     * @param inputUsername
     *
     * @return user the user instance
     */
    public static User searchUserWithName(String inputUsername) {
        //get connectiong to the database
        Connection myConn = null;
        try {
            myConn = Database.openConnection();
            Statement myStmt = null;
            try {
                //create a statement
                myStmt = myConn.createStatement();
//                String stm = "select * from User";
                //execute a query
                ResultSet myRs = null;
                //process the result
                try {
                    //execute a query
                    myRs = myStmt.executeQuery("select * from User");
                    //process the result
                    while (myRs.next()) {
                        if (myRs.getString("username").equals(inputUsername)) {
                            User toReturn = new User(inputUsername,
                                myRs.getString("password"));
                            toReturn.setPassword(myRs.getString("password"));
                            toReturn.setFirstname(myRs.getString("firstname"));
                            toReturn.setLastname(myRs.getString("lastname"));
                            toReturn.setSex(myRs.getString("sex"));
                            toReturn.setMajor(myRs.getString("major"));
                            toReturn.setRole(myRs.getInt("role"));
                            toReturn.setStatus(myRs.getString("status"));
                            toReturn.setInterest(myRs.getString("interest"));
                            toReturn.setAttempts(myRs.getInt("attempts"));
                            return toReturn;
                        }
                    }
                } finally {
                    myRs.close();
                }

            } catch (SQLException e1) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, e1);
            } finally {
                if (myStmt != null) {
                    myStmt.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    UserManager.class.getName()).log(Level.SEVERE, null, ex
                );
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
