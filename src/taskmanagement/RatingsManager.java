package taskmanagement;

import contents.Content;
import contents.Game;
import contents.Movie;
import critics.Rating;

import java.util.ArrayList;
import java.util.Collections;

public abstract class RatingsManager {

    public static ArrayList<Rating> combineRatings(ArrayList<Rating> ratingList1, ArrayList<Rating> ratingList2){
        Collections.sort(ratingList1);
        Collections.sort(ratingList2);

        ArrayList<Rating> tempList = new ArrayList<>();     // avoiding data mutation
        tempList.addAll(ratingList1);
        tempList.addAll(ratingList2);
        return tempList;
    }

    public static void printRatings(ArrayList<Rating> ratings){
        for (Rating rating : ratings){
            System.out.println(rating.toString());
        }
    }
}
