package critics;

import contents.Content;
import contents.Movie;

public class MovieCritic implements ICritic {

    private String name;
    private double opinion;

    public MovieCritic(double opinion,String name) {
        setOpinion(opinion);
        setName(name);
    }

    public MovieCritic(MovieCritic movieCritic){
        setOpinion(movieCritic.getOpinion());
        setName(movieCritic.getName());
    }

    public String getName(){return name;}

    private void setName(String name){this.name=name;}

    public double getOpinion() {
        return opinion;
    }

    private void setOpinion(double opinion) {
        this.opinion = opinion;
    }



    @Override
    public Rating rate(Content content) {

        if (content == null){
            System.out.println("Null object cannot be rated");
            System.exit(0);
        }
        else if(content.getContentCode() != 0){
            System.out.println("MovieCritic: Movie critic cannot rate a non-movie content");
            System.exit(0);
        }

        Movie movie = (Movie) content;
        double rating = movie.getAvgRating()+((movie.getDuration()-150)*0.01)-(2021- movie.getYear())*0.01+getOpinion();
        return new Rating(movie, rating);

    }
}
