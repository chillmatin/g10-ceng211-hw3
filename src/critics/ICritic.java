package critics;

import contents.Content;

public interface ICritic {

    /**
     * This method takes any instance of content object and returns appropriate Rating object.
     * There are different ways to rate contents:
     *
     * Movie: average rating + ((duration - 150) * 0.01) - ((2021 - year) * 0.01) + (critic’s opinion)
     * Indefinite Game: average rating + ((10 - minimum evaluation time) * 0.25) + (critic’s opinion)
     * Story Game: average rating + (story duration * 0.25) + (critic’s opinion)
     * Casual Game: average rating + ((match duration - 3) * 3) + (critic’s opinion)
     *
     * @return a Rating object which includes rated content object and the rating data
     */
    Rating rate(Content content);


    /**
     * This method returns the name of the critic
     * @return String variable for the name of the critic
     */
    String getName();

}
