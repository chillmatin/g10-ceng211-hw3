package contents;

public abstract class Game  extends Content{

    public Game(int arrivalDay, int contentCode, String name, double avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
    }

    public Game(String arrivalDay, String contentCode, String name, String avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
    }

    public Game(Game game) {
        super(game);
    }

    public Game() {
        super();
    }

    /**
     * this method will specify game type and calculate required time to rate accordingly
     *
     * Indefinite Game: 4 hours
     * Story Game: Complete Story Duration
     * Casual Game: 3 matches long
     *
     * @return amount of time needed to rate this specific content
     */
    public abstract double getDurationNeededToRate();

    public abstract Game clone();
}
