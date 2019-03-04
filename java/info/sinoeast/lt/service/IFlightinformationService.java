package info.sinoeast.lt.service;

import info.sinoeast.lt.bean.Flightinformation;

import java.util.List;

public interface IFlightinformationService {
/*
获取航班并分页
 */
    public List<Flightinformation> queryInformation();
    /*
    新增一个航班
     */
    public void insertFliinfo(Flightinformation flightinformation);
    /*
    编辑按钮 通过autoid获得数据集合
     */
    public Flightinformation selectfliinfoById(int fliAutoid);
    /*
    删除一条航班
     */
    public boolean deleteone(String fliNo);
    /*
    修改航班
     */
    public void updataByPrimaryKeySelective(Flightinformation flightinformation);

}
