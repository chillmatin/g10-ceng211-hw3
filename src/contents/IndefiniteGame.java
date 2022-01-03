package contents;

public class IndefiniteGame extends Game{
    private double minEvalTime;     // in hours

    public IndefiniteGame(int arrivalDay, int contentCode, String name, double minEvalTime, double avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setMinEvalTime(minEvalTime);
    }

    public IndefiniteGame(String arrivalDay, String contentCode, String name, String minEvalTime, String avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setMinEvalTime(minEvalTime);
    }

    public IndefiniteGame(IndefiniteGame game) {
        super(game);
        setMinEvalTime(game.getMinEvalTime());
    }

    public IndefiniteGame() {
        super();
        setMinEvalTime(-1);
    }

    public double getMinEvalTime() {
        return minEvalTime;
    }

    private void setMinEvalTime(double minEvalTime) {
        this.minEvalTime = minEvalTime;
    }

    private void setMinEvalTime(String minEvalTime) {
        setMinEvalTime(Double.parseDouble(minEvalTime));
    }


    @Override
    public double getDurationNeededToRate() {
        return 4;       // hours
    }

    @Override
    public IndefiniteGame clone() {
        return new IndefiniteGame(this);
    }
}
