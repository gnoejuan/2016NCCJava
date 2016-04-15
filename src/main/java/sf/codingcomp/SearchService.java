package sf.codingcomp;

import java.util.List;

import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;
import sf.codingcomp.model.Platform;

public interface SearchService {
    /*********************************** SET ONE ***********************************/

    /**
     * This method should find a list of movies using a partial search value
     * 
     * @return List of all movies with a given search value
     *         @
     */
    List<Movie> searchMovie( String searchValue );

    /**
     * This method should find a list of games using a partial search value
     * 
     * @return List of all games with a given search value
     *         @
     */
    List<Game> searchGame( String searchValue );

    /**
     * This method should find a list of movies and games using a partial search value
     * 
     * @return List of all movies and games with a given search value
     *         @
     */
    List<Entertainment> searchGameAndMovies( String searchValue );

    /*********************************** SET TWO ***********************************/

    /**
     * This method should find a list of movies using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of all movies with a given search value
     *         @
     */
    List<Movie> sortMoviesByDate( String searchValue, Double userRating );

    /**
     * This method should find a list of games using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of all games with a given search value
     *         @
     */
    List<Game> sortGamesByDate( String searchValue, Double userRating );

    /**
     * This method should find a list of movies and games using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of all movies and games with a given search value
     *         @
     */
    List<Entertainment> sortGamesAndMoviesByDate( String searchValue, Double userRating );

    /*********************************** SET THREE *********************************/

    /**
     * This method should find a list of movies with a specific genre (Comedy, Action, etc) and rating (G, PG, etc)
     * 
     * @return List of movies
     *         @
     */
    List<Movie> moviesByGenreAndRating( String Genre, String Rating );

    /**
     * This method should find a list of games with a specific genre (Action, Adventure, etc) and rating ((E)veryone, (T)een, etc)
     * 
     * @return List of games
     *         @
     */
    List<Game> gamesByGenreAndRating( String Genre, String Rating );

    /**
     * This method should find a list of movies and games using a specific genre and rating (G=E, T=PG or PG-13, M=R)
     * 
     * @return List of movies and games
     *         @
     */
    List<Entertainment> entertainmentByGenreAndRating( String Genre, String Rating );

    /**
     * This method should allow someone to checkout a movie or a game for a particular platform.
     * The checkout should affect the title passed in directly and only in memory.
     * There is no need to store the changes back to the json files.
     * 
     * @param title
     * @param platform
     */
    <T extends Entertainment> void checkout( T title, Platform<T> platform );
}
