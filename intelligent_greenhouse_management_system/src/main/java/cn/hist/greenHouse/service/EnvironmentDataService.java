package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.EnvironmentData;

import java.util.List;
import java.util.Map;

public interface EnvironmentDataService {
    void addEnvironmentData(EnvironmentData environmentData);
    void deleteEnvironmentData(Integer id);
    void updateEnvironmentData(EnvironmentData environmentData);
    EnvironmentData getlatest(Integer gid);
    List<Map<String,Object>> getEnvData(Integer gid);
    Map<String, Object> getPages(Integer gid,Integer pageNum,Integer pageSize);
}
