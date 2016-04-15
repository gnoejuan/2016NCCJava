package sf.codingcomp.model;

public enum GamePlatform implements Platform<Game> {
    LNX {
    },
    MAC {
    },
    PC {
    },
    PSP {
    },
    PS2 {
    },
    PS4 {
    },
    X {
    },
    X360 {
    },
    X1 {
    },
    WII {
    },
    WIIU {
    };

    @Override
    public boolean inStock( Game game ) {
        // TODO - determine if the game is in stock
        return false;
    }

    @Override
    public void checkout( Game game ) {
        // TODO - checkout the game
    }

}
