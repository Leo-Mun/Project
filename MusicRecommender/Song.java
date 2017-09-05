package kr.ac.kookmin.cs.oop.project.model;

/*
 * A class to store the information about each song entry
 * It should contain all the fields that are registered in the song list file
 * You have to declare fields and way to parse comma separated string to the Song class 
 */
public class Song { 
	
	private String studentId;
	private String songTitle;
	private String Artist;
	private String Genre;
	private String theYearOfIssue;
	private String AlbumTitle;
	private String Composer;
	private String Producer;
	private String Country;
	private String Language;
	private String length;
	
	
		
    public Song(String entry) { 
        String[] fieldValues = entry.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        
       
        
        this.studentId = fieldValues[0];
        this.songTitle = fieldValues[1];
        this.Artist = fieldValues[2];
        this.Genre = fieldValues[3];
        this.theYearOfIssue = fieldValues[4];
        this.AlbumTitle = fieldValues[5];
        this.Composer = fieldValues[6];
        this.Producer = fieldValues[7];
        this.Country = fieldValues[8];
        this.Language = fieldValues[9];
        this.length = fieldValues[10];
        
        
    }
    
    /*
     * You have to write your custom toString function to print Song information
     */
  public String getGenre() {
	  return this.Genre;
  }
  
  public String getCountry() {
	  return this.Country;
  }
  
  public String getStudentId() {
	  return this.studentId;
  }
  
  
    @Override
    public String toString() {  
    	
    	return  String.join(",", this.Artist, this.songTitle, this.Genre, this.length, this.Country);
    }
}
