package info.sinoeast.lt.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Flightinformation {
    private int fliAutoid;
    private String comCode;
    private String airCode;
    @Pattern(regexp = "^周[一二三四五六日]$",message = "请输入周一周二。。。周六周日")
    private String fliEveryday;
    private String fliNo;
    private float fliDiscount;
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{0,}$",message = "只能输入汉字")
    private String fliBaddress;
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{0,}$",message = "只能输入汉字")
    private String fliAaddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date fliBtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date fliAtime;
    private int fliFnumber;
    private int fliCnumber;
    private int fliYnumber;
    private float fliFfare;
    private float fliCfare;
    private float fliYfare;
    private Date fliRefundtime;
    private boolean fliRefund;
    private boolean flag;

    public Flightinformation() {
    }

    public Flightinformation(int fliAutoid, String comCode, String airCode, String fliEveryday, String fliNo, float fliDiscount, String fliBaddress, String fliAaddress, Date fliBtime, Date fliAtime, int fliFnumber, int fliCnumber, int fliYnumber, float fliFfare, float fliCfare, float fliYfare, Date fliRefundtime, boolean fliRefund, boolean flag) {
        this.fliAutoid = fliAutoid;
        this.comCode = comCode;
        this.airCode = airCode;
        this.fliEveryday = fliEveryday;
        this.fliNo = fliNo;
        this.fliDiscount = fliDiscount;
        this.fliBaddress = fliBaddress;
        this.fliAaddress = fliAaddress;
        this.fliBtime = fliBtime;
        this.fliAtime = fliAtime;
        this.fliFnumber = fliFnumber;
        this.fliCnumber = fliCnumber;
        this.fliYnumber = fliYnumber;
        this.fliFfare = fliFfare;
        this.fliCfare = fliCfare;
        this.fliYfare = fliYfare;
        this.fliRefundtime = fliRefundtime;
        this.fliRefund = fliRefund;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Flightinformation{" +
                "fliAutoid=" + fliAutoid +
                ", comCode='" + comCode + '\'' +
                ", airCode='" + airCode + '\'' +
                ", fliEveryday='" + fliEveryday + '\'' +
                ", fliNo='" + fliNo + '\'' +
                ", fliDiscount=" + fliDiscount +
                ", fliBaddress='" + fliBaddress + '\'' +
                ", fliAaddress='" + fliAaddress + '\'' +
                ", fliBtime=" + fliBtime +
                ", fliAtime=" + fliAtime +
                ", fliFnumber=" + fliFnumber +
                ", fliCnumber=" + fliCnumber +
                ", fliYnumber=" + fliYnumber +
                ", fliFfare=" + fliFfare +
                ", fliCfare=" + fliCfare +
                ", fliYfare=" + fliYfare +
                ", fliRefundtime=" + fliRefundtime +
                ", fliRefund=" + fliRefund +
                ", flag=" + flag +
                '}';
    }

    public int getFliAutoid() {
        return fliAutoid;
    }

    public void setFliAutoid(int fliAutoid) {
        this.fliAutoid = fliAutoid;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getAirCode() {
        return airCode;
    }

    public void setAirCode(String airCode) {
        this.airCode = airCode;
    }

    public String getFliEveryday() {
        return fliEveryday;
    }

    public void setFliEveryday(String fliEveryday) {
        this.fliEveryday = fliEveryday;
    }

    public String getFliNo() {
        return fliNo;
    }

    public void setFliNo(String fliNo) {
        this.fliNo = fliNo;
    }

    public float getFliDiscount() {
        return fliDiscount;
    }

    public void setFliDiscount(float fliDiscount) {
        this.fliDiscount = fliDiscount;
    }

    public String getFliBaddress() {
        return fliBaddress;
    }

    public void setFliBaddress(String fliBaddress) {
        this.fliBaddress = fliBaddress;
    }

    public String getFliAaddress() {
        return fliAaddress;
    }

    public void setFliAaddress(String fliAaddress) {
        this.fliAaddress = fliAaddress;
    }

    public Date getFliBtime() {
        return fliBtime;
    }

    public void setFliBtime(Date fliBtime) {
        this.fliBtime = fliBtime;
    }

    public Date getFliAtime() {
        return fliAtime;
    }

    public void setFliAtime(Date fliAtime) {
        this.fliAtime = fliAtime;
    }

    public int getFliFnumber() {
        return fliFnumber;
    }

    public void setFliFnumber(int fliFnumber) {
        this.fliFnumber = fliFnumber;
    }

    public int getFliCnumber() {
        return fliCnumber;
    }

    public void setFliCnumber(int fliCnumber) {
        this.fliCnumber = fliCnumber;
    }

    public int getFliYnumber() {
        return fliYnumber;
    }

    public void setFliYnumber(int fliYnumber) {
        this.fliYnumber = fliYnumber;
    }

    public float getFliFfare() {
        return fliFfare;
    }

    public void setFliFfare(float fliFfare) {
        this.fliFfare = fliFfare;
    }

    public float getFliCfare() {
        return fliCfare;
    }

    public void setFliCfare(float fliCfare) {
        this.fliCfare = fliCfare;
    }

    public float getFliYfare() {
        return fliYfare;
    }

    public void setFliYfare(float fliYfare) {
        this.fliYfare = fliYfare;
    }

    public Date getFliRefundtime() {
        return fliRefundtime;
    }

    public void setFliRefundtime(Date fliRefundtime) {
        this.fliRefundtime = fliRefundtime;
    }

    public boolean isFliRefund() {
        return fliRefund;
    }

    public void setFliRefund(boolean fliRefund) {
        this.fliRefund = fliRefund;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
