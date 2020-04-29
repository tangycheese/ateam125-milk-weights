public class DateUtil {
    private static int getLastDayOfMonth(int year,int month){
        int DAYS_IN_MONTH=0;
        //chooses number of days in month based on which month
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                DAYS_IN_MONTH = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                DAYS_IN_MONTH = 30;
                break;
            case 2:
                DAYS_IN_MONTH = 28;
                if(year%4==0&&year%100!=0||year%400==0){
                    DAYS_IN_MONTH=29;
                }
                break;
            default: DAYS_IN_MONTH = 0;
        }
        return DAYS_IN_MONTH;
    }

    public static String getFirstDayStr(Integer year, int mon) {
        return getYYYYMMDDDate(year,mon,1);
    }

    public static String getEndDayStr(Integer year, int mon) {
        return getYYYYMMDDDate(year,mon,getLastDayOfMonth(year,mon));
    }

    public static String getFirstDayStrByYear(Integer year) {
        return getFirstDayStr(year,1);
    }

    public static String getEndDayStrByYear(Integer year) {
        return getEndDayStr(year,12);
    }

    public static String getYYYYMMDate(int year,int month){
        return String.format("%04d%02d",year,month);
    }
    public static String getYYYYMMDDDate(int year,int month,int day){
        return String.format("%04d%02d%02d",year,month,day);
    }

}
