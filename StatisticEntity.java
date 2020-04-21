public class StatisticEntity {
    private String date;
    private String farmId;
    private Integer weight;

    public StatisticEntity() {

    }

    public StatisticEntity(String date, String farmId, Integer weight) {
        this.date = date;
        this.farmId = farmId;
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
