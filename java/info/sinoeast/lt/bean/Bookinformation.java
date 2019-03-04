package info.sinoeast.lt.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Bookinformation {

    private int booAutoid;
    private String comCode;
    private String cusId;
    private String booEveryday;
    private String booNo;
    private String booBaddress;
    private String booAaddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date booBtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date booAtime;
    private String booBerth;
    private int booNumber;
    private float booFare;
    private Date booTime;
    private Boolean flagPay;
    private Boolean flagType;
    private Boolean flag;
    private Customer customer;

    public Bookinformation() {
    }

    public Bookinformation(int booAutoid, String comCode, String cusId, String booEveryday, String booNo, String booBaddress, String booAaddress, Date booBtime, Date booAtime, String booBerth, int booNumber, float booFare, Date booTime, Boolean flagPay, Boolean flagType, Boolean flag) {
        this.booAutoid = booAutoid;
        this.comCode = comCode;
        this.cusId = cusId;
        this.booEveryday = booEveryday;
        this.booNo = booNo;
        this.booBaddress = booBaddress;
        this.booAaddress = booAaddress;
        this.booBtime = booBtime;
        this.booAtime = booAtime;
        this.booBerth = booBerth;
        this.booNumber = booNumber;
        this.booFare = booFare;
        this.booTime = booTime;
        this.flagPay = flagPay;
        this.flagType = flagType;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Bookinformation{" +
                "booAutoid=" + booAutoid +
                ", comCode='" + comCode + '\'' +
                ", cusId='" + cusId + '\'' +
                ", booEveryday='" + booEveryday + '\'' +
                ", booNo='" + booNo + '\'' +
                ", booBaddress='" + booBaddress + '\'' +
                ", booAaddress='" + booAaddress + '\'' +
                ", booBtime=" + booBtime +
                ", booAtime=" + booAtime +
                ", booBerth='" + booBerth + '\'' +
                ", booNumber=" + booNumber +
                ", booFare=" + booFare +
                ", booTime=" + booTime +
                ", flagPay=" + flagPay +
                ", flagType=" + flagType +
                ", flag=" + flag +
                ", customer=" + customer +
                '}';
    }

    public int getBooAutoid() {
        return booAutoid;
    }

    public void setBooAutoid(int booAutoid) {
        this.booAutoid = booAutoid;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getBooEveryday() {
        return booEveryday;
    }

    public void setBooEveryday(String booEveryday) {
        this.booEveryday = booEveryday;
    }

    public String getBooNo() {
        return booNo;
    }

    public void setBooNo(String booNo) {
        this.booNo = booNo;
    }

    public String getBooBaddress() {
        return booBaddress;
    }

    public void setBooBaddress(String booBaddress) {
        this.booBaddress = booBaddress;
    }

    public String getBooAaddress() {
        return booAaddress;
    }

    public void setBooAaddress(String booAaddress) {
        this.booAaddress = booAaddress;
    }

    public Date getBooBtime() {
        return booBtime;
    }

    public void setBooBtime(Date booBtime) {
        this.booBtime = booBtime;
    }

    public Date getBooAtime() {
        return booAtime;
    }

    public void setBooAtime(Date booAtime) {
        this.booAtime = booAtime;
    }

    public String getBooBerth() {
        return booBerth;
    }

    public void setBooBerth(String booBerth) {
        this.booBerth = booBerth;
    }

    public int getBooNumber() {
        return booNumber;
    }

    public void setBooNumber(int booNumber) {
        this.booNumber = booNumber;
    }

    public float getBooFare() {
        return booFare;
    }

    public void setBooFare(float booFare) {
        this.booFare = booFare;
    }

    public Date getBooTime() {
        return booTime;
    }

    public void setBooTime(Date booTime) {
        this.booTime = booTime;
    }

    public Boolean getFlagPay() {
        return flagPay;
    }

    public void setFlagPay(Boolean flagPay) {
        this.flagPay = flagPay;
    }

    public Boolean getFlagType() {
        return flagType;
    }

    public void setFlagType(Boolean flagType) {
        this.flagType = flagType;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
