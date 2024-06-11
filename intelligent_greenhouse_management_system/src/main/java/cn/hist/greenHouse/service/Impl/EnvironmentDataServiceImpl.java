package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.EnvironmentData;
import cn.hist.greenHouse.mapper.EnvironmentDataMapper;
import cn.hist.greenHouse.service.EnvironmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnvironmentDataServiceImpl implements EnvironmentDataService {
    @Autowired
    private EnvironmentDataMapper environmentDataMapper;
    @Override
    public void addEnvironmentData(EnvironmentData environmentData){
        environmentDataMapper.addEnvironmentData(environmentData);
    }
    @Override
    public void deleteEnvironmentData(Integer id){
        environmentDataMapper.deleteEnvironmentData(id);
    }
    @Override
    public void updateEnvironmentData(EnvironmentData environmentData){
        environmentDataMapper.updateEnvironmentData(environmentData);
    }
    @Override
    public EnvironmentData getlatest(){
        return environmentDataMapper.getlatest();
    }
    @Override
    public List<Map<String,Object>> getEnvData(){
        return environmentDataMapper.getEnvData();
    }
}
