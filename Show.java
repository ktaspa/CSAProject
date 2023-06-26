/**
* AP CSA 1
* Final Project
* TV Show Manager that allows the user to keep track of their shows
* @author KapilTaspa
* 05/18/23
*/

/* Show class is the object class that creates a Show object with a name, platform, length, rating, year, type, current episode, and if a favorite or not. There are accessors and mutators for each of the instance fields of the show in this class.*/
public class Show
  {
    //INSTANCE FIELDS
    private String name;
    private String platform;
    private int length;
    private int rating;
    private int year;
    private String type;
    private int currentep;
    private boolean isfavorite;
    
    //CONSTRUCTORS
    /** 
    * Constructs default show with no name, no platform, length of 0, rating of 0, year of 0, no type, current episode of 0, and not a favorite
    */
    public Show() {
      name = null;
      platform = null;
      length = 0;
      rating = 0;
      year = 0;
      type = null;
      currentep = 0;
      isfavorite = false;
    }

    /** 
    * Constructs show with 8 given parameters
    * @param name the name of the show
    * @param platform the platform in which the show is watched
    * @param length the amount of total episodes in the show
    * @param rating the rating of the show out of 5
    * @param year the year that the show was released
    * @param type the type of show
    * @param currentep the current episode the user is on
    * @param isfavorite is the show a favorite or not by the user
    */
    public Show(String name, String platform, int length, int rating, int year, String type, int currentep, boolean isfavorite) {
      this.name = name;
      this.platform = platform;
      this.length = length;
      this.rating = rating;
      this.year = year;
      this.type = type;
      this.currentep = currentep;
      this.isfavorite = isfavorite;
    }

  //ACCESSORS (including equals, compareTo and toString)
  /**
   * Gets the name of the show
   * @return the name of the show
   */
    public String getName() {
      return name;
    }

  /**
   * Gets the platform of the show
   * @return the platform of the show
   */
    public String getPlatform() {
      return platform;
    }

  /**
   * Gets the length of the show
   * @return the length of the show
   */
    public int getLength() {
      return length;
    }

  /**
   * Gets the rating of the show
   * @return the rating of the show
   */
    public int getRating() {
       return rating;
    }

  /**
   * Gets the year of the show
   * @return the year of the show
   */
    public int getYear() {
      return year;
    }

  /**
   * Gets the type of the show
   * @return the type of the show
   */
    public String getType() {
      return type;
    }

  /**
   * Gets the current episode of the show
   * @return the current episode of the show
   */
    public int getCurrent() {
      return currentep;
    }

  /**
   * Gets if the show is a favorite or not
   * @return true or false base on favorite
   */
    public boolean getFavorite() {
      return isfavorite;
    }

  /** 
	 * Checks if the name of the parameter is equal to name of Show object
   * @param o Object that is being checked
   * @return true or false if they are equal or not
	 */
    public boolean equals(Object o) {
      Show other = (Show) o;
      return this.name == other.name && this.name.equals(other.name);
    }

  /** 
	 * Compares the name of parameter to name of Show object
   * @param o Object that is being compared to
   * @return 0 if arg string is equal to this string; a value less thn 0 if item is less; value greater than 0 if item is greater
	 */
    public int compareTo(Object o) {
      Show other = (Show) o;
      return this.name.compareTo(other.name);
    }
  
    //MUTATORS for each instance field even if not using
    /** 
    * Changes name to given name
    * @param newName new name to replace old name
    */
    public void newName(String newName) {
      name = newName;
    }

    /** 
    * Changes platform to given platform
    * @param newPlatform new platform to replace old platform
    */
    public void newPlatform(String newPlatform) {
      platform = newPlatform;
    }

    /** 
    * Changes length of show to given length
    * @param newLength new length to replace old length
    */
    public void newLength(int newLength) {
      length = newLength;
    }

    /** 
    * Changes rating of show out of 5 to given rating
    * @param newRating new rating to replace old rating
    */
    public void newRating(int newRating) {
      rating = newRating;
    }

    /** 
    * Changes year the TV show was made to given year
    * @param newYear new year to replace old year
    */
    public void newYear(int newYear) {
      year = newYear;
    }

    /** 
    * Changes type of show to given type
    * @param newType new type to replace old type
    */
    public void newType(String newType) {
      type = newType;
    }

    /** 
    * Changes current episode to new episode
    * @param newEpisode to replace current episode
    */
    public void newEpisode(int newEpisode) {
      currentep = newEpisode;
    }
    
    /** changes isfavorite to either true or false
    * @param newFav to replace current favorite
    */
    public void newFavorite(boolean newFav) {
      isfavorite = newFav;
    }

    
  }