import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FarmIDHashTableTest {
    @Test
    public void testGetDaysInMonth(){
        for (int i = 1; i <= 12; i++) {
            int dayOfMonth=LocalDate.of(2019,i,1).lengthOfMonth();
            Assert.assertEquals(dayOfMonth,new FarmIDHashTable(i).getDaysInMonth());
        }
    }

    @Test
    public void testInsert(){

    }

}
