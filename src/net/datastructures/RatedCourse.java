package net.datastructures;

// class with course ID and its specific rating for a user
public class RatedCourse implements Comparable{
	
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

	public int compareTo(Object obj) {
		
		if(obj.getClass().equals(getClass())) {
			if (((RatedCourse) obj).getRating() > rating) {
				return 1;
			}
	 		else if (((RatedCourse) obj).getRating() < rating) {
	 			return -1;
	 		} else {
	 			return 0;
	 		}
		}
		else
			return -2;

	}

}
