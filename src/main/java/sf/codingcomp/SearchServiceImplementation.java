package sf.codingcomp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;
import sf.codingcomp.model.Platform;
import sf.codingcomp.reader.Reader;

public class SearchServiceImplementation implements SearchService {
	Reader read = new Reader();
	List<Game> games = read.readGames();
	List<Movie> movies = read.readMovies();
	List<Entertainment> enters = new ArrayList<Entertainment>();
	@Override
	public List<Movie> searchMovie(String searchValue) {
		movies.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		return movies;
	}

	@Override
	public List<Game> searchGame(String searchValue) {
		games.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		return games;
	}

	@Override
	public List<Entertainment> searchGameAndMovies(String searchValue) {
		enters.addAll(games);
		enters.addAll(movies);
		enters.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		return enters;
	}

	@Override
	public List<Movie> sortMoviesByDate(String searchValue, Double userRating) {
		movies.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		movies.removeIf(obj -> Double.parseDouble(obj.getUserRating()) < userRating);
		movies.sort((Movie m1, Movie m2) -> m1.getReleased().compareTo(m2.getReleased()));
		return movies;
	}

	@Override
	public List<Game> sortGamesByDate(String searchValue, Double userRating) {
		games.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		games.removeIf(obj -> Double.parseDouble(obj.getUserRating()) < userRating);
		games.sort((Game m1, Game m2) -> m1.getReleased().compareTo(m2.getReleased()));
		return games;
	}

	@Override
	public List<Entertainment> sortGamesAndMoviesByDate(String searchValue,
			Double userRating) {
		enters.addAll(games);
		enters.addAll(movies);
		enters.removeIf(obj -> !obj.getTitle().toLowerCase().contains(searchValue.toLowerCase()));
		enters.sort((Entertainment m1, Entertainment m2) -> m1.getReleased().compareTo(m2.getReleased()));
		return enters;
	}

	@Override
	public List<Movie> moviesByGenreAndRating(String Genre, String Rating) {
		movies.removeIf(obj -> !obj.getGenre().toLowerCase().contains(Genre.toLowerCase()));
		movies.removeIf(obj -> !obj.getRated().toLowerCase().equals(Rating.toLowerCase()));
		return movies;
	}

	@Override
	public List<Game> gamesByGenreAndRating(String Genre, String Rating) {
		games.removeIf(obj -> !obj.getGenre().toLowerCase().contains(Genre.toLowerCase()));
		games.removeIf(obj -> !obj.getRated().toLowerCase().contains(Rating.toLowerCase()));
		return games;
	}

	@Override
	public List<Entertainment> entertainmentByGenreAndRating(String Genre,
			String Rating) {
		enters.addAll(games);
		enters.addAll(movies);
		enters.removeIf(obj -> !obj.getGenre().toLowerCase().contains(Genre.toLowerCase()) && !obj.getRated().toLowerCase().equals(Rating.toLowerCase()));
		return enters;
	}

	@Override
	public <T extends Entertainment> void checkout(T title, Platform<T> platform) {
		enters.addAll(games);
		enters.addAll(movies);

	}

}
