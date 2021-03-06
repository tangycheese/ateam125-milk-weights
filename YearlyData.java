import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
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
     * Returns a single farm's data for this whole year.
     * @param farmID
     * @return
     */
    public StatisticEntity farmReport(String farmID) {
      return null;
    }
  
    /**
     * 
     * @param month
     * @return
     */
    public ArrayList<StatisticEntity> monthlyReport(String month) {
      return null;
    }
    
    /**
     * Returns data for all farms over the entire year
     * @return
     */
    public ArrayList<StatisticEntity> annualReport() {
      return null;
    }
    
    /**
     * Returns data for all farms over the given data range. 
     * @return
     */
    public ArrayList<StatisticEntity> dataRangeReport(String month1, String day1, String month2, String day2) {
      return null;
    }


    public void parseFile(String file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) { // creates new bufferedReader
            FarmIDHashTable oneMonth=null;
            String line=null;
            int lineNo=1;
            while((line=reader.readLine())!=null) {
                if (line.startsWith("date")) {
                    System.out.println("line "+lineNo +", table header:" + line + ",skiped.");
                } else {
                    DataItemEntity item = DataItemEntity.parseFromStr(lineNo,line);
                    if (item != null) {
                        if (oneMonth == null) {
                            oneMonth = new FarmIDHashTable(item.getMonth());
                        }
                        oneMonth.insert(item.getFarmID(), item.getDay(), item.getWeight());
                    }
                }
                lineNo++;
            }
            allMonths.add(oneMonth);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    /**
//     * 
//     * @param file
//     */
//    public void parseFile2(String file) {
//      
//      String splitBy = ",";
//      String row = "";
//      BufferedReader reader;
//      String farmID = "";
//      int weight; //the weight of a single day.
//      String[] date; // will parse the date to obtain day, month, year.
//      String[] oneDay; //the parsed row
//      int year;
//      int month;
//      int day;
//      FarmIDHashTable oneMonth;
//      
//      //creates a BufferedReader object to go through the csv file
//      // line by line.
//      try {
//        
//        reader = new BufferedReader(new FileReader(file));
//        row = reader.readLine(); // reads one line of csv file
//        
//        //accesses first row of file - then if it contains "date" skips. 
//        oneDay = row.split(splitBy);
//        if(oneDay[0].contentEquals("date")) {
//            row = reader.readLine();
//        }
//
//        //now attempts to read the second row. 
//        oneDay = row.split(splitBy);
//        date = oneDay[0].split("-"); // array of 'date', where date[0] = the year, date[1] = the month, and date[2] = the day.
//        month = Integer.parseInt(date[1]);
//        day = Integer.parseInt(date[2]);
//            
//        oneMonth = new FarmIDHashTable(month);
//        allMonths.add(oneMonth);
//     
//        farmID = oneDay[1]; // the farm ID to insert
//        weight = Integer.parseInt(oneDay[2]);
//        oneMonth.insert(farmID, day, weight); // now inserts a farmID into the given month. 
//        
//        row = reader.readLine();
//        while (row != null) {
//          oneDay = row.split(splitBy); //splits the row by a comma
//          
//          date = oneDay[0].split("-");  // gets date array
//          day = Integer.parseInt(date[2]); // gets the day to insert as
//          farmID = oneDay[1]; // gets the farmID
//          weight = Integer.parseInt(oneDay[2]); // gets the weight
//          oneMonth.insert(farmID, day, weight); // now inserts using all data. 
//          
//          row = reader.readLine(); // moves onto next line. 
//        }
//        
//      } catch (FileNotFoundException e) {
//        System.out.println(e.getMessage());
//      } catch (IOException e) {
//        System.out.println(e.getMessage()); 
//      } catch (NullPointerException e) {
//        System.out.println(e.getStackTrace());
//      } catch (NumberFormatException e) {
//        System.out.println("Could not parse - in YearlyData: " + e.getMessage());
//      }
//    }
//  
    
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


    public static class DataItemEntity {
        private int year;
        private int month;
        private int day;
        private String farmID;
        private int weight;

        public DataItemEntity() {
        }

        public DataItemEntity(int year, int month, int day, String farmID, int weight) {

            this.year = year;
            this.month = month;
            this.day = day;
            this.farmID = farmID;
            this.weight = weight;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getFarmID() {
            return farmID;
        }

        public void setFarmID(String farmID) {
            this.farmID = farmID;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public static DataItemEntity parseFromStr(int lineNo, String data){
            try {
                DataItemEntity item = new DataItemEntity();
                String[] arr=data.split(",");
                if(arr.length!=3){
                    System.err.println("line "+lineNo +",error line:"+data);
                    return null;
                }
                String dateStr = arr[0].trim();
                item.farmID = arr[1].trim();
                item.weight = Integer.parseInt(arr[2].trim());
                String[] dateArr=dateStr.split("[^0-9]+");
                item.year = Integer.parseInt(dateArr[0].trim());
                item.month = Integer.parseInt(dateArr[1].trim());
                item.day = Integer.parseInt(dateArr[2].trim());
                return item;
            } catch (Exception e) {
                //e.printStackTrace();
                System.err.println("line "+lineNo +",error line:"+data);
                return null;
            }
        }
    }

}
