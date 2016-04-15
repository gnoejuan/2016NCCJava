package sf.codingcomp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sf.codingcomp.exception.TitleNotAvailableException;
import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.GamePlatform;
import sf.codingcomp.model.Movie;

public class SearchServiceTest {
    private SearchService searchService;

    @Before
    public void setup() {
        searchService = new SearchServiceImplementation();
    }

    /************************************** SET ONE **************************************/

    /**
     * This method should find a list of movies using a partial search value
     * 
     * @return List of movies using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchMovies() throws Exception {
        List<Movie> movies = searchService.searchMovie( "father" );
        assertNotNull( movies );
        assertEquals( 2, movies.size() );
    }

    /**
     * This method should find a list of games using a partial search value
     * 
     * @return List of games using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchGames() throws Exception {
        List<Game> games = searchService.searchGame( "call" );
        assertNotNull( games );
        assertEquals( 7, games.size() );
    }

    /**
     * This method should find a list of movies and games using a partial search value
     * 
     * @return List of movies and games using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchGamesAndMovies() throws Exception {
        List<Entertainment> searchReturn = searchService.searchGameAndMovies( "star" );
        assertNotNull( searchReturn );
        assertEquals( 9, searchReturn.size() );
    }

    /************************************** SET TWO **************************************/

    /**
     * This method should find a list of movies using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of movies using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchMoviesSortedByMostRecentReleaseDateAndFilteredByUserRating() throws Exception {
        List<Movie> movies = searchService.sortMoviesByDate( "war", 8.7 );

        ArrayList<String> expectedDataMovieList = createExpectedDataMovieList();

        for ( int i = 0; i < movies.size(); i++ ) {
            String actualMovieDateAndTitle = movies.get( i ).getReleased() + ", " + movies.get( i ).getTitle();
            String expectedMovieDateAndTitle = expectedDataMovieList.get( i );

            assertTrue( Double.parseDouble( movies.get( i ).getUserRating() ) >= 8.7 );
            assertEquals( expectedMovieDateAndTitle, actualMovieDateAndTitle );
        }

        assertNotNull( movies );
        assertEquals( 2, movies.size() );
    }

    /**
     * This method should find a list of games using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of games using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchGamesSortedByMostRecentReleaseDateAndFilteredByUserRating() throws Exception {
        List<Game> games = searchService.sortGamesByDate( "war", 8.7 );

        ArrayList<String> expectedDataGameList = createExpectedDataGameList();

        for ( int i = 0; i < games.size(); i++ ) {
            String actualGameDateAndTitle = games.get( i ).getReleased() + ", " + games.get( i ).getTitle();
            String expectedGameDateAndTitle = expectedDataGameList.get( i );

            assertTrue( Double.parseDouble( games.get( i ).getUserRating() ) >= 8.7 );
            assertEquals( expectedGameDateAndTitle, actualGameDateAndTitle );
        }

        assertNotNull( games );
        assertEquals( 4, games.size() );
    }

    /**
     * This method should find a list of movies and games using a partial search value, a User Rating of X or greater, and sort by release date
     * 
     * @return List of movies and games using a partial search value
     * @throws Exception
     */
    @Test
    public void testSearchGamesAndMoviesSortedByMostRecentReleaseDateAndFilteredByUserRating() throws Exception {
        List<Entertainment> gamesAndMovies = searchService.sortGamesAndMoviesByDate( "war", 8.7 );

        ArrayList<String> expectedDataGameMovieList = createExpectedDataGameMovieList();

        for ( int i = 0; i < gamesAndMovies.size(); i++ ) {
            String actualGameMovieDateAndTitle = gamesAndMovies.get( i ).getReleased() + ", " + gamesAndMovies.get( i ).getTitle();
            String expectedGameMovieDateAndTitle = expectedDataGameMovieList.get( i );

            assertTrue( Double.parseDouble( gamesAndMovies.get( i ).getUserRating() ) >= 8.7 );
            assertEquals( expectedGameMovieDateAndTitle, actualGameMovieDateAndTitle );
        }

        assertNotNull( gamesAndMovies );
        assertEquals( 6, gamesAndMovies.size() );
    }

    /************************************** SET THREE **************************************/

    /**
     * This method should find a list of movies with a specific genre (Comedy, Action, etc) and rating (G, PG, etc)
     * 
     * @return List of movies
     * @throws Exception
     */
    @Test
    public void testSearchMoviesByGenreAndRating() throws Exception {
        List<Movie> moviesByGenreAndRating = searchService.moviesByGenreAndRating( "Action", "R" );
        moviesByGenreAndRating
                .forEach( m -> assertTrue( Arrays.asList( m.getGenre().split( "," ) ).contains( "Action" ) && m.getRated().equals( "R" ) ) );
    }

    /**
     * This method should find a list of games with a specific genre (Action, Adventure, etc) and rating ((E)veryone, (T)een, etc)
     * 
     * @return List of games
     * @throws Exception
     */
    @Test
    public void testSearchGamesByGenreAndRating() throws Exception {
        List<Movie> moviesByGenreAndRating = searchService.moviesByGenreAndRating( "Adventure", "E" );
        moviesByGenreAndRating.forEach( m -> assertTrue( Arrays.asList( m.getGenre().split( "," ) ).contains( "Adventure" )
                && m.getRated().equals( "R" ) ) );
    }

    /**
     * This method should find a list of movies and games using a specific genre and rating (G=E, T=PG, M=R)
     * PG-13 is for movies only
     * 
     * @return List of movies and games
     * @throws Exception
     */
    @Test
    public void testSearchEntertainmentByGenreAndRating() throws Exception {
        List<Entertainment> pg13Action = searchService.entertainmentByGenreAndRating( "Action", "PG-13" );
        // Should not be any games that are rated PG-13.
        pg13Action.forEach( m -> assertTrue( m instanceof Movie && Arrays.asList( ( (Movie) m ).getGenre().split( "," ) ).contains( "Action" ) ) );

        List<Entertainment> matureRAction = searchService.entertainmentByGenreAndRating( "Action", "R" );
        // Should have games rated M and movies rated R
        matureRAction.forEach( m -> assertTrue( Arrays.asList( m.getGenre().split( "," ) ).contains( "Action" )
                && ( m.getRated().equals( "M" ) || m.getRated().equals( "R" ) ) ) );
        assertEquals( 56, matureRAction.size() );
        
        List<Entertainment> matureMAction = searchService.entertainmentByGenreAndRating( "Action", "M" );
        // Should have games rated M and movies rated R
        matureMAction.forEach( m -> assertTrue( Arrays.asList( m.getGenre().split( "," ) ).contains( "Action" )
                && ( m.getRated().equals( "M" ) || m.getRated().equals( "R" ) ) ) );
        assertEquals( 56, matureMAction.size() );
    }

    /************************************** SET FOUR **************************************/
    /**
     * This method should check the availability of the entertainment
     * 
     * @return List of movies and games
     * @throws Exception
     */

    @Test
    public void shouldBeAvailable() {
        Game untilDawn = searchService.searchGame( "Until Dawn" ).get( 0 );
        assertEquals( 1, Integer.parseInt( untilDawn.getStockPs4() ) );
        searchService.checkout( untilDawn, GamePlatform.PS4 );
        assertEquals( 0, Integer.parseInt( untilDawn.getStockPs4() ) );
    }

    @Test
    public void shouldNotBeAvailableAfterCheckout() {
        Game untilDawn = searchService.searchGame( "Until Dawn" ).get( 0 );
        assertEquals( 1, Integer.parseInt( untilDawn.getStockPs4() ) );
        searchService.checkout( untilDawn, GamePlatform.PS4 );
        assertEquals( 0, Integer.parseInt( untilDawn.getStockPs4() ) );
        try {
            searchService.checkout( untilDawn, GamePlatform.PS4 );
            fail();
        } catch ( TitleNotAvailableException e ) {
            assertEquals( 0, Integer.parseInt( untilDawn.getStockPs4() ) );
        }
    }

    private ArrayList<String> createExpectedDataMovieList() {
        ArrayList<String> expectedDataMovieList = new ArrayList<String>();
        expectedDataMovieList.add( "20 Jun 1980, Star Wars: Episode V - The Empire Strikes Back" );
        expectedDataMovieList.add( "25 May 1977, Star Wars: Episode IV - A New Hope" );

        return expectedDataMovieList;
    }

    private ArrayList<String> createExpectedDataGameList() {
        ArrayList<String> expectedDataGameList = new ArrayList<String>();
        expectedDataGameList.add( "20 Dec 2011, Star Wars: The Old Republic" );
        expectedDataGameList.add( "10 Nov 2009, Call of Duty: Modern Warfare 2" );
        expectedDataGameList.add( "01 Nov 2005, Star Wars: Battlefront II" );
        expectedDataGameList.add( "18 Jul 2003, Star Wars: Knights of the Old Republic" );

        return expectedDataGameList;
    }

    private ArrayList<String> createExpectedDataGameMovieList() {
        ArrayList<String> expectedDataGameMovieList = new ArrayList<String>();
        expectedDataGameMovieList.add( "20 Dec 2011, Star Wars: The Old Republic" );
        expectedDataGameMovieList.add( "10 Nov 2009, Call of Duty: Modern Warfare 2" );
        expectedDataGameMovieList.add( "01 Nov 2005, Star Wars: Battlefront II" );
        expectedDataGameMovieList.add( "18 Jul 2003, Star Wars: Knights of the Old Republic" );
        expectedDataGameMovieList.add( "20 Jun 1980, Star Wars: Episode V - The Empire Strikes Back" );
        expectedDataGameMovieList.add( "25 May 1977, Star Wars: Episode IV - A New Hope" );

        return expectedDataGameMovieList;
    }
}
