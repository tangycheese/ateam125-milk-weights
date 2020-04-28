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
    public double getPercentInAllFarmIdWeight(){
        return weight/allFarmIdWeight;
    }

    public StatisticEntityByYear(String farmId,Integer year) {
        this.farmId=farmId;
        this.year=year;
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
}
