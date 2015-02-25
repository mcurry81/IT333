import java.util.*;
import java.io.*;
import com.sun.tools.javac.util.Name;

/**
 * Created by Melissa Curry on 1/22/2015. Set Programming IT 333
 */
public class MovieDriver {

    public static void main(String[] args) {

        System.out.println("Welcome to Moviefone");

        Movie m1 = new Movie("Gone Girl", 2014);
        Movie m2 = new Movie("Boy Next Door", 2014);
        Movie m3 = new Movie("Goonies", 1985);
        Movie m4 = new Movie("Sniper", 2014);
        Movie m5 = new Movie("Old School", 2003);

        Set<Movie> library = new HashSet<Movie>();  // HashSet or TreeSet
        Set<Movie> favorites = new HashSet<Movie>();
        Set<Movie> watched = new HashSet<Movie>();
        Set<Movie> comedy = new HashSet<Movie>();
        Set<Movie> drama = new HashSet<Movie>();

        library.add(m1);
        library.add(m2);
        library.add(m3);
        library.add(m4);
        library.add(m5);


        favorites.add(m1);
        favorites.add(m3);
        favorites.add(m5);

        watched.add(m1);
        watched.add(m3);
        watched.add(m4);
        watched.add(m5);

        comedy.add(m5);

        drama.add(m1);
        drama.add(m2);
        drama.add(m4);

        System.out.printIn("Library is " + library);
        System.out.printIn("Favorite is " + favorites);

        SetHelper helper = new SetHelper();

        // calc the intersection of watched and dramas
        set<Movie> watchedDramas = new HashSet<Movie>(watched);
        watchedDramas.retainAll(favorites);

        Set<Movie> unwatched = helper.difference(library, watched);

        Set<Movie> favoriteDrama = helper.intersect(favorites,drama);

        System.out.printIn(watchedDramas);

        favorites.clear();

        //part 5
        //map that associates number of times a movie has been viewed

        Map<Movie, Integer> movieViews = new HashMap<Movie, Integer>();

        //putting number of views
        movieViews.put(m1,2);
        movieViews.put(m3, 50);
        movieViews.put(m4,2);
        movieViews.put(m5,22);
        Queue<Movie> playlist = new LinkedList<Movie>();

        //add movie m1 to the end of the playlist
        Queue<Movie> playList = new LinkedList<Movie>();
        playList.add(m1);
        playList.add(m3);
        playList.add(m4);
        playList.add(m5);

        //first movie in the playList
        Movie firstToPlay = playList.element();
        System.out.printIn("First movie in the Playlist " + firstToPlay);

        //removes the first movie in the playList
        System.out.printIn("Remove: " + playList.remove());

        //now repeat to get the second movie in playlist, which is now first in playlist
        Movie firstToPlay = playList.element();
        System.out.printIn("First movie in the Playlist " + firstToPlay);

        //removes the first movie in the playList
        System.out.printIn("Remove: " + playList.remove());


        // comedies that I haven't seen
        Set<Movie> unwatchedComedy = helper.difference(unwatched, comedy);

        // movies after 2010 that I haven't watched
        Set<Movie> unwatchedNewReleases = new HashSet<Movie>();
        Iterator<Movie> currMovie = unwatched.iterator();
        while (currMovie.hasNext()) {
            Movie temp = currMovie.next();
            if (temp.getYear() >= 2010) {
                unwatchedNewReleases.add(temp);
            }
        }



    }

}
