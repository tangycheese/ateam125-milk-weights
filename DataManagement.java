
package application;
import java.util.*;

public class DataManagement{

  /**
   * key1: year month date
   * key2: farmid
   */
  private TreeMap<String,Map<String, SumByDayEntity>> allData=new TreeMap<>();
  private boolean hasData = false;

  public DataManagement() {}



  public TreeSet<SumByYearEntity> getStatisticsFARMREPORT(
          Integer year,String farmId) {
    TreeSet<SumByYearEntity> treeSet=new TreeSet<>();

    String startDay=DateUtil.getFirstDayStrByYear(year);
    String endDay=DateUtil.getEndDayStrByYear(year);
    DataBox dataBox=new DataBox();
    DataBox dataBoxAllFarmerByMonth=new DataBox();
    SortedMap<String,Map<String, SumByDayEntity>> targetData=allData.subMap(startDay,endDay);
    for(String day:targetData.keySet()) {
      Collection<SumByDayEntity> items = targetData.get(day).values();
      for (SumByDayEntity item : items) {
        if (item.getFarmId().equals(farmId)) {
          dataBox.addItem(item.getMonth() + ""
                  , item.getFarmId(), item.getWeight());
        }
        dataBoxAllFarmerByMonth.addItem(item.getMonth() + ""
                , item.getFarmId(), item.getWeight());
      }
    }
      Map<String, DataBox.SumDate> result=dataBox.sumByDate();
      Map<String, DataBox.SumDate> resultAllFarmer=dataBoxAllFarmerByMonth.sumByDate();
      for(String month:result.keySet()){
      DataBox.SumDate sumDate=result.get(month);
      SumByYearEntity entity=new SumByYearEntity(farmId,year,
              Integer.parseInt(month),
              sumDate.weight);
      entity.setAllFarmIdWeight(dataBox.getTotalWeight());
      entity.setAllMonthWeight(resultAllFarmer.get(month+"").weight);
      treeSet.add(entity);
    }
    return treeSet;
  }

  /**
   *
   * @param year
   * @param asc
   *  if asc is null: sorted by farmid!
   *     asc is true: sorted by weight  asc
   *     asc is false: sorted by weight desc
   * @return
   */
  public TreeSet<StatisticEntityByYear> getStatisticsANNUALREPORT(
          Integer year,Boolean asc) {
    StatisticEntityByYear.ASC=asc;
    TreeSet<StatisticEntityByYear> treeSet=new TreeSet<>();
    String startDay=DateUtil.getFirstDayStrByYear(year);
    String endDay=DateUtil.getEndDayStrByYear(year);
    DataBox dataBox=new DataBox();
    SortedMap<String,Map<String, SumByDayEntity>> targetData=allData.subMap(startDay,endDay);
    for(String day:targetData.keySet()){
      Collection<SumByDayEntity> allFarmInOneDay = targetData.get(day).values();
      for(SumByDayEntity item:allFarmInOneDay){
        dataBox.addItem(item.getYear()+"",item.getFarmId(),item.getWeight());
      }
    }
    Map<String, DataBox.SumDate> result=dataBox.sumByFarmId();
    for(String farmId:result.keySet()){
      DataBox.SumDate sumDate=result.get(farmId);
      StatisticEntityByYear entity=new StatisticEntityByYear(farmId,year,sumDate.weight);
      entity.setAllFarmIdWeight(dataBox.getTotalWeight());
      treeSet.add(entity);
    }
    return treeSet;
  }



  public TreeSet<SumByMonthEntity> getStatisticsMONTHLYREPORT(
          Integer year,Integer month,Boolean asc) {
    SumByMonthEntity.ASC=asc;

    TreeSet<SumByMonthEntity> returnResult=new TreeSet<>();

    for (int mon = 1; mon <=12 ; mon++) {
      String startDay = DateUtil.getFirstDayStr(year,mon);
      String endDay= DateUtil.getEndDayStr(year,mon);
      //get all month data
      SortedMap<String,Map<String, SumByDayEntity>> oneMonthData=allData.subMap(startDay,endDay);
      //farmid,collection
      DataBox dataBox=new DataBox();
      //put data to databox!
      for(String day:oneMonthData.keySet()){
        for(SumByDayEntity oneFarmInOneDay:oneMonthData.get(day).values()){
           dataBox.addItem(oneFarmInOneDay.getYYYYMMDate(),oneFarmInOneDay.getFarmId(),oneFarmInOneDay.getWeight());
        }
      }

      Map<String, DataBox.SumDate> boxResult=dataBox.sumByFarmId();
      for(String farmId:boxResult.keySet()){
        DataBox.SumDate oneFarmResult=boxResult.get(farmId);
        SumByMonthEntity oneFarmReturnValue
                =new SumByMonthEntity(farmId,year,mon,boxResult.get(farmId).weight);
        oneFarmReturnValue.setAllFarmIdWeight(dataBox.getTotalWeight());
        returnResult.add(oneFarmReturnValue);
      }

    }
    return returnResult;
  }


  public TreeSet<SumByRangeDateEntity> getStatisticsDATERANGEREPORT(
          String startDay,String endDay,Boolean asc) {
    String s = endDay
    endDay=DateUtil.getAddDaysStr(endDay,1);
    SumByDayEntity.ASC=asc;
    TreeSet<SumByRangeDateEntity> treeSet=new TreeSet<>(); //[startDay,endDay)
    SortedMap<String,Map<String, SumByDayEntity>> targetData=allData.subMap(startDay,endDay);
    DataBox dataBox =new DataBox();
    for(String day:targetData.keySet()){
        Collection<SumByDayEntity> allFarmInOneDay = targetData.get(day).values();
        for(SumByDayEntity item:allFarmInOneDay){
            dataBox.addItem("",item.getFarmId(),item.getWeight());
        }
    }
    Map<String, DataBox.SumDate> result=dataBox.sumByFarmId();
    for(String farmId:result.keySet()){
      DataBox.SumDate item=result.get(farmId);
      treeSet.add(new SumByRangeDateEntity(farmId,startDay+"-"+s,item.weight,dataBox.getTotalWeight()));
    }
    return treeSet;
  }

  private int computeSumWeight(Collection<SumByDayEntity> allFarmInOneDay) {
      int sum=0;
      for (SumByDayEntity item :
              allFarmInOneDay) {
        sum+=item.getWeight();
      }
    return sum;
  }


  //load file to allData
  public void loadData(String file){
    ParseFileUtil testing = new ParseFileUtil();
    TreeMap<String,Map<String, SumByDayEntity>> fileData=testing.parseFile(file);
    allData.putAll(fileData);
    hasData = true;
  }


  public void clearData(){
      allData.clear();
  }
  
  public boolean dataLoaded() {
    return hasData;
  }

}
