import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class DataManagementTest {
    @Test
    public void testGetStatisticsByStartAndEndDay(){
        DataManagement dataManagement=new DataManagement();
        dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\2020年4月28日\\ateam125-milk-weights-master\\test01.csv");
        TreeSet<SumByDayEntity> result= dataManagement.getStatisticsByStartAndEndDay("20190401","20190403",false);
        for(SumByDayEntity minSumEntity:result){
            System.out.println(minSumEntity);
        }
    }

    @Test
    public void testGetStatisticsByYearAndFarmId(){
        DataManagement dataManagement=new DataManagement();
        dataManagement.loadData("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\error\\2019-1.csv");
        TreeSet<SumByMonthEntity> result= dataManagement.getStatisticsByYearAndFarmId(2019,1,null);
        for(SumByMonthEntity item:result){
            System.out.println(item);
        }
    }
}
