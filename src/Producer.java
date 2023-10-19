
public class Producer implements Comparable<Producer>{
    int ID;
    String countryOrigin;
    String farmName;
    String region;
    String cherryProcess;
    float aroma;
    float flavor;
    float aftertaste;
    float acidity;
    float body;
    float balance;
    float overallScore;

     

    public Producer(){
        
    }

    public Producer(int iD, String countryOrigin, String farmName, String region, String cherryProcess, float aroma,
            float flavor, float aftertaste, float acidity, float body, float balance, float overallScore) {
        ID = iD;
        this.countryOrigin = countryOrigin;
        this.farmName = farmName;
        this.region = region;
        this.cherryProcess = cherryProcess;
        this.aroma = aroma;
        this.flavor = flavor;
        this.aftertaste = aftertaste;
        this.acidity = acidity;
        this.body = body;
        this.balance = balance;
        this.overallScore = overallScore;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getCountryOrigin() {
        return countryOrigin;
    }
    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
    public String getFarmName() {
        return farmName;
    }
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCherryProcess() {
        return cherryProcess;
    }
    public void setCherryProcess(String cherryProcess) {
        this.cherryProcess = cherryProcess;
    }
    public float getAroma() {
        return aroma;
    }
    public void setAroma(float aroma) {
        this.aroma = aroma;
    }
    public float getFlavor() {
        return flavor;
    }
    public void setFlavor(float flavor) {
        this.flavor = flavor;
    }
    public float getAftertaste() {
        return aftertaste;
    }
    public void setAftertaste(float aftertaste) {
        this.aftertaste = aftertaste;
    }
    public float getAcidity() {
        return acidity;
    }
    public void setAcidity(float acidity) {
        this.acidity = acidity;
    }
    public float getBody() {
        return body;
    }
    public void setBody(float body) {
        this.body = body;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(float overallScore) {
        this.overallScore = overallScore;
    }
    
        @Override
    public String toString() {
        return  farmName + " [ID=" + ID + ", countryOrigin=" + countryOrigin + ", farmName=" + farmName + ", region="
                + region + ", cherryProcess=" + cherryProcess + ", aroma=" + aroma + ", flavor=" + flavor
                + ", aftertaste=" + aftertaste + ", acidity=" + acidity + ", body=" + body + ", balance=" + balance
                + ", overallScore=" + overallScore + "]";
    }

        @Override
        public int compareTo(Producer o) { //compares if Producer 1 ID > Producer 2 ID
            return this.ID - o.ID;
        }

}
