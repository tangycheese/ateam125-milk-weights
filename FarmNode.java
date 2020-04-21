  

/**
 * Holds the data for a single month's output of milkWeights. 
 * @author doran
 *
 */
public class FarmNode implements Comparable {

    private final String FARM_ID; // unique farm ID
    private int milkWeightTotal; // total amount of milk produced this month
    private int[] dailyMilkWeights; // holds daily input of farm weights

    /**
     * 
     * @param farmID - unique ID
     * @param daysInMonth - number of days in this month
     */
    public FarmNode(String farmID, int daysInMonth) {
      FARM_ID = farmID;
      dailyMilkWeights = new int[daysInMonth];
    }

    /**
     * 
     * @return the unique farm ID
     */
    public String getFarmID() {
    return FARM_ID;
    }

    /**
     * 
     * @return total milk weight for this month
     */
    public int getTotalWeight() {
    return milkWeightTotal;
    }

    /**
     * 
     * @return dailyMilkWeights - an array of each days milk weights
     */
    public int[] getDailyArray() {
    return dailyMilkWeights;
    }
    
    /**
     * adds a daily weight
     * @param milkWeight
     * @param day
     */
    public void addDailyWeight(int milkWeight, int day) {
      dailyMilkWeights[day-1] = milkWeight;
      milkWeightTotal = milkWeightTotal + milkWeight;
    }
    
    /**
     * Replaces dailymilkWeight for a certain day
     * @param day
     * @param milkWeight
     */
    public void replaceDailyWeight(int milkWeight, int day) {
      milkWeightTotal = milkWeightTotal - dailyMilkWeights[day-1];
      dailyMilkWeights[day-1] = milkWeight;
      milkWeightTotal = milkWeightTotal + milkWeight;
    }

    /**
     * Compares two different farmNodes based on their total milkWeights for 
     * the month. 
     * @param other - a different farmNode
     * @returns negative if this FarmNode's milkWeight is less than other, positive
     * if this FarmNode's milkWeight is greater than other. 
     */
    
    public int compareToWeights(Object other) {
      return this.milkWeightTotal - ((FarmNode) other).getTotalWeight();
    }
    
    
    /**
     * Compares two different farmNodes based on their FarmIDs. 
     * @param the other FarmNode to compare to. 
     * @returns negative if this farmID is lexicographically less than the other farmID,
     * positive if this is greater than the other farmID, and equal if they are the same.
     */
    @Override
    public int compareTo(Object other) {
      return this.FARM_ID.compareTo(((FarmNode) other).getFarmID());
    }
}

