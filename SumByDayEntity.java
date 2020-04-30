/**
 * input: year month
 */
public class SumByDayEntity implements Comparable<SumByDayEntity>{

    public static Boolean ASC = true;

    private String farmId;
    private Integer year;
    private Integer month;
    private Integer day;

    @Override
    public String toString() {
        return "SumByDayEntity{" +
                "farmId='" + farmId + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", weight=" + weight +
                ", allFarmIdWeight=" + allFarmIdWeight +
                ", weightPercent=" + this.getPercentInAllFarmIdWeight() +

                '}';
    }

    public String getYYYYMMDate(){
        return DateUtil.getYYYYMMDate(year,month);
    }

    private Integer weight;

    private Integer allFarmIdWeight;

    //maybe show In View
    public String getPercentInAllFarmIdWeight(){
      double percent = ((double)100) * ((double) weight) / ((double) allFarmIdWeight);
      String trimmedPercent = percent + "";
      trimmedPercent = trimmedPercent.substring(0, 4);
      return trimmedPercent;
    }

    public SumByDayEntity(String farmId, Integer year) {
        this.farmId=farmId;
        this.year=year;
    }

    public SumByDayEntity(String farmId, Integer year, Integer month, Integer day, Integer weight) {
        this.farmId=farmId;
        this.year=year;
        this.month=month;
        this.day=day;
        this.weight=weight;
    }
    public SumByDayEntity(String farmId, String yyyyMMdd, Integer weight) {
        this.farmId=farmId;
        this.year=Integer.parseInt(yyyyMMdd.substring(0,4));
        this.month=Integer.parseInt(yyyyMMdd.substring(4,6));
        this.day=Integer.parseInt(yyyyMMdd.substring(6,8));
        this.weight=weight;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setAllFarmIdWeight(Integer allFarmIdWeight) {
        this.allFarmIdWeight = allFarmIdWeight;
    }

    @Override
    public int compareTo(SumByDayEntity other) {
        int result=0;
        if(ASC!=null) {
            if (ASC) {
                result = this.weight.compareTo(other.weight);
            } else {
                result = -this.weight.compareTo(other.weight);
            }
        }
        if(result==0){
            result=this.farmId.compareTo(other.farmId);
        }
        if(result==0){
            result=this.getYYYYMMDDDate().compareTo(other.getYYYYMMDDDate());
        }
        return result;
    }

    private String  getYYYYMMDDDate() {
        return DateUtil.getYYYYMMDDDate(year,month,day);
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMonth() {
        return month;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getDay() {
        return day;
    }
}
