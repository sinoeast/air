package info.sinoeast.lt.bean;

public class AirType {
    private int airAutoid;
    private String airCode;
    private String airF;
    private String airFname;
    private int airFnumber;
    private String airC;
    private String airCname;
    private int airCnumber;
    private String airY;
    private String airYname;
    private int airYnumber;
    private int airTotalnumber;
    private boolean flag;
    private String airName;

    public AirType() {
    }

    public AirType(int airAutoid, String airCode, String airF, String airFname, int airFnumber, String airC, String airCname, int airCnumber, String airY, String airYname, int airYnumber, int airTotalnumber, boolean flag, String airName) {
        this.airAutoid = airAutoid;
        this.airCode = airCode;
        this.airF = airF;
        this.airFname = airFname;
        this.airFnumber = airFnumber;
        this.airC = airC;
        this.airCname = airCname;
        this.airCnumber = airCnumber;
        this.airY = airY;
        this.airYname = airYname;
        this.airYnumber = airYnumber;
        this.airTotalnumber = airTotalnumber;
        this.flag = flag;
        this.airName = airName;
    }

    @Override
    public String toString() {
        return "AirType{" +
                "airAutoid=" + airAutoid +
                ", airCode='" + airCode + '\'' +
                ", airF='" + airF + '\'' +
                ", airFname='" + airFname + '\'' +
                ", airFnumber=" + airFnumber +
                ", airC='" + airC + '\'' +
                ", airCname='" + airCname + '\'' +
                ", airCnumber=" + airCnumber +
                ", airY='" + airY + '\'' +
                ", airYname='" + airYname + '\'' +
                ", airYnumber=" + airYnumber +
                ", airTotalnumber=" + airTotalnumber +
                ", flag=" + flag +
                ", airName='" + airName + '\'' +
                '}';
    }

    public int getAirAutoid() {
        return airAutoid;
    }

    public void setAirAutoid(int airAutoid) {
        this.airAutoid = airAutoid;
    }

    public String getAirCode() {
        return airCode;
    }

    public void setAirCode(String airCode) {
        this.airCode = airCode;
    }

    public String getAirF() {
        return airF;
    }

    public void setAirF(String airF) {
        this.airF = airF;
    }

    public String getAirFname() {
        return airFname;
    }

    public void setAirFname(String airFname) {
        this.airFname = airFname;
    }

    public int getAirFnumber() {
        return airFnumber;
    }

    public void setAirFnumber(int airFnumber) {
        this.airFnumber = airFnumber;
    }

    public String getAirC() {
        return airC;
    }

    public void setAirC(String airC) {
        this.airC = airC;
    }

    public String getAirCname() {
        return airCname;
    }

    public void setAirCname(String airCname) {
        this.airCname = airCname;
    }

    public int getAirCnumber() {
        return airCnumber;
    }

    public void setAirCnumber(int airCnumber) {
        this.airCnumber = airCnumber;
    }

    public String getAirY() {
        return airY;
    }

    public void setAirY(String airY) {
        this.airY = airY;
    }

    public String getAirYname() {
        return airYname;
    }

    public void setAirYname(String airYname) {
        this.airYname = airYname;
    }

    public int getAirYnumber() {
        return airYnumber;
    }

    public void setAirYnumber(int airYnumber) {
        this.airYnumber = airYnumber;
    }

    public int getAirTotalnumber() {
        return airTotalnumber;
    }

    public void setAirTotalnumber(int airTotalnumber) {
        this.airTotalnumber = airTotalnumber;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }
}
