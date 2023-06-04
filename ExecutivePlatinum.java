public class ExecutivePlatinum extends NoTier{

    /**Empty constructor used by derived classes*/
    ExecutivePlatinum(){
    };

    /**Parameterized constructor*/
    ExecutivePlatinum(int m,int c,int t){
        miles=m;
        cancelFlights=c;
        totalFlights=t;
    };


    /**Update method to update from executive platinum to super executive platinum*/
    @Override
    public Tier updateRewardTier(boolean isEof,char complain){
        if(isEof&&complain=='N') {
            return new SuperExecutivePlatinum(miles,cancelFlights,totalFlights);
        }

        return this;
    }

    /**Overriding toString to return tier name*/
    @Override
    public String toString(){
        return "Executive Platinum";
    }
}
