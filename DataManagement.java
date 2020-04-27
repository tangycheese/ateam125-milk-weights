import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DataManagement implements DataManagementADT{

   private LinkedList<YearlyData> allYears;
  
   public DataManagement() {}
  
  /**
  * searches for the information user wants from the data
  * @param String userInput input from user
  */
  public String search(String userInput) {
    return null;
  }

  /**
   *
   * @return
   *    2019-01  1020001
   *    2019-02  100002
   */
  public List<StatisticEntity> getStatisticsByOneMonth() {
    return null;
  }

  /**
   *
   * @param minMonth 2019-01
   * @param maxMonth 2019-12
   * @return
   *    2019-01 f01  1020001
   *    2019-01 f02  1020031
   *    2019-02 f01  100002
   */
  public List<StatisticEntity> getStatisticsByMonthAndFarmId(String minMonth,String maxMonth,String farmId) {
    return null;
  }

  /**
   *
   * @param minDay 2019/01/01
   * @param maxDay 2019/02/28
   * @return
   *    2019/01/01-2019/02/28  f01  1020001
   *    2019/01/01-2019/02/28  f02  1020031
   */
  public List<StatisticEntity> getStatisticsByFarmId(String minDay,String maxDay) {
     return null;
  }


  
  /**
  * put all the data in a specific year
  * @param String year year to add data to
  */
  public void createOneYearsData(String year) {

  }
  
  /**
  * outputs the statistics into files
  * @param File file to load statistics to
  */
  public File generateFile(File file) {
    return null;
  }
  
  /**
  * Gives the relevant information for a given month, such as
  * which farm produced the least and most milk
  * @param String month statistics for that month
  */
  private String getMonthlyStatistics(String month) {
    return null;
  }
  
  /**
  * Gives the relevant information for a given year such as
  * total milk produced
  * @param String timePeriod
  */
  private String generateYearlyStatistics(String timePeriod) {
    return null;
  }
}
