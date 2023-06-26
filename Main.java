/**
* AP CSA 1
* Final Project
* TV Show Manager that allows the user to keep track of their shows
* @author KapilTaspa
* 05/18/23
*/
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/*Main class is the driver class that displays the JOptionPane and controls the menus displayed. It is the frontened code. Reading and saving to a file are also in the main class*/
public class Main 
{
/**
	* main Displays the user interface menu and calls the dispatch method until
	* the user enters choice 7 to end their shopping session.
	* @param args not used
	*/
  public static void main(String[] args) 
  {
    ShowList showList = new ShowList();

    //## creates a loop to display the main menu
       boolean done = false;
    
       while(!done)
       {
      	String menu = "1 - Load all Shows" + "\n" + "2 - Show all " + "\n" + "3 - Edit Shows " + "\n"+"4- Favorites"+"\n"+"5- Find Shows"+"\n"+"6- Save to Files" + "\n" + "7- QUIT";
      	String inputValue = JOptionPane.showInputDialog(menu);
      		 int n = Integer.parseInt(inputValue);
	       switch(n)
	       {
	           case 1: loadFile(); //Read data from file
	           		   break;
	           case 2:
                  JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %7s %10s %10s %15s %n", "Title", "      Platform", "   Length", "My Ep.", "Rating", "Year", "Type")+ showList.toString());
                  //ShowList.showAll(); 
                  break;
	           case 3: 
             boolean check3 = false;
             while (!check3) {
             String menu3 = "1 - Add Show" + "\n" + "2 - Delete Show " + "\n" + "3 - Update Rating" + "\n"+"4- Increment Episode"+"\n"+"5- Add Favorite"+ "\n"+"6- Remove Favorite"+ "\n"+"7- QUIT";
      	     String inputValue3 = JOptionPane.showInputDialog(menu3);
             
      		  int t = Integer.parseInt(inputValue3);
	       switch(t) {
           case 1:
             
          	  JTextField name = new JTextField();
          		JTextField platform = new JTextField();
          		JTextField length = new JTextField();
          		JTextField rating = new JTextField();
          		JTextField year = new JTextField();
              JTextField type = new JTextField();
          		JTextField currentep = new JTextField();
          		//JTextField favorite = new JTextField();
          		
          	Object[] message = 
              {
              "Title:", name,      
              "Platform:", platform,
              "Total Episodes:", length,
              "Rating out of 5:", rating,
              "Year Made:", year,
              "Type of Show:", type,
              "What episode # are you on?", currentep,
               };
               //name.setText("initialize data such as Henry here");
              
          	int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
          	if (option == JOptionPane.OK_OPTION)
          	{   //Read user input data
              String namenew = name.getText();
              String platformnew = platform.getText();
              int lengthnew = Integer.parseInt(length.getText());
              int ratingnew = Integer.parseInt(rating.getText());
              int yearnew = Integer.parseInt(year.getText());
              String typenew = type.getText();
              int episodenew = Integer.parseInt(currentep.getText());
              ShowList.addShow(new Show(namenew, platformnew, lengthnew, ratingnew, yearnew, typenew, episodenew, false));
            } 
             break;
         
           case 2:
              String titledelete = JOptionPane.showInputDialog("Title of Show to Delete:");
      		    String title = titledelete;
              showList.removeShowByTitle(title);
             break;
             
           case 3:
              String titleupdaterating = JOptionPane.showInputDialog("Title of Show to Update Rating:");
      		    String updatetitle = titleupdaterating;
              
             
              Object[] possibilities = {1, 2, 3, 4, 5};
		int ratingout = (Integer)JOptionPane.showInputDialog(
                    null,
                    "New Rating",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,						// icon if you have one
                    possibilities,
                    5);
              showList.updateRating(updatetitle, ratingout);

       
    
             break;
           case 4:
              String watchshow = JOptionPane.showInputDialog("Title of Show to Increment:");
      		    String incrementshow = watchshow;
              showList.incrementEpisode(incrementshow);
             break;
           case 5:
              String addfavorite = JOptionPane.showInputDialog("Title of Show to Favorite:");
      		    String favoriteshow = addfavorite;
              showList.addFavorite(favoriteshow);

             
             break;
           case 6:
             String removefavorite = JOptionPane.showInputDialog("Title of Show to Favorite:");
      		   String removefavoriteshow = removefavorite;
             showList.removeFavorite(removefavoriteshow);
             break;
           case 7:
             check3 = true;
             break;
         }
               break;
         }
	           		   break;
	           case 4:
                  JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %10s %n", "   Title", "         Platform", "     Length", "  My Ep.")+showList.favoriteToString());
             
	           	  break;
           case 5:
            boolean check5 = true;
             while(check5){
                String menu5 = "1 - Search Shows" + "\n" + "2 - Currently Watching" + "\n" + "3 - Already Watched" + "\n"+"4- Sort By Rating"+ "\n"+"5- Episodes Left" + "\n"+"6- QUIT";
      	     String inputValue5 = JOptionPane.showInputDialog(menu5);
      		  int t5 = Integer.parseInt(inputValue5);
            
	       switch(t5) {
           case 1:
             String searchByTitle = JOptionPane.showInputDialog("Title to Search");
             String titlesearch = searchByTitle;
             int index = showList.findShows(titlesearch);
             if(showList.findShows(titlesearch)>0) {
                JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %7s %10s %10s %15s %n", "Title", "      Platform", "   Length", "My Ep.", "Rating", "Year", "Type") + showList.toStringIndex(index));}
             else if(showList.findShows(titlesearch)<0) {
               JOptionPane.showMessageDialog(null, titlesearch + " is NOT in your shows");}
               
             break;
           case 2:
             JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %7s %10s %10s %15s %n", "Title", "      Platform", "   Length", "My Ep.", "Rating", "Year", "Type")+ showList.findCurrent());
             break;
           case 3: 
             JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %7s %10s %10s %15s %n", "Title", "      Platform", "   Length", "My Ep.", "Rating", "Year", "Type")+ showList.findShowsWatched());
             break;
           case 4:
              showList.sortByRating();
             JOptionPane.showMessageDialog(null, String.format("%-25s %10s %10s %7s %10s %10s %15s %n", "Title", "      Platform", "   Length", "My Ep.", "Rating", "Year", "Type")+ showList.toString());
             break;
           case 5:
             String episodesLeft = JOptionPane.showInputDialog("Title to get episodes left");
             String title = episodesLeft;
             JOptionPane.showMessageDialog(null, "You have " + showList.episodesLeft(title) +" episodes left");
           case 6:
             check3 = true;
             break;
         }
            break;
             } 
      
           case 6: 
              //String fileName = "input.dat";
              try {
                PrintWriter output = new PrintWriter("input.dat");
                output.println(showList.saveToFile());
                output.close();
                JOptionPane.showMessageDialog(null, "Data Saved!");
                
              }
              catch(IOException exception) {
                JOptionPane.showMessageDialog(null, "Information could not be saved" + exception);
              }
             break;
           case 7:
             done = true;
             break;
	       }
       }
  }
  public static void saveFile() {
    
  }
  /** loads the data from the file into the arraylist */
  public static void loadFile()
  {
    //Declare your Scanner Object for input data/do not instantiate until inside try block
    Scanner data;
    //Create try catch block to catch error
    try
      {
        //instantiate the Scanner object
        data = new Scanner(new File("input.dat"));
        // loop until no more data
        while(data.hasNext()) {
          String showName = data.nextLine();
          String showPlatform = data.nextLine();
          int showLength = data.nextInt();
          data.nextLine();
          int showRating = data.nextInt();
          data.nextLine();
          int showYear = data.nextInt();
          data.nextLine();
          String showType = data.nextLine();
          int showCurrEp = data.nextInt();
          data.nextLine();
          boolean showFavorite = data.nextBoolean();
          data.nextLine();
          ShowList.addShow(new Show(showName, showPlatform, showLength, showRating, showYear, showType, showCurrEp, showFavorite));
        }   
      }
      catch(IOException e) 
      {
        // print messagae and include the variable e to tell what happened
        System.out.println("input read failed" + e);
      }
  }
}