/**
* AP CSA 1
* Final Project
* TV Show Manager that allows the user to keep track of their shows
* @author KapilTaspa
* 05/18/23
*/
import java.util.*;

/* ShowList Class that has the array of shows and an array of favorites. Methods for each function of the program are in this class as this is where the arraylists are instantiated. */
public class ShowList
  {
    // declare an ArrayList
    private static ArrayList<Show> slist;
    private ArrayList<Show> flist;
    //constructor to construct/instantiate the ArrayList

    /**
    * Constructs a ShowList object with empty arraylists for all shows and favorites
    */
    public ShowList() {
        slist = new ArrayList<>();
        flist = new ArrayList<>();
    }
    
    /**
    * Uses the index to search for a show and thenoutputs the information of that specific show
    * @param index the index of the show
    * @return the formatted data of the show
    */
    public String toStringIndex(int index) {
      String out = "";
      out = String.format("%-25s", slist.get(index).getName()) + String.format("%10s", slist.get(index).getPlatform()) + String.format("%10s",slist.get(index).getLength()) + String.format("%10s", slist.get(index).getCurrent()) + String.format("%15s", slist.get(index).getRating()) + String.format("%15s", slist.get(index).getYear()) + String.format("%20s", slist.get(index).getType()) + "\n";
      return out;
    }

    /**
    * toString method for the favorites list does the same as the shows to string
    * @return formatted string of the favorite
    */
    public String favoriteToString() {
      String f = "";
      for(int i = 0; i<flist.size(); i++)
        f += String.format("%-25s", flist.get(i).getName()) + "    " + String.format("%10s", flist.get(i).getPlatform()) + "    " + String.format("%10s",flist.get(i).getLength()) + "    " + String.format("%10s",flist.get(i).getCurrent()) + "\n";
        
      return f;
    }

    /**
    * adds show to the all shows list
    * @param show object that is getting added
    * @return true if the show is added false otherwise
    */
    public static boolean addShow(Show show) {
        return slist.add(show);
    }

    /**
     * Removes a show from the list by its title.
     * @param title the title of the show to be removed
     */
    public void removeShowByTitle(String title) {
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName()))
          slist.remove(i);
      }
    }

    /**
    * finds a show in the shows list based on the title
    * @param title title of the show
    * @return the index of the show or -1 if not in list
    */
    public int findShows(String title) {
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName()))
          return i;
        }
      return -1;
      }

    /**
    * makes all elements of show list into formatted string
    * @return formatted string of all elements of list
    */
    public String toString() {
      String s = "";
      for(int i = 0; i<slist.size(); i++)
        s += String.format("%-25s", slist.get(i).getName()) + String.format("%10s", slist.get(i).getPlatform()) + String.format("%10s",slist.get(i).getLength()) + String.format("%10s", slist.get(i).getCurrent()) + String.format("%15s", slist.get(i).getRating()) + String.format("%15s", slist.get(i).getYear()) + String.format("%20s", slist.get(i).getType()) + "\n";
        
      return s;
    }

    /**
    * increases the current episode of a specific show by one
    * @param title the title of the show
    */
    public void incrementEpisode(String title){
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName())){
          int temp = slist.get(i).getCurrent();
          temp++;
          slist.get(i).newEpisode(temp);
        }
      }
    }

    /**
    * updates the rating of a show to a new rating given by user
    * @param title the title of the show
    * @param rating the new rating of the show
    */
    public void updateRating(String title, int rating) {
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName())) {
          slist.get(i).newRating(rating);
        }
      }
    }

    /*
    * adds a show to the favorites list given the name
    * @param title the title of the show
    */
    public void addFavorite(String title){
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName())){
          slist.get(i).newFavorite(true);
          flist.add(slist.get(i));
        }
      }
    }

    /**
    * removes a show from the favorite list but keeps is on the main list
    * @param title the title of the show
    */
    public void removeFavorite(String title){
      for(int i = 0; i<slist.size(); i++){
        if(title.equalsIgnoreCase(slist.get(i).getName())){
          slist.get(i).newFavorite(false);
          flist.remove(slist.get(i));
        }
      }
    }

    /**
    * finds the shows that the user is currently watching
    * @return the formatted information of the shows that are currently watching
    */
    public String findCurrent() {
      String out = "";
      for(int i = 0; i<slist.size(); i++){
        if(slist.get(i).getLength() - slist.get(i).getCurrent() != 0 )
          out += toStringIndex(i);
        }
      return out;
      } 

    /**
    * finds the shows that the user has already watched and prints them
    * @return the formatted information of show that already watched
    */
    public String findShowsWatched() {
      String out = "";
      for(int i = 0; i<slist.size(); i++){
        if(slist.get(i).getLength() - slist.get(i).getCurrent() == 0 ){
          out+= toStringIndex(i);}
        
        }
      return out;
      }

    /**
    * sorts all the shows in the list by rating in descending order using a bubble sort
    */
    public void sortByRating() {
      Show temp = new Show();
      for(int i = 0; i <slist.size()+1; i++) {
        for(int k = 0; k < slist.size()-i-1; k++) {
          if(slist.get(k).getRating() < slist.get(k+1).getRating()){
            temp = slist.get(k);
            slist.set(k, slist.get(k+1));
            slist.set(k+1, temp);
          }
        }
      }
    }

    /**
    * calculates the episodes left given the title of a show
    * @param title the title of the show
    * @return the number of episodes left to watch
    */
    public int episodesLeft(String title) {
      int current = slist.get(findShows(title)).getCurrent();
      int total = slist.get(findShows(title)).getLength();
      return total - current;
    }

    /**
    * formats each of the shows into the proper format to put into the file
    * @return the formatted string of all the shows
    */
    public String saveToFile() {
      String out = "";
      for(int i = 0; i < slist.size(); i++) {
        out += slist.get(i).getName() + "\n" + slist.get(i).getPlatform()+ "\n" + slist.get(i).getLength() + "\n" + slist.get(i).getRating() + "\n" + slist.get(i).getYear() + "\n" + slist.get(i).getType() + "\n" + slist.get(i).getCurrent() + "\n"+ slist.get(i).getFavorite() + "\n";
      }
      return out;
    }
    }

    

    //Copy all method headings from UML, make sure you have correct method heading, create empty body.  If method returns a value, return something just so it will compile until you are ready to write that method.  


    
  