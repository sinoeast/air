package info.sinoeast.lt.mapper;

import info.sinoeast.lt.bean.Flicom;
import info.sinoeast.lt.bean.Flightinformation;

import java.util.List;

public interface FlicomMapper {
    /*
    获取航班分页数据
     */
    List<Flicom> flicomInfo();
    /*
    新增航班数据
     */
    void insertFliinfo(Flightinformation flightinformation);
}
