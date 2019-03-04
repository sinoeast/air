package info.sinoeast.lt.bean;

import java.util.Date;

public class Manager {
    private int manAutoid;
    private String manAccount;
    private String manPwd;
    private String manID;
    private String manSex;
    private String manTelnumber;
    private String manEmail;
    private Date manTime;
    private boolean flag;

    public Manager() {
    }

    public Manager(int manAutoid, String manAccount, String manPwd, String manID, String manSex, String manTelnumber, String manEmail, Date manTime, boolean flag) {
        this.manAutoid = manAutoid;
        this.manAccount = manAccount;
        this.manPwd = manPwd;
        this.manID = manID;
        this.manSex = manSex;
        this.manTelnumber = manTelnumber;
        this.manEmail = manEmail;
        this.manTime = manTime;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manAutoid=" + manAutoid +
                ", manAccount='" + manAccount + '\'' +
                ", manPwd='" + manPwd + '\'' +
                ", manID='" + manID + '\'' +
                ", manSex='" + manSex + '\'' +
                ", manTelnumber='" + manTelnumber + '\'' +
                ", manEmail='" + manEmail + '\'' +
                ", manTime=" + manTime +
                ", flag=" + flag +
                '}';
    }

    public int getManAutoid() {
        return manAutoid;
    }

    public void setManAutoid(int manAutoid) {
        this.manAutoid = manAutoid;
    }

    public String getManAccount() {
        return manAccount;
    }

    public void setManAccount(String manAccount) {
        this.manAccount = manAccount;
    }

    public String getManPwd() {
        return manPwd;
    }

    public void setManPwd(String manPwd) {
        this.manPwd = manPwd;
    }

    public String getManID() {
        return manID;
    }

    public void setManID(String manID) {
        this.manID = manID;
    }

    public String getManSex() {
        return manSex;
    }

    public void setManSex(String manSex) {
        this.manSex = manSex;
    }

    public String getManTelnumber() {
        return manTelnumber;
    }

    public void setManTelnumber(String manTelnumber) {
        this.manTelnumber = manTelnumber;
    }

    public String getManEmail() {
        return manEmail;
    }

    public void setManEmail(String manEmail) {
        this.manEmail = manEmail;
    }

    public Date getManTime() {
        return manTime;
    }

    public void setManTime(Date manTime) {
        this.manTime = manTime;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
