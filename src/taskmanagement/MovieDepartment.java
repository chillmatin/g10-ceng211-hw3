package taskmanagement;
import contents.*;
import critics.MovieCritic;
import critics.Rating;

import java.util.*;

public class MovieDepartment {

    private Stack<Movie> movieToDoStack = new Stack<>();
    private Queue<MovieCritic> criticsQueue = new LinkedList<>();
    private ArrayList<Rating> ratingsList = new ArrayList<>();

    public MovieDepartment(){
        MovieCritic[] movieCritics= {new MovieCritic(+0.1,"1"),new MovieCritic(-0.2,"2"),new MovieCritic(+0.3,"3")};
        criticsQueue.addAll(List.of(movieCritics));
    }


    /**
     * It checks if there are tasks to do in the movieToDoStack then checks if the maximum number of checks have been today
     * it does so by keeping count of each evaluation. During each evaluation critics are taken out of the queue.
     * After the evaluation rating object is stored and the critic is enqueued into the criticsQueue
     */
    public void rateToday(){

        int counter = 0;
        while (!(movieToDoStack.isEmpty() || counter >= 3) ){
            MovieCritic critic = criticsQueue.poll();
            Movie task = movieToDoStack.pop();
            ratingsList.add(critic.rate(task));
            System.out.println("\t" + critic.getName() + ". movie critic evaluated " + task.getName());
            criticsQueue.add(critic); // Critic added to end of the queue
            counter++;
        }
    }

    /**
     * Adding each day's contents into the movieToDoStack
     * @param movieStack Stack of movie objects to be evaluated.
     */
    public void addToday(Stack<Movie> movieStack){
        movieToDoStack.addAll(movieStack);
    }

    public ArrayList<Rating> getRatingsList(){
        ArrayList<Rating> tempRatingList = new ArrayList<>();
        for(Rating rating : ratingsList){
            tempRatingList.add(rating.clone());
        }
        return tempRatingList;
    }



}
