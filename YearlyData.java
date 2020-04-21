import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class YearlyData {
  
    private LinkedList<FarmIDHashTable> allMonths;
    private int totalYearlyWeight;
    private String farmIDWithMostWeight;
    private String farmIDWithLeastWeight;
    private String thisYear;
  
    /**
     * 
     * @param year
     */
    public YearlyData(String year) {
      thisYear = year;
      allMonths = new LinkedList<FarmIDHashTable>();
    }
  
    /**
     * 
     * @param month
     * @return
     */
    public String generateMonthlyStatistics(String month) {
      return null;
    }
  
    /**
     * 
     * @param file
     */
    public void parseFile(String file) {
      
      String splitBy = ",";
      String row = "";
      BufferedReader reader;
      String farmID = "";
      int weight; //the weight of a single day.
      String[] date; // will parse the date to obtain day, month, year.
      String[] oneDay; //the parsed row
      int year;
      int month;
      int day;
      FarmIDHashTable oneMonth;
      
      //creates a BufferedReader object to go through the csv file
      // line by line.
      try {
        
        reader = new BufferedReader(new FileReader(file));
        row = reader.readLine(); // reads one line of csv file
        
        //accesses first row of file - then if it contains "date" skips. 
        oneDay = row.split(splitBy);
        if(oneDay[0].contentEquals("date"))
          row = reader.readLine();
          
        //now attempts to read the second row. 
        oneDay = row.split(splitBy);
        date = oneDay[0].split("-"); // array of 'date', where date[0] = the year, date[1] = the month, and date[2] = the day.
        month = Integer.parseInt(date[1]);
        day = Integer.parseInt(date[2]);
            
        oneMonth = new FarmIDHashTable(month);
        allMonths.add(oneMonth);
     
        farmID = oneDay[1]; // the farm ID to insert
        weight = Integer.parseInt(oneDay[2]);
        oneMonth.insert(farmID, day, weight); // now inserts a farmID into the given month. 
        
        row = reader.readLine();
        while (row != null) {
          oneDay = row.split(splitBy); //splits the row by a comma
          
          date = oneDay[0].split("-");  // gets date array
          day = Integer.parseInt(date[2]); // gets the day to insert as
          farmID = oneDay[1]; // gets the farmID
          weight = Integer.parseInt(oneDay[2]); // gets the weight
          oneMonth.insert(farmID, day, weight); // now inserts using all data. 
          
          row = reader.readLine(); // moves onto next line. 
        }
        
      } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      } catch (IOException e) {
        System.out.println(e.getMessage()); 
      } catch (NullPointerException e) {
        System.out.println(e.getStackTrace());
      } catch (NumberFormatException e) {
        System.out.println("Could not parse - in YearlyData: " + e.getMessage());
      }
    }
  
    /**
     * 
     * @param oneMonth
     * @return
     */
    private String createOneMonthsData(String oneMonth) {
      return null;
    }
  
    /**
     * 
     * @param oneFarmsData
     */
    private void createFarmNode(String oneFarmsData) {
      
    }
    
    /**
     * Testing methods
     * @param args
     */
    public static void main(String[] args) {
      YearlyData testing = new YearlyData("2019");
      testing.parseFile("2019-1.csv");
      System.out.println(testing.allMonths.get(0).searchForFarm("Farm 2").getTotalWeight());
    }
  
}
