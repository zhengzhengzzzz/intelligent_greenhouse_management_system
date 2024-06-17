package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemConfigMapper {
    void addSystemConfig(SystemConfig systemConfig);
    void deleteSystemConfig(Integer id);
    void updateSystemConfig(SystemConfig systemConfig);
    SystemConfig getSystemConfig(Integer id);
    Integer getCount(Integer uid);
    List<SystemConfig> getPages(@Param("uid") Integer uid,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
}
