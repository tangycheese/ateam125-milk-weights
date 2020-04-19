public class DataMangement {
   private LinkedList<YearlyData> allYears;
  
  public DataMangement() {}
  
  /**
  * searches for the information user wants from the data
  * @param String userInput input from user
  */
  public String search(String userInput) {}
  
  /**
  * reorders the data by the user's input
  * @param String userInput input from the user
  */
  public String getStatistics(String userInput) {}
  
  /**
  * put all the data in a specific year
  * @param String year year to add data to
  */
  public void createOneYearsData(String year) {}
  
  public File generateFile(File file) {}
  
  private String getMonthlyStatistics(String month) {}
  
  private String generateYearlyStatistics(String timePeriod) {}
}
