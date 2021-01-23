package net.datastructures;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CourseParser {
    public HashMap<String, Course> parseFile(String fileName) throws FileNotFoundException {
        HashMap<String,Course> courseGraph = new HashMap<String,Course>();
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(";");
        while(sc.hasNext()){
            String[] lines = sc.next().split("\n");
            
        }
        return null;
    }
}
