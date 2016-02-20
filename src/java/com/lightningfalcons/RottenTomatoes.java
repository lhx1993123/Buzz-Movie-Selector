package com.lightningfalcons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rottentomatoes.Movie;
import com.rottentomatoes.RottenTomatoesResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The rottenTomatoes helps to get the response from rotten tomatoes through API
 *
 * @author Yufan
 */
public class RottenTomatoes {

    private static final String KEY = "yedukp76ffytfuy24zsqk7f5";
    private List<Movie> movies;

    /**
     * Search movies based on the keyword
     *
     * @param keyword a String
     * @return a list of movies
     */
    public List<Movie> searchMovies(String keyword) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Integer.class, new IntegerAdapter());
        Gson gson = builder.create();
        String link = "http://api.rottentomatoes.com/api/public/v1.0/movies."
            + "json?apikey=yedukp76ffytfuy24zsqk7f5&q="
            + (keyword.replaceAll(" ", "+")) + "&page_limit=25";
        String data = getSearchData(link);
        RottenTomatoesResponse response = gson.fromJson(data,
            RottenTomatoesResponse.class);
        movies = response.getMovies();
        return movies;
    }

    /**
     * Get all new theater releases
     *
     * @return a list of movies
     */
    public List<Movie> newTheaterReleases() {
        try {
            String urls = "http://api.rottentomatoes.com/api/public/v1.0/"
                + "lists/movies/in_theaters.json?apikey="
                + KEY;
            URL url = new URL(urls);
            InputStreamReader isr = new InputStreamReader(url.openStream(),
                "UTF8");
            BufferedReader br = new BufferedReader(isr);
            Gson gson = new Gson();
            RottenTomatoesResponse response = gson.fromJson(br,
                RottenTomatoesResponse.class);
            movies = response.getMovies();
        } catch (MalformedURLException ex) {
            Logger.getLogger(RottenTomatoesResponse.class.getName())
                .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot open URL");
        }
        return movies;
    }

    /**
     * Get all new DVD releases
     *
     * @return a list of movies
     */
    public List<Movie> newDVDReleases() {
        try {
            String urls = "http://api.rottentomatoes.com/api/public/v1.0/lists"
                + "/dvds/new_releases.json?apikey="
                + KEY;
            URL url = new URL(urls);
            InputStreamReader isr = new InputStreamReader(url.openStream(),
                "UTF8");
            BufferedReader br = new BufferedReader(isr);
            Gson gson = new Gson();
            RottenTomatoesResponse response = gson.fromJson(br,
                RottenTomatoesResponse.class);
            movies = response.getMovies();
        } catch (MalformedURLException ex) {
            Logger.getLogger(RottenTomatoesResponse.class.getName())
                .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot open URL");
        }
        return movies;
    }

    /**
     * Retrieve data from URL
     *
     * @param link the URL
     * @return a string of data
     */
    private static String getSearchData(String link) {
        URL url;
//        String data = "";
        StringBuffer buf = new StringBuffer();
        BufferedReader br = null;

        try {
            url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                       + conn.getResponseCode());
            }
            InputStreamReader reader = new InputStreamReader(conn
                .getInputStream(), "UTF8");
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream()), "UTF8"));
            br = new BufferedReader(reader);
            String output;
            while ((output = br.readLine()) != null) {
//                data += output;
                buf.append(output);
            }
//            br.close();
//            String data = buf.toString();
            conn.disconnect();

        } catch (MalformedURLException ex) {
            System.out.println("Cannot open url");
        } catch (IOException ex) {
            System.out.println("Cannot open url");
//        }
        } finally {
            try {
                if (br == null) {
                    throw new RuntimeException();
                }
                br.close();
//            conn.disconnect();
//            IOUtils.closeQuietly(conn.getInputStream());
//            br.close();
            } catch (IOException ex) {
                Logger.getLogger(RottenTomatoes.class.getName()).log(Level
                    .SEVERE, null, ex);
            }
        }
        return buf.toString();
    }
     /**
     * Get A movie by its ID
     *
     * @param id a String
     * @return the target movie
     */
    public Movie getMovieById(String id) {
        Movie movie = null;
        try {
            String urls = "http://api.rottentomatoes.com/api/public/v1.0/"
                + "movies/" + id + ".json?apikey="
                + KEY;
            URL url = new URL(urls);
            InputStreamReader isr = new InputStreamReader(url.openStream(),
                "UTF8");
            BufferedReader br = new BufferedReader(isr);
            Gson gson = new Gson();
            Movie response = gson.fromJson(br, Movie.class);
            movie = response;
        } catch (MalformedURLException ex) {
            Logger.getLogger(RottenTomatoesResponse.class.getName()).log(Level
                .SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot open URL");
        }
        return movie;
    }
}
