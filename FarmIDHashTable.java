import java.util.HashMap;

/**
 * 
 * @author Doran Redlich
 *
 */
public class FarmIDHashTable {

  private int size; // # of farm IDs
//  private int initialCapacity; //current capacity of HashTable
//  private double loadFactor; 
  private final int DAYS_IN_MONTH; // days in this month
  private String farmIDWithMostWeightMonthly;
  private String farmIDWithLeastWeightMonthly;
  private HashMap<String, FarmNode> hashTable; // holds
  
  /**
   * Initializes a new FarmIDHashTable for a given month
   * @param month - a month represented by an int - January = 1, Feb = 2, etc.
   */
  public FarmIDHashTable(int month) {
    
    size = 0;
    //chooses number of days in month based on which month
    switch(month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        DAYS_IN_MONTH = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        DAYS_IN_MONTH = 30;
        break;
      case 2:
        DAYS_IN_MONTH = 28;
        break;
        default: DAYS_IN_MONTH = 0;
    }
    
    hashTable = new HashMap<String, FarmNode>();
    
  }
  
  /**
   * inserts new FarmNode and compares with current farmNodes.
   * @param farmID - inserts the new FarmNode
   */
  public void insert(FarmNode farmID) {
    hashTable.put(farmID.getFarmID(), farmID);
    
    updateFarmRankings(farmID);
      
    
  }
  /**
   * 
   * @param other
   */
  private void updateFarmRankings(FarmNode farmID) {
    
    if (farmID.compareTo(hashTable.get(farmIDWithMostWeightMonthly))> 0) {
      farmIDWithMostWeightMonthly = farmID.getFarmID();
    }
    
    else if (farmID.compareTo(hashTable.get(farmIDWithLeastWeightMonthly)) < 0) {
      farmIDWithLeastWeightMonthly = farmID.getFarmID();
    }
  }
  
  /**
   * @return Returns the number of days in this month
   */
  public int getDaysInMonth() {
    return DAYS_IN_MONTH;
  }
  
  /**
   * Deletes the FarmNode if it exists.
   * @param farmID
   * @return true if successful, false otherwise.
   */
  public boolean deleteFarmID(String farmID) {
    
    if(hashTable.get(farmID) == null) {
      return false;
    }
    
    else 
      hashTable.remove(farmID);
      return true;
  }

  /**
   * Replaces the weight 
   * @param farmID
   * @param newDailyWeight
   * @return true if successful, false otherwise.
   */
  public boolean replaceDailyWeight(String farmID, int newDailyWeight, int day) {
    if(hashTable.get(farmID) == null) return false;
    else 
      hashTable.get(farmID).replaceDailyWeight(newDailyWeight, day);
    updateFarmRankings(hashTable.get(farmID));
    return true;
  }
  
  /**
   * @return the FarmNode that is associated with the inputed ID
   * If null is returned, this farmID does not exist in the hashTable. 
   */
  public FarmNode searchForFarm(String farmID) {
    return hashTable.get(farmID);
  }
  
  
}
