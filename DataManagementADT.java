import java.io.File;

public interface DataManagementADT{
    /**
     * searches for the information user wants from the data
     * @param String userInput input from user
     */
    public String search(String userInput);

    /**
     * reorders the data by the user's input
     * @param String userInput input from the user
     */
    public String getStatistics(String userInput);

    /**
     * put all the data in a specific year
     * @param String year year to add data to
     */
    public void createOneYearsData(String year);

    /**
     * outputs the statistics into files
     * @param File file to load statistics to
     */
    public File generateFile(File file);

    /**
     * Gives the relevant information for a given month, such as
     * which farm produced the least and most milk
     * @param String month statistics for that month
     */
    String getMonthlyStatistics(String month);


}