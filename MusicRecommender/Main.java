package kr.ac.kookmin.cs.oop.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;
import kr.ac.kookmin.cs.oop.project.recommender.impl.RandomRecommender;

public class Main {

    private final String[] studentIds;

    private Recommender musicRecommender;

    public Main(String filePath) {
        studentIds = extractStudentsIds(filePath);
        musicRecommender = new RandomRecommender(filePath); // 다형성
    }

    /*
     * From the input file path that contains information about the song
     * preference list, it should extract unique students IDs and it should
     * return it as a String array. There are 36 unique student IDs and you
     * should return only the unique IDs.
     */
    
    // Sorting 을 한다면 이 알고리즘을 써도 됨
    // input이 어떻게 들어올 지 가정하고 알고리즘을 짜면 안됨
    
    
    private static String[] extractStudentsIds(String filePath) {
        File inputFile = new File(filePath);
        String[] studentIds = new String[37];
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
        	
        	int stIdChk = 0;
        	int fieldChk = 0;
            
        	for (String line; (line = br.readLine()) != null;) {
                
        		String[] fieldValues = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                // You have to extract the kmu-id that is the first element in
                // the fieldValues and store unique ones to studentIds String
                // array
        		
        		// 중복검사는 hashtable 사용 for문 두 개를 사용하진 않음
                
        		while (line != null){
                	
                	if (studentIds[stIdChk] == null){
                		studentIds[stIdChk] = fieldValues[fieldChk];
                		break;
                	}
                	
                	else if (studentIds[stIdChk] != null){
                		if (studentIds[stIdChk].equals(fieldValues[fieldChk])){
                			break;
                		}
                		else if (studentIds[stIdChk].equals(fieldValues[fieldChk]) == false){
                			++stIdChk;
                			studentIds[stIdChk] = fieldValues[fieldChk];
                			break;
                			
                		}
                	}
                }
                
                
                
                
            }
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return studentIds;
    }

    /*
     * A function to print out basic statistics about song and students
     */
    public void printStatistics() {
        musicRecommender.printSongStatistics();
        musicRecommender.printStudentStatistics();
    }

    /*
     * A function that calls recommend function that is implemented in different
     * classes
     */
    public void recommend() {
        for (String student : studentIds) {
            Song[] recommendedSongs = musicRecommender.recommend(student);
            for (Song songs : recommendedSongs) {
            	System.out.println(songs);
            }
            
        }
    }
    
    public static void main(String[] args) {
        Main runner = new Main("resource/oop-2016-song-project.csv");
        runner.printStatistics();
        runner.recommend();
    }
}
