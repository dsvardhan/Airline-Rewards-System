
public class Passenger implements Comparable<Passenger>{

    /**Used to store passenger reward tier*/
    private Tier currTier;

    /**Used to store passenger id*/
    private int id;

    /**Used to store if end of file or not*/
    private boolean isEof;

    /**Used to store char read in from the file*/
    private char cancel,complain;

    /**Default passenger constructor*/
    public Passenger(){
        currTier=new NoTier();
        id=-1;
        isEof=false;
        complain='N';
    }

    /**Parameter passenger constructor*/
    public Passenger(int i,char com,char canc){
        currTier=new NoTier();
        id=i;
        isEof=false;

        complain=com;

        if(canc=='Y'){
            addFlight(true);
        }
        else addFlight(false);
    }

    /**Overloaded constructor for not cancelled flights*/
    public Passenger(int i,char canc){
        currTier=new NoTier();
        id=i;
        isEof=false;

        if(canc=='Y'){
            addFlight(true);
        }
        else addFlight(false);
    }

    /**Getter for miles*/
    public int getMiles(){
        return currTier.getMiles();
    }

    /**Getter for cancelled flights*/
    public int getCancelledFlights(){
        return currTier.getCancelledFlights();
    }

    /**Getter for total number of flights*/
    public int getFlights(){return currTier.getFlights();}

    /**Setter for cancel*/
    public void setCancel(char b){
        cancel=b;
   }

    /**setter for complain character*/
    public void setComplain(char d){
        complain=d;
    }

    /**setter for EOF field*/
    public void setEof(boolean c){
        isEof=c;
    }

    /**Getter for multiplier. Returns true or false*/
    public boolean hasMultiplier(){
        if(complain=='N'&&isEof==true){
            return true;
        }else{
            return false;
        }

    }

    /**Setter for flight count*/
    public void addFlight(boolean isCancelled){
        currTier.addFlight(isCancelled);

    }

    /**Returns passenger reward tier name*/
    public String getTier(){
        return currTier.toString();
    }
    /**Method to update reward tier*/
    public void updateRewardTier(){
        currTier=currTier.updateRewardTier(isEof,complain);
    }

    /**Getter for id*/
    public int getId(){
       return id;
    }

    /**Method to compare passenger ids*/
    @Override
    public int compareTo(Passenger o) {
        if(this.id<o.id){
            return -1;
        }else if(this.id==o.id){
            return 0;
        }else{
            return 1;
        }
    }
}
