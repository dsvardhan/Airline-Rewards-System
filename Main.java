import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    /**Binary search method to search for passenger in the arraylist*/
    static int binarySearch(ArrayList<Passenger> arr, int i)
    {
        int l = 0, r = arr.size() - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            /** Check if x is present at mid*/
            if (arr.get(m).getId() == i)
                return m;

            /** If x greater, ignore left half*/
            if (arr.get(m).getId()  < i)
                l = m + 1;

                /**If x is smaller, ignore right half*/
            else
                r = m - 1;
        }

        /** if we reach here, then element was
        not present*/
        return -1;
    }



    /**Method to read in the file*/
    public static void in(ArrayList<Passenger> p)throws IOException{

        FileInputStream fileByteStream = null; /** File input stream*/
        Scanner inFS = null;                   /** Scanner object*/
        int id;                       /**Data value from file*/
        char can;                     /**Data value from file*/
        char com;                     /** Data value from file*/

         /** Try to open file*/
        System.out.println("Opening file numFile.txt.");


        fileByteStream = new FileInputStream("flight-data.txt");
        inFS = new Scanner(fileByteStream);

        while(inFS.hasNext()) {
            /**Initializing variables*/
            id = inFS.nextInt();
            can = inFS.next().charAt(0);
            int t=0;

            if(!p.isEmpty()) {
                Collections.sort(p);
                t = binarySearch(p, id);
            }

            if (t ==-1||p.isEmpty()) {

                if (can == 'Y') {
                        com = inFS.next().charAt(0);
                        Passenger l = new Passenger(id, com,can);
                        p.add(l);
                }
                else {
                        Passenger l = new Passenger(id, can);
                        p.add(l);
                }

            } else {
                      if (can == 'Y') {
                        com = inFS.next().charAt(0);
                        p.get(t).setComplain(com);
                        p.get(t).addFlight(true);
                        p.get(t).updateRewardTier();
                      }
                      else{
                          p.get(t).addFlight(false);
                      }
            }
        }

        for(int j=0;j< p.size();j++){
            p.get(j).setEof(true);
            p.get(j).updateRewardTier();
        }

        fileByteStream.close();

    }
    
    public static void main(String[] args)throws IOException {

        ArrayList<Passenger> personList=new ArrayList<Passenger>();
       try{
           in(personList);
        }catch(Exception excpt){
        System.out.print(excpt.getMessage());
       }

       Collections.sort(personList);

       int i=1;

       while(i>0){
           System.out.println();
           System.out.println("Enter passenger id -1 to quit");

           System.out.println();
        System.out.print("Enter passenger id:");

        /**Create Scanner object*/
        Scanner s = new Scanner(System.in);
        i=s.nextInt();

        if(i<0){
            return;
        }

        int j=binarySearch(personList, i);

        System.out.print("Miles earned:");
        System.out.println(personList.get(j).getMiles());
        System.out.print("Number of flights cancelled:");
        System.out.println(personList.get(j).getCancelledFlights());
        System.out.print("Total number of flights:");
        System.out.println(personList.get(j).getFlights());
        System.out.print("Has Multiplier:");
        if(personList.get(j).getCancelledFlights()>=50){
        System.out.println(personList.get(j).hasMultiplier());}
        else{
            System.out.println("Not eligible");
        }
        System.out.print("Reward Tier:");
        System.out.println(personList.get(j).getTier());
        System.out.println();
       }

    }


    }