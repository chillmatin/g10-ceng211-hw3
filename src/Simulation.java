import critics.Rating;
import taskmanagement.GameDepartment;
import taskmanagement.MovieDepartment;
import taskmanagement.RatingsManager;
import taskmanagement.Warehouse;

import java.util.ArrayList;

/**
 * This homework is designed to get a 100.
 * @author Matin Huseynzade & Berke Udunman
 * G10
 * Homework 3
 */
public class Simulation {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse("contents.csv");
        MovieDepartment movieDepartment = new MovieDepartment();
        GameDepartment gameDepartment = new GameDepartment();


        for (int day = 1; day <= 5; day++){
            System.out.println(day + ".day:");
            movieDepartment.addToday(warehouse.getMovieDay(day));
            movieDepartment.rateToday();
            gameDepartment.addToday(warehouse.getGameDay(day));
            gameDepartment.rateToday();
        }

        System.out.println("Ratings:");
        ArrayList<Rating> movieRatings = movieDepartment.getRatingsList();
        ArrayList<Rating> gameRatings = gameDepartment.getRatingsList();
        ArrayList<Rating> ratings = RatingsManager.combineRatings(movieRatings, gameRatings);
        RatingsManager.printRatings(ratings);

    }

}
