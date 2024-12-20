import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Completed: December 20, 2024
 * Day One of 2024's Advent of Code Challenge
 * 
 * Reads in a txt file of two lists of equal length, 
 * sorts the two lists, and finds the sum of the absolute value
 * of each difference between the numbered pairs
 * 
 * @author Madison Kekic
 * 
 */

 public class historianHysteria{
    /**
     * Reads in data from a single command line argument, path
     * Adds integers from the file named path to the two passed in lists, 
     * leftList and rightList and sorts the two lists
     * 
     * @param path The name of the file you want to read data from
     * @param leftList The list that all numbers on the left hand side of the file will be added to 
     * @param rightList The list that all numbers on the right hand side of the file will be added to
     */
    public void createLists (String path, ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        try{
            /**Creates a new scanner */
            Scanner scan = new Scanner(new File(path), "UTF-8");
            while(scan.hasNextLine()){
                /**Splits line into two columns */
                String line = scan.nextLine();
                String[] split = line.split("   ");

                int leftNum = Integer.parseInt(split[0]);
                int rightNum = Integer.parseInt(split[1]);
                
                /**Adds appropriate integer to each list */
                leftList.add(leftNum);
                rightList.add(rightNum);
            }
            scan.close();

            /**Sorts each list */
            bubbleSort(leftList);
            bubbleSort(rightList);
        }
        catch (FileNotFoundException e){
            System.out.println("Problem opening file");
            System.exit(1);

        }
    }

    /**
     * Private helper method that performs bubble sort on an array list
     * 
     * @param list An array list of integers
     */
    private void bubbleSort(ArrayList<Integer> list){
        for (int i=0; i<list.size()-1; i++){
            for(int j=0; j<list.size()-1; j++){
                if(list.get(j)>list.get(j+1)){
                    int largerNumber = list.get(j);
                    int smallerNumber = list.get(j+1);
                    list.set(j, smallerNumber);
                    list.set(j+1, largerNumber);
                }

                }
            }

        }
    /**
     * Finds the sum of each numbered pair of two array lists
     * 
     * @param leftList The first list- offers the first number in the numbered pair 
     * @param rightList The second list- offers the second number, which will be subtracted from the first number
     * @return sum The sum of the absolute value of each difference of numbered pairs
     * 
     */
    public int findSum(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        int sum = 0;
        for (int i = 0; i<leftList.size(); i++){
            int leftNum = leftList.get(i);
            int rightNum = rightList.get(i);
            int difference = Math.abs(leftNum-rightNum);
            sum+=difference;
    }
        return sum;
    }

    /**Adds and sorts integers from a file identified by a command line argument, path; Calls findSum on the resulting array lists*/
    public static void main (String args[]){
        if (args.length==0){
            System.out.println("User Input: Missing");
            System.exit(1);
        }
        else if (args.length==1){
            /**Parses argument and creates historianHysteria object */
            String path = args[0].toString();
            historianHysteria hysteria = new historianHysteria();
            
            /**Creates two new array lists*/
            ArrayList<Integer> leftList= new ArrayList<Integer>();
            ArrayList<Integer> rightList= new ArrayList<Integer>();

            /**Adds integers to each array list*/
            hysteria.createLists(path,leftList, rightList);
            
            /**Finds and prints the sum of the difference of each ordered pair*/
            int finalSum = hysteria.findSum(leftList, rightList);
            System.out.println("The final sum is: " + finalSum);
        }
        else{
            System.out.println("Input should be entered as one command line argument indicating the name of the file");
            System.exit(1);
        }
           
        }
    }
 