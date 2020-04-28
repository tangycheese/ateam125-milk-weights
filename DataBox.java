import java.util.*;

/**
 * 三个维度：
 * 日期  farmid  weight
 */
public class DataBox {
    public static class Data{
        String date;
        String farmId;
        Integer weight;

        public Data(String date, String farmId, Integer weight) {
            this.date = date;
            this.farmId = farmId;
            this.weight = weight;
        }
    }
    public static class SumDate{
        String title;
        Integer weight;

        public SumDate(String title, Integer computeSum) {
            this.title=title;
            this.weight=computeSum;
        }
    }

    Map<String,Collection<Data>> allDataByFarm=new HashMap<>();
    Map<String,Collection<Data>> allDataByDate=new HashMap<>();
    private Integer totalWeigth=0;

    public void addItem( String date,
            String farmId,
            Integer weight){
        totalWeigth+=weight;
        Data data=new Data(date,farmId,weight);
        if(allDataByFarm.get(farmId)==null){
            allDataByFarm.put(farmId,new LinkedList<>());
        }
        if(allDataByDate.get(date)==null){
            allDataByDate.put(date,new LinkedList<>());
        }
        allDataByFarm.get(farmId).add(data);
        allDataByDate.get(date).add(data);
    }

    public Map<String,SumDate> sumByFarmId(){
        Map<String,SumDate> sumResult=new HashMap<>();
        for(String farm:allDataByFarm.keySet()){
            Collection<Data> datas=allDataByFarm.get(farm);
            sumResult.put(farm,new SumDate(farm,computeSum(datas)));
        }
        return sumResult;
    }

    public Map<String,SumDate> sumByDate(){
        Map<String,SumDate> sumResult=new HashMap<>();
        for(String date:allDataByDate.keySet()){
            Collection<Data> datas=allDataByDate.get(date);
            sumResult.put(date,new SumDate(date,computeSum(datas)));
        }
        return sumResult;
    }

    private Integer computeSum(Collection<Data> datas){
        Integer sum=0;
        for(Data item:datas){
            sum+=item.weight;
        }
        return sum;
    }

    public Integer getTotalWeight(){
        return totalWeigth;
    }

}
