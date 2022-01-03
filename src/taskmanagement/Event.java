package taskmanagement;
import contents.Game;
import critics.GameCritic;

/**
 * Event objects are used to indicate ongoing processes during simulation
 * It encapsulates the duration needed to finish a specific task, the task itself and the critic who is rating the task
 *
 */
public class Event implements Comparable<Object>{

    private GameCritic critic;
    private Double timeLeft;
    private Game task;


    public Event(GameCritic critic, Game task){
        setCritic(critic);
        setTimeLeft(task);
        setTask(task);
    }

    public GameCritic getCritic() {
        return critic;
    }

    private void setCritic(GameCritic critic) {
        this.critic = critic;
    }

    public Double getTimeLeft() {
        return timeLeft;
    }

    private void setTimeLeft(Double timeLeft) {
        this.timeLeft = timeLeft;
    }

    private void setTimeLeft(Game task){
        setTimeLeft(task.getDurationNeededToRate());
    }

    public Game getTask() {
        return task;
    }

    public void setTask(Game task) {
        this.task = task;
    }

    /**
     * As time passes time left to finish ongoing process decreases. So we use work() to lessen time left to finish
     * @param hour
     */
    public void work(double hour){
        setTimeLeft(getTimeLeft() - hour);
    }


    @Override
    public int compareTo(Object o) {
        if (o == null){
            System.out.println("Event: Null object cannot be compared");
            System.exit(0);
        } else if (o != Event.class){
            System.out.println("");
            System.exit(0);
        }
        
        Event other = (Event) o;
        return getTimeLeft().compareTo(other.getTimeLeft());
    }
}
