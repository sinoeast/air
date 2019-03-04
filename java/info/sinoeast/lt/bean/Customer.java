package info.sinoeast.lt.bean;

public class Customer {
    private int cusAutoid;
    private String cusAccount;
    private String cusPwd;
    private String cusId;
    private String cusSex;
    private String cusTelnumber;
    private String cusEmail;
    private String cusTime;
    private int cusIntegral;
    private boolean flag;

    public Customer() {
    }

    public Customer(int cusAutoid, String cusAccount, String cusPwd, String cusId, String cusSex, String cusTelnumber, String cusEmail, String cusTime, int cusIntegral, boolean flag) {
        this.cusAutoid = cusAutoid;
        this.cusAccount = cusAccount;
        this.cusPwd = cusPwd;
        this.cusId = cusId;
        this.cusSex = cusSex;
        this.cusTelnumber = cusTelnumber;
        this.cusEmail = cusEmail;
        this.cusTime = cusTime;
        this.cusIntegral = cusIntegral;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusAutoid=" + cusAutoid +
                ", cusAccount='" + cusAccount + '\'' +
                ", cusPwd='" + cusPwd + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cusSex='" + cusSex + '\'' +
                ", cusTelnumber='" + cusTelnumber + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusTime='" + cusTime + '\'' +
                ", cusIntegral=" + cusIntegral +
                ", flag=" + flag +
                '}';
    }

    public int getCusAutoid() {
        return cusAutoid;
    }

    public void setCusAutoid(int cusAutoid) {
        this.cusAutoid = cusAutoid;
    }

    public String getCusAccount() {
        return cusAccount;
    }

    public void setCusAccount(String cusAccount) {
        this.cusAccount = cusAccount;
    }

    public String getCusPwd() {
        return cusPwd;
    }

    public void setCusPwd(String cusPwd) {
        this.cusPwd = cusPwd;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusTelnumber() {
        return cusTelnumber;
    }

    public void setCusTelnumber(String cusTelnumber) {
        this.cusTelnumber = cusTelnumber;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusTime() {
        return cusTime;
    }

    public void setCusTime(String cusTime) {
        this.cusTime = cusTime;
    }

    public int getCusIntegral() {
        return cusIntegral;
    }

    public void setCusIntegral(int cusIntegral) {
        this.cusIntegral = cusIntegral;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
