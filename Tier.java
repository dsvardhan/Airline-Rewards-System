public interface Tier {

    /**Returns miles earned by a passenger*/
    public int getMiles();

    /**Returns number of flights cancelled*/
    public int getCancelledFlights();

    /**Returns total number of flights*/
    public int getFlights();

    /**Setter for miles*/
    public void setMiles();

    /**Setter for cancelled flights, total flights*/
    public void addFlight(boolean isCancelled);

    /**Updates the passengers reward tier*/
    public Tier updateRewardTier(boolean isEof,char complain);


}
