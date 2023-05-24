/*
 * Tugsbileg Khaliunbat
 * CIS1068 001
 * Lab 05
 */
package cis1068lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class CIS1068Lab05 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("example.txt"));
        evenNumbers(console);
        inputStats(console);
        storyGame(console);
        
    }
    
    
   
    
    public static void inputStats(Scanner sc) throws FileNotFoundException {
        //System.out.println("I'm going to process: "+line);
        String longestLine = "";
        int i = 1;
        int longest = -1;
        while(sc.hasNext()){
            String line = sc.nextLine();    
            Scanner sc2 = new Scanner(line);
            int token= 0;
            int max = -1;
            while(sc2.hasNext()) {
                String word = sc2.next();
                //System.out.println("'" + word + "':"+word.length()+"\t");
                token++;
                if(word.length()>max)
                    max=word.length();
            }
            if(token>=longest){
                longestLine = line;
                longest = token;
            }
            System.out.print("Line "+i+" Tokens: "+token);
            i++;
            System.out.println(" (Longest=" + max +")");
        }
        System.out.println("Longest line: "+longestLine);
    }
    
    
    
    public static void evenNumbers(Scanner sc) throws FileNotFoundException{
        
        double sum = 0;
        double evens = 0;
        double count = 0;
        while(sc.hasNext()){
            int num = sc.nextInt();
            //System.out.println(num);
            count+=1;
            sum+=num;
            if(num%2==0){
                evens+=1;
            }
        }
        System.out.printf("sum = %.0f \n", sum);
        System.out.printf("count = %.0f \n",count);
        System.out.printf("evens = %.0f ",evens);
        System.out.printf("(%.2f",(evens/count*100));
        System.out.println("%)");
    }
    
   
    
    
    public static void storyGame(Scanner sc) throws FileNotFoundException{
        String file = "";
        String story = file;
        while(sc.hasNext()){
            file += sc.next()+" ";
        }
        for(int i =0; i<file.length();i++){
            if(file.charAt(i)=='<'){
                for(int j = i; j<file.length()-1;j++){
                    if(file.charAt(j)=='>'){
                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("Enter a(n) "+ file.substring(i+1, j)+": ");
                        String userInput = sc2.next();
                        file = file.replaceFirst(file.substring(i,j+1), userInput);
                        break;
                    }
                }
            }
        }
        System.out.println("");
        System.out.println(file);
    }
    
    
    
}
