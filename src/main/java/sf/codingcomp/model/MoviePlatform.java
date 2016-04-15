package sf.codingcomp.model;

public enum MoviePlatform implements Platform<Movie> {
    DVD {
    },
    BLU_RAY {
    };

    @Override
    public boolean inStock( Movie movie ) {
        // TODO - determine if the movie is in stock
        return false;
    }

    @Override
    public void checkout( Movie movie ) {
        // TODO - checkout the game
    }

}
