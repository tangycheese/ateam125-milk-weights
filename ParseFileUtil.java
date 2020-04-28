import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseFileUtil {

    public ParseFileUtil() {

    }

    public TreeMap<String, Map<String, SumByDayEntity>> parseFile(String file) {
        //date: date+farm
        TreeMap<String, Map<String, SumByDayEntity>> result= new TreeMap<>();
        DataBox dataBox=new DataBox();
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) { // creates new bufferedReade
            String line=null;
            int lineNo=1;
            while((line=reader.readLine())!=null) {
                if (line.startsWith("date")) {
                    System.out.println("line "+lineNo +", table header:" + line + ",skiped.");
                } else {
                    DataItemEntity item = DataItemEntity.parseFromStr(lineNo,line);
                    if(item==null)continue;
                    dataBox.addItem(DateUtil.getYYYYMMDDDate(item.year,item.month,item.day)+","+item.farmID,null,
                            item.getWeight());
                    Map<String, DataBox.SumDate> dataAndFarmId_Weight=dataBox.sumByDate();
                    for(String dateAndFarmId:dataAndFarmId_Weight.keySet()){
                        String[] arr=dateAndFarmId.split(",");
                        String day=arr[0];
                        String farmId=arr[1];
                        if(result.get(day)==null){
                            result.put(day,new HashMap<>());
                        }
                        result.get(day).put(farmId,new SumByDayEntity(farmId,day,dataAndFarmId_Weight.get(dateAndFarmId).weight) );
                    }
                }
                lineNo++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
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
