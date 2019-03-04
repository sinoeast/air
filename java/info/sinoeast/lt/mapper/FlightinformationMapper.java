package info.sinoeast.lt.mapper;

import info.sinoeast.lt.bean.Flightinformation;

import java.util.List;

public interface FlightinformationMapper {
    /*
    查询所有订单信息
     */
    List<Flightinformation> queryInformation();
    /*
    增加航班
     */
    void insertFliinfo(Flightinformation flightinformation);

    /*
    编辑按钮 通过autoid获得数据集合
     */
    Flightinformation selectfliinfoById(int fliAutoid);
    /*
    删除一条航班
     */
    void deleteone(String fliNo);
    /*
    修改航班
     */
    void updataByPrimaryKeySelective(Flightinformation flightinformation);
}
