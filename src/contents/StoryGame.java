package contents;

public class StoryGame extends Game{

    private double storyDuration;       // in hours

    public StoryGame(int arrivalDay, int contentCode, String name, double storyDuration, double avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setStoryDuration(storyDuration);
    }

    public StoryGame(String arrivalDay, String contentCode, String name, String storyDuration, String avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setStoryDuration(storyDuration);
    }

    public StoryGame(StoryGame storyGame) {
        super(storyGame);
        setStoryDuration(storyGame.getStoryDuration());
    }

    public StoryGame() {
        setStoryDuration(-1);
    }


    public double getStoryDuration() {
        return storyDuration;
    }

    private void setStoryDuration(double storyDuration) {
        this.storyDuration = storyDuration;
    }

    private void setStoryDuration(String storyDuration){
        setStoryDuration(Double.parseDouble(storyDuration));
    }


    @Override
    public double getDurationNeededToRate() {
        return storyDuration;       //in hours
    }

    @Override
    public StoryGame clone() {
        return new StoryGame(this);
    }
}
