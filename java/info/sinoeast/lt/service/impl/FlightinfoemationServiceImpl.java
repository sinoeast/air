package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Flightinformation;
import info.sinoeast.lt.mapper.BookinformationMapper;
import info.sinoeast.lt.mapper.FlightinformationMapper;
import info.sinoeast.lt.service.IFlightinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightinfoemationServiceImpl implements IFlightinformationService {

    @Autowired
    FlightinformationMapper flightinformationMapper;
    @Override
    public List<Flightinformation> queryInformation() {
        return flightinformationMapper.queryInformation();
    }

    @Override
    public void insertFliinfo(Flightinformation flightinformation) {
            flightinformationMapper.insertFliinfo(flightinformation);
    }

    @Override
    public Flightinformation selectfliinfoById(int fliAutoid) {
        return flightinformationMapper.selectfliinfoById(fliAutoid);
    }
    @Autowired
    BookinformationMapper bookinformationMapper;
    @Override
    public boolean deleteone(String fliNo) {
        if(bookinformationMapper.queryCountByfliNo(fliNo)>0){
            return false;
        }else {
        flightinformationMapper.deleteone(fliNo);
            return true;
        }
    }

    @Override
    public void updataByPrimaryKeySelective(Flightinformation flightinformation) {
        flightinformationMapper.updataByPrimaryKeySelective(flightinformation);
    }
}
