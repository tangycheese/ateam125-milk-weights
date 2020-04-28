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
    public double getPercentInAllFarmIdWeight(){
        return weight/allFarmIdWeight;
    }
    public double getPercentInAllMonthWeight(){
        return weight/allMonthWeight;
    }

    public SumByYearEntity(String farmId, Integer year, Integer month) {
        this.farmId=farmId;
        this.year=year;
        this.month=month;
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
        return this.month.compareTo(other.month);
    }
}
