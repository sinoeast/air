package info.sinoeast.lt.service;

import info.sinoeast.lt.bean.Bookinformation;

import java.util.List;

public interface IBookinformationService {

    /*
    查询所有订单信息
     */
    public List<Bookinformation> queryInformation();
}
