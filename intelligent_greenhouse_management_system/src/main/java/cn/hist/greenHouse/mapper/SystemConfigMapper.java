package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.SystemConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemConfigMapper {
    void addSystemConfig(SystemConfig systemConfig);
    void deleteSystemConfig(Integer id);
    void updateSystemConfig(SystemConfig systemConfig);
    SystemConfig getSystemConfig(Integer id);
}
