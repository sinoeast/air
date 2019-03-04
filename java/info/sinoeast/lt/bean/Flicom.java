package info.sinoeast.lt.bean;

public class Flicom {
    private int comAutoid;
    private String comCode;
    private String comName;
    private String comAddress;
    private String comRegister;
    private String comInformation;
    private boolean flag;

    @Override
    public String toString() {
        return "Flicom{" +
                "comAutoid=" + comAutoid +
                ", comCode='" + comCode + '\'' +
                ", comName='" + comName + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", comRegister='" + comRegister + '\'' +
                ", comInformation='" + comInformation + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Flicom() {
    }

    public Flicom(int comAutoid, String comCode, String comName, String comAddress, String comRegister, String comInformation, boolean flag) {
        this.comAutoid = comAutoid;
        this.comCode = comCode;
        this.comName = comName;
        this.comAddress = comAddress;
        this.comRegister = comRegister;
        this.comInformation = comInformation;
        this.flag = flag;
    }

    public int getComAutoid() {
        return comAutoid;
    }

    public void setComAutoid(int comAutoid) {
        this.comAutoid = comAutoid;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComRegister() {
        return comRegister;
    }

    public void setComRegister(String comRegister) {
        this.comRegister = comRegister;
    }

    public String getComInformation() {
        return comInformation;
    }

    public void setComInformation(String comInformation) {
        this.comInformation = comInformation;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
