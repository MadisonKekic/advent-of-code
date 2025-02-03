import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class mullItOver {
    public void scanMemory(String path){
        try{
            Scanner scan = new Scanner(new File(path), "UTF-8");
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                Scanner charScanner = new Scanner(line);
                String input = new String();
                while (charScanner.hasNext()){
                    String newChar = charScanner.next();
                    input+=newChar;
                }
                for(int i = 0; i < input.length(); i++){
                    if(i+3<input.length() && input.charAt(i)=='m' && input.charAt(i+1)=='u'
                    && input.charAt(i+2)=='l' && input.charAt(i+3)=='('){
                        try{
                            Integer.parseInt(input, i+4);
                        }
                        catch (NumberFormatException e){

                        }
                    }
                }
                System.out.println(input);
                charScanner.close();
            }
            scan.close();

        }
        catch (FileNotFoundException e){
            System.out.println("Problem opening file.");
            System.exit(1);
        }
    }



    }

    public int mul(int x, int y){
        return x*y;
    }

    public static void main (String args[]){
        mullItOver test = new mullItOver();
        test.scanMemory("day3.txt");
    }

