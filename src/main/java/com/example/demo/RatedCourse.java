package net.datastructures;

// class with course ID and its specific rating for a user
public class RatedCourse implements Comparable<RatedCourse>{
	
	private String courseKey;
    private int rating;
    
    public RatedCourse(String courseID, int rating) {
    	courseKey = courseID;
    	this.rating = rating;
    }
 	
 	public int getRating() {
 		return rating;
 	}
 	
 	public String getID() {
 		return courseKey;
 	}

	public int compareTo(RatedCourse c) {
		if (c.getRating() > rating) {
			return 1;
		}
 		else if (c.getRating() < rating) {
 			return -1;
 		} else {
 			return 0;
 		}
	}

}
