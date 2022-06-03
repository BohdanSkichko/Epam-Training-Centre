package chapter5.task19movie;

public class Movie {
    private final String name;
    private MovieInfo movieInfo;

    public Movie(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void obtainInfoMovie(Double time, String generes, String filmmaker) {
        movieInfo = new MovieInfo();
        movieInfo.setTime(time);
        movieInfo.setGenres(generes);
        movieInfo.setFilmmaker(filmmaker);

    }

    @Override
    public String toString() {
        return "Movie " + name + "\n" + "MovieInfo" + "\n" + getMovieInfo();

    }

    public String getMovieInfo() {
        return "genres: " + movieInfo.getGenres() + " "
                + "time: " + movieInfo.getTime() + " "
                + "filmmaker: " + movieInfo.getFilmmaker();
    }



    private class MovieInfo {
        private Double time;
        private String genres;
        private String filmmaker;


        public void setTime(Double time) {
            this.time = time;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public void setFilmmaker(String filmmaker) {
            this.filmmaker = filmmaker;
        }

        public Double getTime() {
            return time;
        }

        public String getGenres() {
            return genres;
        }

        public String getFilmmaker() {
            return filmmaker;
        }

        @Override
        public String toString() {
            return "MovieInfo" + "\n";
        }
    }
}
