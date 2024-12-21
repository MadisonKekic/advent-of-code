import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class redNosedReports {
    /**
     * I need to scan the file
     * Each line is a report
     * Each number in each line is a level
     * ArrayList<ArrayList<Integer>>
     * 
     * Compare 0,1 1,2 2,3 3,4 - Check difference
     * && must be all decreasing or increasing
     * 
     */

     public void createReports(String path, ArrayList<ArrayList<Integer>> reports){
        try{
            Scanner scan = new Scanner(new File(path), "UTF-8");
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String [] split = line.split(" ");
                
                ArrayList<Integer> newReport = new ArrayList<Integer>();
                for (String string:split){
                   newReport.add(Integer.parseInt(string));
                }
                reports.add(newReport);
            }
            scan.close();


        }
        catch (FileNotFoundException e){
            System.out.println("Problem Opening File");
            System.exit(1);
        }

     }

     private boolean isIncreasing(ArrayList<Integer> report){
        for (int i = 0; i<report.size()-1; i++){
            if (report.get(i)>report.get(i+1)){
                return false;
            }
        }
        return true;
     }

     private boolean isDecreasing(ArrayList<Integer> report){
        for (int i = 0; i<report.size()-1; i++){
            if(report.get(i)<report.get(i+1)){
                return false;
            }
        }
        return true;
     }

     private boolean isStable(ArrayList<Integer> report){
        for (int i = 0; i<report.size()-1; i++){
            int difference = Math.abs(report.get(i) - report.get(i+1));
            if (difference<1 || difference>3){
                return false;
            }
        }
        return true;
     }

     public int isSafeCount(ArrayList<ArrayList<Integer>> reports){
        int safeCount = 0;
        for(ArrayList<Integer> report : reports){
            if ((isDecreasing(report)|| isIncreasing(report)) && isStable(report)){
                safeCount +=1;
            }
        }
        return safeCount;
    } 

    public static void main (String[] args){
        if (args.length == 0){
            System.out.println("User Input: Missing");
            System.exit(1);
        }
        else if (args.length == 1){
            String path = args[0].toString();
            redNosedReports redNose = new redNosedReports();
            ArrayList<ArrayList<Integer>> reports = new ArrayList<ArrayList<Integer>>();
            redNose.createReports(path, reports);

            int count = redNose.isSafeCount(reports);
            System.out.println(reports.size());
            System.out.println("The number of safe reports is: " + count);
        }
        else{
            System.out.println("Please enter the name of the file as one command line argument");
            System.exit(1);
        }
    }
}  
