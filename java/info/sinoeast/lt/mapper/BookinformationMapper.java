package info.sinoeast.lt.mapper;

import info.sinoeast.lt.bean.Bookinformation;

import java.util.List;

public interface BookinformationMapper {

    /*
    查询所有订单信息
     */
    List<Bookinformation> queryInformation();
    /*
    查询订单
    re：flino
     */
    int queryCountByfliNo(String fliNo);
}
