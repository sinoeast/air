package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.AirType;
import info.sinoeast.lt.mapper.AirTypeMapper;
import info.sinoeast.lt.service.AirInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirInformationServiceImpl implements AirInfoService {
    @Autowired
    AirTypeMapper airTypeMapper;
    @Override
    public List<AirType> selectInfo() {
        return airTypeMapper.airInfo();
    }
}
