package kr.ac.kookmin.cs.oop.project.recommender.impl;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;

/*
 * A song recommender that simply relies on random algorithm.
 * Recommend whatever you want to
 */
public class RandomRecommender extends Recommender {

    public RandomRecommender(String filePath) {
        super(filePath);
    }

    /*
     * Write your own recommender module. You can remove the for loop and write
     * your custom logic
     */
    @Override
    public Song[] recommend(String studentId) {
    	Song recommendSong[] = new Song[10];

    	int count = 0;
    	
    	while (count < 10) {
    		int random = (int) (Math.random() * songs.length);
    		if (songs[random].getStudentId().equals(studentId)) {
    			continue;
    		} else {
    			recommendSong[count] = songs[random];
    			++count;
    		}
    	}
    	System.out.println("==============================");
        return recommendSong;
    }

}
