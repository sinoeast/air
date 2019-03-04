package info.sinoeast.lt.bean;

public class Areas {
    private int areaId;
    private String areaName;
    private String pycode;

    public Areas() {
    }

    public Areas(int areaId, String areaName, String pycode) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.pycode = pycode;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", pycode='" + pycode + '\'' +
                '}';
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }
}
