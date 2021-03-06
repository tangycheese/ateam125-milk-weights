import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class DataManagementTest {
    @Test
    public void testGetStatistics04(){
        DataManagement dataManagement=new DataManagement();
        dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\2020年4月28日\\ateam125-milk-weights-master\\test01.csv");
        TreeSet<SumByRangeDateEntity> result= dataManagement.getStatistics04("20190401","20190403",false);
        for(SumByRangeDateEntity minSumEntity:result){
            System.out.println(minSumEntity);
        }
    }

    @Test
    public void testGetStatisticsByYearAndFarmId(){
        DataManagement dataManagement=new DataManagement();
        dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\error\\2019-1.csv");
        TreeSet<SumByMonthEntity> result= dataManagement.getStatistics03(2019,1,null);
        for(SumByMonthEntity item:result){
            System.out.println(item);
        }
    }

    @Test
    public void testGetStatistics01(){
        DataManagement dataManagement=new DataManagement();
        for (int i = 1; i <= 12; i++) {
            dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\small\\2019-"+i+".csv");
        }
        TreeSet<SumByYearEntity> result= dataManagement.getStatistics01(2019,"Farm 0");
        for(SumByYearEntity item:result){
            System.out.println(item);
        }
    }

    @Test
    public void testGetStatistics02(){
        DataManagement dataManagement=new DataManagement();
        for (int i = 1; i <= 12; i++) {
            dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\small\\2019-"+i+".csv");
        }
        TreeSet<StatisticEntityByYear> result= dataManagement.getStatistics02(2019,null);
        for(StatisticEntityByYear item:result){
            System.out.println(item);
        }
    }

    @Test
    public void testGetStatistics04_01(){
        DataManagement dataManagement=new DataManagement();
        for (int i = 1; i <= 12; i++) {
            dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\large\\2019-"+i+".csv");
        }
        TreeSet<SumByRangeDateEntity> result= dataManagement.getStatistics04("20190301","20190409",null);
        for(SumByRangeDateEntity minSumEntity:result){
            System.out.println(minSumEntity);
        }
    }


}
