package taskmanagement;

import contents.Game;
import critics.GameCritic;
import critics.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * Game department is used to encapsulate simulation details about gaming contents' evaluations
 * Every day a new game stack comes to the Game Department and they are stored in the gameToDoStack
 * Storing contents in gameToDoStack ensures priority of newly coming tasks
 * The contents left since yesterday are less of a priority because new day's contents are on top of them in the toDoStack
 *
 * There is criticsQueue which is instantiated as the GameDepartment object is created
 * It is used to indicate critics who are available to take new task
 *
 * ongoingEvents store Event objects which counts the number of hours left to finish specific task
 * It helps us to determine which task is finished first and which critic is getting enqueued first.
 *
 * ratingsList is a general ArrayList of ratings which outputs of the critics are stored. After each evaluation
 * critics store their rating output to ratingsList and go back to the queue waiting for the next content
 */
public class GameDepartment  {
    private ArrayList<Rating> ratingsList = new ArrayList<>();
    private Stack<Game> gameToDoStack = new Stack<>();
    private Queue<GameCritic> criticsQueue = new LinkedList<>();
    private ArrayList<Event> ongoingEvents = new ArrayList<>();


    public GameDepartment() {
        GameCritic[] gameCritics = {new GameCritic(+5, "1"), new GameCritic(+9, "2"),
                new GameCritic(-3, "3"), new GameCritic(+2, "4"),
                new GameCritic(-7, "5")};
        criticsQueue.addAll(List.of(gameCritics));
    }


    /**
     * This method adds today's contents to the gameToDoStack from which critics will take and evaluate contents
     * @param gameStack a stack of game objects which are created from CSV file
     */
    public void addToday(Stack<Game> gameStack) {
        gameToDoStack.addAll(gameStack);

//        while (!gameStack.isEmpty()){
//            gameToDoStack.add(gameStack.pop());
//        }

    }

    /**
     * This method emulates 8 hour work day. Every hour ongoing events are checked whether they are finished or not
     * If there are some tasks left in the gameToDoStack and some critics are NOT busy, then these critics are assigned
     * a content to evaluate, and this event is added to the ArrayList of ongoingEvents.
     *
     * Every hour 1 hour is getting subtracted from the timeLeft variables of the elements of the ongoingEvents.
     * if any the ongoingEvents' gets finished, their rating is stored in the ratingsList, respective Event is taken out
     * of ongoingEvents and the critic is enqueued into criticsQueue indicating that he/she is Available
     */
    public void rateToday() {
        int time = 0;
        while (time <= 8){

            for (int i = 0; i < ongoingEvents.size(); i++){
                ongoingEvents.get(i).work(1);
                if (ongoingEvents.get(i).getTimeLeft() == 0){
                    System.out.println("\t" +ongoingEvents.get(i).getCritic().getName() +". game critic evaluated "
                                        + ongoingEvents.get(i).getTask().getName());
                    ratingsList.add(ongoingEvents.get(i).getCritic().rate(ongoingEvents.get(i).getTask()));
                    criticsQueue.add(ongoingEvents.get(i).getCritic());
                    ongoingEvents.remove(ongoingEvents.get(i));
                    i--;

                }
            }

            while (!(criticsQueue.isEmpty() || gameToDoStack.isEmpty())){
                GameCritic critic = criticsQueue.poll();
                Game task = gameToDoStack.pop();
                ongoingEvents.add(new Event(critic, task));
                System.out.println("\t" +critic.getName() + ". game critic works on " + task.getName());
            }

            time++;
        }


    }


    /**
     * A deep copy of the ratings list is returned
     * @return
     */
    public ArrayList<Rating> getRatingsList() {
        ArrayList<Rating> tempRatingList = new ArrayList<>();
        for (Rating rating : ratingsList) {
            tempRatingList.add(rating.clone());
        }
        return tempRatingList;
    }
}
