  

/**
 * Holds the data for a single month's output of milkWeights. 
 * @author doran
 *
 */
public class FarmNode {

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
      dailyMilkWeights[day] = milkWeight;
      milkWeightTotal = milkWeightTotal + milkWeight;
    }
    
    /**
     * Replaces dailymilkWeight for a certain day
     * @param day
     * @param milkWeight
     */
    public void replaceDailyWeight(int milkWeight, int day) {
      milkWeightTotal = milkWeightTotal - dailyMilkWeights[day];
      dailyMilkWeights[day] = milkWeight;
      milkWeightTotal = milkWeightTotal + milkWeight;
    }
}

