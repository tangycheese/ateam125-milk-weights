/**
 * input: year
 */
public class StatisticEntityByYear implements Comparable<StatisticEntityByYear>{

    public static Boolean ASC = null;

    private String farmId;
    private Integer year;

    private Integer weight;

    private Integer allFarmIdWeight;

    //maybe show In View
    public String getPercentInAllFarmIdWeight(){
      double percent = ((double)100) * ((double) weight) / ((double) allFarmIdWeight);
      String trimmedPercent = percent + "";
      trimmedPercent = trimmedPercent.substring(0, 4);
      return trimmedPercent;
    }

    public StatisticEntityByYear(String farmId,Integer year,Integer weight) {
        this.farmId=farmId;
        this.year=year;
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
    public int compareTo(StatisticEntityByYear other) {
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
        return result;
    }

    @Override
    public String toString() {
        return "StatisticEntityByYear{" +
                "farmId='" + farmId + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", allFarmIdWeight=" + allFarmIdWeight +
                '}';
    }
}