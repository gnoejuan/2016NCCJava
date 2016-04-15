package sf.codingcomp.model;

import com.google.gson.annotations.SerializedName;

public class Entertainment {

    @SerializedName( "Title" )
    private String title;
    @SerializedName( "Year" )
    private String year;
    @SerializedName( "Rated" )
    private String rated;
    @SerializedName( "Released" )
    private String released;
    @SerializedName( "Actors" )
    private String actors;
    @SerializedName( "Plot" )
    private String plot;
    @SerializedName( "Language" )
    private String language;
    @SerializedName( "Country" )
    private String country;
    @SerializedName( "Awards" )
    private String awards;
    @SerializedName( "Poster" )
    private String poster;
    @SerializedName( "UserRating" )
    private String userRating;
    @SerializedName( "Type" )
    private String type;
    @SerializedName( "Genre" )
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear( String year ) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated( String rated ) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased( String released ) {
        this.released = released;
    }

    public String getActors() {
        return actors;
    }

    public void setActors( String actors ) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot( String plot ) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage( String language ) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards( String awards ) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster( String poster ) {
        this.poster = poster;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating( String userRating ) {
        this.userRating = userRating;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre( String genre ) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Entertainment [title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released + ", actors=" + actors + ", plot="
                + plot + ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster=" + poster + ", userRating="
                + userRating + ", type=" + type + ", genre=" + genre + "]";
    }

}
