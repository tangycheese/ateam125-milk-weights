/**
 * input: farmId  year month
 * output：
 *
 */
public class SumByYearEntity implements
        Comparable<SumByYearEntity>{

    private String farmId;
    private Integer year;
    private Integer month;

    private Integer weight;

    private Integer allFarmIdWeight;
    private Integer allMonthWeight;

    //maybe show In View
    public String getPercentInAllFarmIdWeight(){
      double percent = ((double)100) * ((double) weight) / ((double) allFarmIdWeight);
      String trimmedPercent = percent + "";
      trimmedPercent = trimmedPercent.substring(0, 4);
      return trimmedPercent;
    }
    
    public String getPercentInAllMonthWeight(){
      double percent = ((double)100) * ((double) weight) / ((double) allMonthWeight);
      String trimmedPercent = percent + "";
      trimmedPercent = trimmedPercent.substring(0, 4);
      return trimmedPercent;
    }

    public SumByYearEntity(String farmId, Integer year, Integer month,Integer weight) {
        this.farmId=farmId;
        this.year=year;
        this.month=month;
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public void setAllMonthWeight(Integer allMonthWeight) {
        this.allMonthWeight = allMonthWeight;
    }

    public void setAllFarmIdWeight(Integer allFarmIdWeight) {
        this.allFarmIdWeight = allFarmIdWeight;
    }

    @Override
    public int compareTo(SumByYearEntity other) {
        int result= this.month.compareTo(other.month);
        if(result==0){
            result = this.farmId.compareTo(other.farmId);
        }
        return result;
    }

    @Override
    public String toString() {
        return "SumByYearEntity{" +
                "farmId='" + farmId + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", weight=" + weight +
                ", allFarmIdWeight=" + allFarmIdWeight +
                ", allMonthWeight=" + allMonthWeight +
                '}';
    }
}