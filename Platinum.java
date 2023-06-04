public class Platinum extends NoTier{



    /**Empty platinum constructor used by derived classes*/
    Platinum(){
    }

    /**Parameterized constructor*/
    Platinum(int m,int c,int t){
        miles=m;
        cancelFlights=c;
        totalFlights=t;
   }



    /**Method to update reward tier from platinum to platinum pro,executive platinum based on cancelled flights*/
    @Override
    public Tier updateRewardTier(boolean isEof,char complain){

        if(cancelFlights>=100){
           return new ExecutivePlatinum(miles,cancelFlights,totalFlights);
        }
        else{
            if(complain=='N'&&isEof){
                return new PlatinumPro(miles,cancelFlights,totalFlights);
            }
            return this;
        }

    }

    /**Overriding toString to return tier name*/
    @Override
    public String toString(){
        return "Platinum";
    }
}
