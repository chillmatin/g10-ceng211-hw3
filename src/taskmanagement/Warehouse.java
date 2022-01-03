package taskmanagement;

import contents.*;

import java.util.ArrayList;
import java.util.Stack;

public class Warehouse extends CSVReader {
    private ArrayList<Stack<Movie>> movieStacks = new ArrayList<>(4);
    private ArrayList<Stack<Game>> gameStacks = new ArrayList<>(4);

    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();

    public Warehouse(String filePath) {
        readContents(filePath);
        initStacks();
        setMovieStacks();
        setGameStacks();
    }


    /**
     * it stacks up all the content provided in the CSV file. It does so by checking the content code of the contents
     * then creating an appropriate content object of it
     * @param path String object indicating the path of the CSV file
     */
    private void readContents(String path) {
        String[][] CSVLines = csvToArray(path);

        for (String[] line : CSVLines) {

            switch (line[1]) {
                case "0":
                    movies.add(new Movie(line[0], line[1], line[2], line[3], line[4], line[5]));
                    break;

                case "1":
                    games.add(new IndefiniteGame(line[0], line[1], line[2], line[3], line[4]));
                    break;

                case "2":
                    games.add(new StoryGame(line[0], line[1], line[2], line[3], line[4]));
                    break;

                case "3":
                    games.add(new CasualGame(line[0], line[1], line[2], line[3], line[4]));
                    break;

            }

        }

    }

    /**
     * initializing movie and game arraylists by adding  empty stacks into them
     */
    private void initStacks() {
        for (int i = 0; i < 5; i++) {
            Stack<Game> dayGameBox = new Stack<>();
            Stack<Movie> dayMovieBox = new Stack<>();
            gameStacks.add(dayGameBox);
            movieStacks.add(dayMovieBox);
        }
    }


    private void setMovieStacks() {

        for (Movie movie : movies) {
            movieStacks.get(movie.getArrivalDay() - 1).add(movie);
        }
    }

    private void setGameStacks() {
        for (Game game : games) {
            gameStacks.get(game.getArrivalDay() - 1).add(game);
        }
    }

    public Stack<Movie> getMovieDay(int day) {
        Stack<Movie> copyMovieStack = new Stack<>();

        for (Movie movie: movieStacks.get(day - 1)){
            copyMovieStack.add(movie.clone());
        }

        return copyMovieStack;
    }

    public Stack<Game> getGameDay(int day) {
        Stack<Game> copyGameStack = new Stack<>();

        for(Game game: gameStacks.get(day-1)){
            copyGameStack.add(game.clone());
        }

        return copyGameStack;
    }
}
