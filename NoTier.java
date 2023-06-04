public class NoTier implements Tier {

    /**Fields to store passenger miles,cancelled flights and total flights*/
    protected int miles,cancelFlights,totalFlights;



    /**Empty object constructor*/
    public NoTier(){};


    /**Returns reward tier name*/
    public String toString(){
       return "NoTier";
    }

    /**Returns miles earned by passenger*/
    public int getMiles(){
        return miles;
    };

    /**Returns number of flights cancelled*/
    public int getCancelledFlights(){
        return cancelFlights;
    };

    /**Returns total number of flights*/
    public int getFlights(){
        return totalFlights;
    }

    /**Setter for miles*/
    public void setMiles(){
        miles=cancelFlights*1000;
    }

    /**Setter for cancelled flights, total flights*/
    public void addFlight(boolean isCancelled){
        if(isCancelled) {
            cancelFlights++;
        }
        totalFlights++;
        setMiles();
    }


    /**Method to update tier to gold if cancel flights==25*/
    public Tier updateRewardTier(boolean isEof,char complain){

        if(cancelFlights>=25&&cancelFlights<50){
         return new Gold(miles,cancelFlights,totalFlights);
        }
        else{
            return this;
        }

    }

   }
