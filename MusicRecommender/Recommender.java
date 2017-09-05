package kr.ac.kookmin.cs.oop.project.recommender;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kr.ac.kookmin.cs.oop.project.model.Song;


public abstract class Recommender {

    protected final Song[] songs;

    public abstract Song[] recommend(String studentId);

    public Recommender(String filePath) { // Constructor
        this.songs = buildSongObjects(filePath);
    }

    /*
     * Read the input file and fill the Song[] array
     */
    private Song[] buildSongObjects(String filePath) {
        Song[] songs = new Song[376];
        File inputFile = new File(filePath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            String line;
            for (int i = 0; (line = br.readLine()) != null; ++i) {
            	Song song = new Song(line);
            	// System.out.println(song); //toString 과 연관있음
                // You have to create Song object using fieldValues and store
                // the Song object to songs array
                
            	songs[i] = song;
            	
            	
            	
                
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return songs;
    }

    /*
     * A function to print statistics about Song Title, Singer, Genre, ... You
     * have to implement it
     */
    public void printSongStatistics() {
    	int Ballad = 0;
    	int hiphop = 0;
    	int rock = 0;
    	int Korean = 0;
    	int foreign = 0;
    	
    	for (int songChk = 0; songChk < songs.length; ++songChk) {
    		if (this.songs[songChk].getGenre().equals("발라드") || this.songs[songChk].getGenre().equals("Ballad")) {
    			++Ballad;
    		}

    		else if (this.songs[songChk].getGenre().equals("힙합") || this.songs[songChk].getGenre().equals("hip-hop")) {
    			++hiphop;
    		}
    		
    		else if (this.songs[songChk].getGenre().equals("Rock") || this.songs[songChk].getGenre().equals("락")) {
    			++rock;
    		}
    		
    		else if (this.songs[songChk].getCountry().equals("대한민국")) {
    			++Korean;
    		}
    		
    		else if (this.songs[songChk].getCountry().equals("대한민국") == false) {
    			++foreign;
    		}
    	}
    	System.out.println("------------------------------------");
    	System.out.println("발라드 곡 : " + Ballad + "곡 입니다.");
    	System.out.println("힙합 곡 : " + hiphop + "곡 입니다.");
    	System.out.println("락 곡 : " + rock + "곡 입니다.");
    	System.out.println("국내 곡 : " + Korean + "곡 입니다.");
    	System.out.println("외국 곡 : " + foreign + "곡 입니다.");
    	System.out.println("------------------------------------");
    }
    
    /*
     * A function to print basic statistics for each student You have to
     * implement it
     */
    
    public void printStudentStatistics() {
    	
    	int balladLover = 0;
    	int rockLover = 0;
    	int hiphopLover = 0;
    	int popLover = 0;
    	String balladLoveStudents[] = new String[50];
    	String rockLoveStudents[] = new String[50];
    	String hiphopLoveStudents[] = new String[50];
    	String popLoveStudents[] = new String[50];
    	
    	for (int songChk = 0; songChk < songs.length; ++songChk) {
    		if (songs[songChk].getGenre().equals("발라드") || songs[songChk].getGenre().equals("Ballad")) {
    			int chk = 0;
    			for (String id : balladLoveStudents) {
    				if (songs[songChk].getStudentId().equals(id) == false) {
    					balladLoveStudents[chk] = songs[songChk].getStudentId();
    					++chk;
    					++balladLover;
    					break;
    				} else {
    					break;
    				}
    			}
    		}
    	}
    	
    	for (int songChk = 0; songChk < songs.length; ++songChk) {
    		if (songs[songChk].getGenre().equals("Rock") || songs[songChk].getGenre().equals("락")) {
    			int chk = 0;
    			for (String id : rockLoveStudents) {
    				if (songs[songChk].getStudentId().equals(id) == false) {
    					rockLoveStudents[chk] = songs[songChk].getStudentId();
    					++chk;
    					++rockLover;
    					break;
    				} else {
    					break;
    				}
    			}
    		}
    	
    	}
    	
    	for (int songChk = 0; songChk < songs.length; ++songChk) {
    		if (songs[songChk].getGenre().equals("힙합") || songs[songChk].getGenre().equals("hip-hop")) {
    			int chk = 0;
    			for (String id : hiphopLoveStudents) {
    				if (songs[songChk].getStudentId().equals(id) == false) {
    					hiphopLoveStudents[chk] = songs[songChk].getStudentId();
    					++chk;
    					++hiphopLover;
    					break;
    				} else {
    					break;
    				}
    			}
    		}
    	
    	}
    	
    	for (int songChk = 0; songChk < songs.length; ++songChk) {
    		if (songs[songChk].getCountry().equals("대한민국") == false) {
    			int chk = 0;
    			for (String id : popLoveStudents) {
    				if (songs[songChk].getStudentId().equals(id) == false) {
    					popLoveStudents[chk] = songs[songChk].getStudentId();
    					++chk;
    					++popLover;
    					break;
    				} else {
    					break;
    				}
    			}
    		}
    	
    	}
    	
    	System.out.println("발라드를 좋아하는 학생 수 : " + balladLover + "명 입니다.");
    	System.out.println("락을 좋아하는 학생 수 : " + rockLover + "명 입니다.");
    	System.out.println("힙합을 좋아하는 학생 수 : " + hiphopLover + "명 입니다.");
    	System.out.println("팝을 좋아하는 학생 수 : " + popLover + "명 입니다.");
    	System.out.println("------------------------------------");
    }
}
