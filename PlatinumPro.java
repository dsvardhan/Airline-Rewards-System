public class PlatinumPro extends Platinum{


    /**Parameterized constructor*/
    PlatinumPro(int m,int c,int t){
        miles=m;
        cancelFlights=c;
        totalFlights=t;
    };

    /**Stores multiplier*/
    private  int mul=2;

    /**Manipulates number of miles using the multiplier*/
    @Override
    public  int getMiles(){
        return super.getMiles()*mul;
    }

    /**Overriding toString to return tier name*/
    @Override
    public String toString(){
        return "Platinum Pro";
    }
}
