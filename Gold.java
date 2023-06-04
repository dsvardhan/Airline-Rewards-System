public class Gold extends NoTier{

    /**Parameterized constructor*/
    Gold(int m,int c,int t){
        miles=m;
        cancelFlights=c;
        totalFlights=t;
    };



    /**Overriding update method. Used to update from gold to platinum*/
    @Override
    public Tier updateRewardTier(boolean isEof,char complain){

      if(cancelFlights>=50&&cancelFlights<100) {
          return  new Platinum(miles,cancelFlights,totalFlights);
      }

      return this;
    }

    /**Overriding toString to return tier name*/
    @Override
    public String toString(){
        return "Gold";
    }

}
