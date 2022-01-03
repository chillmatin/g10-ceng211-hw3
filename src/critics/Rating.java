package critics;

import contents.Content;
import contents.Game;
import contents.Movie;

public class Rating implements Comparable, Cloneable{

    private Content ratedContent;       // Content objects are immutable
    private double rating;


    public Rating(Content ratedContent, double rating) {
        setRatedContent(ratedContent);
        setRating(rating);
    }

    public Rating(Rating rating){
        setRatedContent(rating.getRatedContent());
        setRating(rating.getRating());

    }

    public Content getRatedContent() {
        return ratedContent;        // It is safe to send the object itself, since Content objects are immutable
    }

    private void setRatedContent(Content ratedContent) {
        this.ratedContent = ratedContent;
    }

    public double getRating() {
        return rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null){
            System.out.println("Null object cannot be compared!");
            System.exit(0);
        }else if (o.getClass() != getClass()){
            System.out.println("Rating: Unmatching data type");
            System.exit(0);
        }

        Rating ratingObject = (Rating) o;
        return getRatedContent().compareTo(ratingObject.getRatedContent());

    }

    @Override
    public Rating clone() {
        return new Rating(this);
    }

    public String toString(){

        if (ratedContent instanceof Game){
            return "\t"+ratedContent.getName() +", "+String.format("%.0f",getRating());
        } else if (ratedContent instanceof Movie){
            Movie ratedMovie = (Movie) ratedContent;
            return "\t"+ratedContent.getName() + " (" + ratedMovie.getYear() + ")" + ", "+String.format("%.1f",getRating());
        }
        return "Inappropriate Rating object.";
    }
}
