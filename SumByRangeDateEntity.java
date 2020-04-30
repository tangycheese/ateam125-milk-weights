/**
 * input: farmId  year month
 * output：
 *
 */
public class SumByRangeDateEntity implements
        Comparable<SumByRangeDateEntity>{

   public static Boolean ASC=null;

    private String farmId;
    private String date;
    private Integer weight;

    private Integer allFarmIdWeight;

    //maybe show In View
    public double getPercentInAllFarmIdWeight(){
        return weight/allFarmIdWeight;
    }

    public SumByRangeDateEntity(String farmId, String date, Integer weight, Integer allFarmIdWeight) {
        this.farmId = farmId;
        this.date = date;
        this.weight = weight;
        this.allFarmIdWeight = allFarmIdWeight;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
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
    public int compareTo(SumByRangeDateEntity other) {
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
            result=this.getDate().compareTo(other.getDate());
        }
        return result;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SumByRangeDateEntity{" +
                "farmId='" + farmId + '\'' +
                ", date='" + date + '\'' +
                ", weight=" + weight +
                ", allFarmIdWeight=" + allFarmIdWeight +
                '}';
    }
}
