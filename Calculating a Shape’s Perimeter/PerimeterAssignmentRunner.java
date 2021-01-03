import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int NumPoints=0;
        for (Point currPt : s.getPoints()){
           NumPoints=NumPoints+1;
        }
        return NumPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int NumPoints= getNumPoints(s);
        double totalPerim= getPerimeter(s);
        double Avglength= totalPerim/NumPoints;
        return Avglength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double LargestSide = 0;
        Point prevPt=s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double dist= prevPt.distance(currPt);
            prevPt = currPt;
            if (dist>LargestSide){
                LargestSide=dist;
            }
        }
        return LargestSide;
    }

    public double getLargestX(Shape s) {
        double LargestX=0.0;
        for (Point currPt: s.getPoints()){
           double X= currPt.getX();
           if (X>LargestX){
            LargestX=X;
        }
        }
        // Put code here
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double LargestPerim = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);    
           Shape s = new Shape(fr);
           double length = getPerimeter(s);
           if (length>LargestPerim){
              LargestPerim=length;
           
            }

        }
        return LargestPerim;
    }

    public File getFileWithLargestPerimeter() {
        // Put code here
        double LargestPerim = 0;       
        File LargestPerimFile = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);    
           Shape s = new Shape(fr);
           double length = getPerimeter(s);
           if (length>LargestPerim){
              LargestPerim=length;
              LargestPerimFile=f;
           
            }

        }
        return LargestPerimFile;
    }


    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int NumPoints= getNumPoints(s);
        System.out.println("Total NumPoints are ="+ NumPoints);
        double Avglength= getAverageLength(s);
        System.out.println("Average length is ="+ Avglength);
        double LargestSide= getLargestSide(s);
        System.out.println("Largest side is =" + LargestSide);
        double LargestX= getLargestX(s);
        System.out.println("Largest X is =" + LargestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double LargestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter of Multiple Files is="+LargestPerim); 
    }

    public void testFileWithLargestPerimeter(){ 
    // This method creates a triangle that you can use to test your other methods
    
        File LargestPerimFile = getFileWithLargestPerimeter();
        System.out.println("Largest Perimeter of Multiple Files is="+LargestPerimFile);     
}
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
