package sf.codingcomp.model;

public interface Platform<T extends Entertainment> {

    /**
     * This method should take in a movie or a game and return whether or not it is in stock.
     * 
     * @param t
     * @return
     */
    boolean inStock( T t );

    /**
     * This method should allow someone to checkout a game or a movie.
     * 
     * @param t
     */
    void checkout( T t );
}
