import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class YearlyDataTest {
  

    public void testGenerateMonthlyStatistics(){

    }
  

    @Test
    public void testParseFile() {
        YearlyData testing = new YearlyData("2019");
        testing.parseFile("C:\\wps网盘同步文件夹\\高祈\\java_2020年4月21日\\csv\\error\\2019-1.csv");
        /*
line 1, table header:date,farm_id,weight,skiped.
line 20,error line:2019-1-4,Farm 121,OXVFWN
line 34,error line:P8EQ2S,Farm 120,12061
line 40,error line:2019-1-8,Farm 121,V70VO1
line 45,error line:IDU3LW,Farm 121,3745
line 57,error line:2019-1-12,Farm 118,ZH4OKR
line 69,error line:V16S6J,Farm 120,11993
line 74,error line:2019-1-15,Farm 120,DRCGJJ
line 82,error line:WNYHN5,Farm 118,17330
line 87,error line:RDL0U0,Farm 118,17434
line 92,error line:2019-1-19,Farm 118,SZFSP7
line 94,error line:AXJJ8W,Farm 120,11853
line 101,error line:2019-1-20,Farm 122,VYA0WZ
line 124,error line:CKOLKS,Farm 120,11800
line 132,error line:2019-1-27,Farm 118,U4RNS2
line 134,error line:2019-1-27,Farm 120,HE22II
line 137,error line:2019-1-28,Farm 118,HJXYE6
line 146,error line:FWISRW,Farm 122,17549
line 153,error line:IIZ38K,Farm 119,2583
         */
    }
  

    

  
}
