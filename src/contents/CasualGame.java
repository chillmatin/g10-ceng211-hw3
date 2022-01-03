package contents;


public class CasualGame extends Game{

    private double matchDuration;      // in hours

    public CasualGame(int arrivalDay, int contentCode, String name, double matchDuration, double avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setMatchDuration(matchDuration);
    }

    public CasualGame(String arrivalDay, String contentCode, String name, String matchDuration, String avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setMatchDuration(matchDuration);
    }

    public CasualGame(CasualGame game) {
        super(game);
        setMatchDuration(game.getMatchDuration());
    }

    public CasualGame() {
        setMatchDuration(-1);
    }

    public double getMatchDuration() {
        return matchDuration;
    }

    private void setMatchDuration(double matchDuration) {
        this.matchDuration = matchDuration;
    }

    private void setMatchDuration(String matchDuration) {
        setMatchDuration(Double.parseDouble(matchDuration));
    }

    @Override
    public double getDurationNeededToRate() {
        return 3 * matchDuration;
    }

    @Override
    public CasualGame clone() {
        return new CasualGame(this);
    }
}
