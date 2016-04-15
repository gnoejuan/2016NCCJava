package sf.codingcomp;

import java.util.List;

import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;
import sf.codingcomp.model.Platform;

public class SearchServiceImplementation implements SearchService {

	@Override
	public List<Movie> searchMovie(String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> searchGame(String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entertainment> searchGameAndMovies(String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> sortMoviesByDate(String searchValue, Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> sortGamesByDate(String searchValue, Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entertainment> sortGamesAndMoviesByDate(String searchValue,
			Double userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> moviesByGenreAndRating(String Genre, String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> gamesByGenreAndRating(String Genre, String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entertainment> entertainmentByGenreAndRating(String Genre,
			String Rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entertainment> void checkout(T title, Platform<T> platform) {
		// TODO Auto-generated method stub

	}

}
