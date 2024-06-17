package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.EnvironmentData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnvironmentDataMapper {
    void addEnvironmentData(EnvironmentData environmentData);
    void deleteEnvironmentData(Integer id);
    void updateEnvironmentData(EnvironmentData environmentData);
//    查询最新一条记录
    EnvironmentData getlatest(Integer gid);
//    查询历史参数
    List<Map<String,Object>> getEnvData(Integer gid);
//    分页查询
    List<EnvironmentData> getPages(@Param("gid") Integer gid,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
//    获取总数
    Integer getCount(Integer gid);
}
