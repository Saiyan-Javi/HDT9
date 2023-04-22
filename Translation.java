/**
 * 
 */
public class Translation {
    public String english;
    public String spanish;
    public String french;
    /**
     * 
     * @param english
     * @param spanish
     * @param french
     */
    public Translation(String english, String spanish, String french) {
        this.english = english;
        this.spanish = spanish;
        this.french = french;
    }
    /**
     * 
     * @return
     */
    public String getEnglish() {
        return english;
    }
    /**
     * 
     * @return
     */
    public String getSpanish() {
        return spanish;
    }
    /**
     * 
     * @return
     */
    public String getFrench() {
        return french;
    }
}