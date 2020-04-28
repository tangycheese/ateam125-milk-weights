import java.util.*;

public class DataManagement{

  /**
   * key1: year month date
   * key2: farmid
   */
  private TreeMap<String,Map<String, SumByDayEntity>> allData=new TreeMap<>();


  public DataManagement() {}



  public TreeSet<SumByYearEntity> getStatisticsByYearAndFarmId(
          Integer year,String farmId) {
    TreeSet<SumByYearEntity> treeSet=new TreeSet<>();

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
  public TreeSet<StatisticEntityByYear> getStatisticsByYearAndFarmId(
          Integer year,Boolean asc) {
    StatisticEntityByYear.ASC=asc;
    TreeSet<StatisticEntityByYear> treeSet=new TreeSet<>();


    return null;
  }



  public TreeSet<SumByMonthEntity> getStatisticsByYearAndFarmId(
          Integer year,Integer month,Boolean asc) {
    SumByMonthEntity.ASC=asc;

    TreeSet<SumByMonthEntity> returnResult=new TreeSet<>();

    for (int mon = 1; mon <=12 ; mon++) {
      String startDay = DateUtil.getFirstDayStr(year,mon);
      String endDay= DateUtil.getEndDayStr(year,mon);
      //get the data for a month
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


  public TreeSet<SumByDayEntity> getStatisticsByStartAndEndDay(
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
