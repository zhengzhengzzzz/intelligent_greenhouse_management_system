package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.EnvironmentData;

import java.util.List;
import java.util.Map;

public interface EnvironmentDataService {
    void addEnvironmentData(EnvironmentData environmentData);
    void deleteEnvironmentData(Integer id);
    void updateEnvironmentData(EnvironmentData environmentData);
    EnvironmentData getlatest();
    List<Map<String,Object>> getEnvData();
}
