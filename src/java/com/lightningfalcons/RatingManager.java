/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

import com.rottentomatoes.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 * The class is to provide user a way to write and read review of a movie
 *
 * @author Yufan
 */
@ManagedBean
public class RatingManager {

    /**
     * Add a new rating in the database
     *
     * @param scores an int
     * @param comments a string
     * @param movieId a int
     * @param username a string
     */
    public static void addRating(int scores, String comments, String movieId,
        String username) {
        //get connectiong to the database
        Connection myConn = null;
        PreparedStatement preparedStmt = null;
        try {
            myConn = Database.openConnection();
            try {
                //execute a query
                String query = "INSERT INTO Rating(scores, comments,movieID,"
                    + "username )values(?, ?, ?, ?)";
                // create the mysql insert preparedstatement
                preparedStmt = myConn.prepareStatement(query);
                //instert the value
                preparedStmt.setInt(1, scores);
                preparedStmt.setString(2, comments);
                preparedStmt.setString(3, movieId);
                preparedStmt.setString(4, username);
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
     * Return the rating for a movie with its movieId
     *
     * @param movieId a String
     * @return null something
     */
    public static List getRatings(String movieId) {
        //get connectiong to the database
        Connection myConn = null;
        List<BuzzRating> toReturn;
        PreparedStatement myStmt = null;
        try {
            myConn = Database.openConnection();
            String s = "select * from Rating where movieId = ?";
            try {
                toReturn = new ArrayList<>();
                //create a statement
                myStmt = myConn.prepareStatement(s);
                myStmt.setString(1, movieId);
                myStmt.execute();
                //execute a query
                ResultSet myRs = myStmt.getResultSet();
                //process the result

                while (myRs.next()) {
                    BuzzRating toAdd = new BuzzRating();
                    toAdd.setMovieId(myRs.getString("movieID"));
                    toAdd.setScores(myRs.getInt("scores"));
                    toAdd.setComments(myRs.getString("comments"));
                    toAdd.setUsername(myRs.getString("username"));
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
     * Return the rating for a movie with its movieId
     *
     * @param major a string
     * @return null something
     */
    public static List getRecommendations(String major) {
        //get connectiong to the database
        Connection myConn = null;
        PreparedStatement preparedStmt = null;
        List<Movie> toReturn = null;
        Movie toAdd;
        try {
            myConn = Database.openConnection();
            try {
                RottenTomatoes rt = new RottenTomatoes();
                toReturn = new ArrayList<>();
                //create a statement
                //execute a query
                String query = "SELECT DISTINCT movieID from `Rating` NATURAL "
                        + "JOIN `User` where scores >= 4 AND major = ?";
                preparedStmt = myConn.prepareStatement(query);
                preparedStmt.setString(1, major);
                preparedStmt.execute();
                ResultSet myRs = preparedStmt.getResultSet();
                //process the result
                while (myRs.next()) {
                    toAdd = rt.getMovieById(myRs.getString("movieID"));
                    toReturn.add(toAdd);
                }
                return toReturn;
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
        return toReturn;
    }
}
