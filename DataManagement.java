import java.util.*;

public class DataManagement{

  /**
   * key1: 年月日
   * key2: farmid
   */
  private TreeMap<String,Map<String, SumByDayEntity>> allData=new TreeMap<>();


  public DataManagement() {}



  public TreeSet<SumByYearEntity> getStatistics01(
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
  public TreeSet<StatisticEntityByYear> getStatistics02(
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



  public TreeSet<SumByMonthEntity> getStatistics03(
          Integer year,Integer month,Boolean asc) {
    SumByMonthEntity.ASC=asc;

    TreeSet<SumByMonthEntity> returnResult=new TreeSet<>();

    for (int mon = 1; mon <=12 ; mon++) {
      String startDay = DateUtil.getFirstDayStr(year,mon);
      String endDay= DateUtil.getEndDayStr(year,mon);
      //一个月的所有数据都得到了
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


  public TreeSet<SumByDayEntity> getStatistics04(
          String startDay,String endDay,Boolean asc) {
    SumByDayEntity.ASC=asc;
    TreeSet<SumByDayEntity> treeSet=new TreeSet<>();
    SortedMap<String,Map<String, SumByDayEntity>> targetData=allData.subMap(startDay,endDay);
    for(String day:targetData.keySet()){
        Collection<SumByDayEntity> allFarmInOneDay = targetData.get(day).values();
        int allFarmIdWeight = computeSumWeight( allFarmInOneDay );
        for(SumByDayEntity item:allFarmInOneDay){
            item.setAllFarmIdWeight(allFarmIdWeight);
            treeSet.add(item);
        }
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
  }


  public void clearData(){
      allData.clear();
  }
  

}
