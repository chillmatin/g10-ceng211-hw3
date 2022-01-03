package critics;

import contents.*;

public class GameCritic implements ICritic{

    private double opinion;
    private double hours;
    private String name;

    public GameCritic(double opinion, String name) {
        setOpinion(opinion);
        setName(name);
    }

    public GameCritic(GameCritic gameCritic){
        setOpinion(gameCritic.getOpinion());
        setName(gameCritic.getName());
    }


    public double getOpinion() {
        return opinion;
    }

    private void setOpinion(double opinion) {
        this.opinion = opinion;
    }

    @Override
    public Rating rate(Content content) {

        if (content == null) {
            System.out.println("GameCritic: Null object cannot be rated.");
            System.exit(0);
        }

        double rating = -1;
        switch (content.getContentCode()) {
            case 0:
                System.out.println("Movie contents cannot be evaluated by Game Critics");
                System.exit(0);
                break;

            case 1:
                IndefiniteGame indefiniteGame = (IndefiniteGame) content;
                rating = indefiniteGame.getAvgRating() + ((10 - indefiniteGame.getMinEvalTime()) * 0.25) + getOpinion();
                if (rating > 100){rating = 100;}

                return new Rating(indefiniteGame, rating);


            case 2:
                StoryGame storyGame = (StoryGame) content;
                rating = storyGame.getAvgRating() + (storyGame.getStoryDuration() * 0.25) + getOpinion();
                if (rating > 100){rating = 100;}
                return new Rating(storyGame, rating);


            case 3:
                CasualGame casualGame = (CasualGame) content;
                rating = casualGame.getAvgRating() + ((casualGame.getMatchDuration() - 3) * 3) + getOpinion();
                if (rating > 100){rating = 100;}
                return new Rating(casualGame, rating);


            default:
                System.out.println("Invalid Content Code");
                System.exit(0);
                break;
        }


        return new Rating(null, -1);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}



