package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.EnvironmentData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnvironmentDataMapper {
    void addEnvironmentData(EnvironmentData environmentData);
    void deleteEnvironmentData(Integer id);
    void updateEnvironmentData(EnvironmentData environmentData);
//    查询最新一条记录
    EnvironmentData getlatest();
//    查询历史参数
    List<Map<String,Object>> getEnvData();
}
