package contents;

public class Movie extends Content implements Cloneable {
    private int year;
    private int duration;   // in minutes

    public Movie(int arrivalDay, int contentCode, String name, int year, int duration, double avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setYear(year);
        setDuration(duration);
    }

    public Movie(String arrivalDay, String contentCode, String name, String year, String duration, String avgRating) {
        super(arrivalDay, contentCode, name, avgRating);
        setYear(year);
        setDuration(duration);
    }

    public Movie(Movie movie){
        super(movie);
        setYear(movie.getYear());
        setDuration(movie.getDuration());

    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setYear(String year){
        setYear(Integer.parseInt(year));
    }


    public int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    private void setDuration(String duration){
        setDuration(Integer.parseInt(duration));
    }


    @Override
    public Movie clone() {
        return new Movie(this);
    }
}
