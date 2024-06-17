package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.ControlStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ControlStrategyMapper {
    void addControlStrategy(ControlStrategy controlStrategy);
    void deleteControlStrategy(Integer id);
    void updateControlStrategy(ControlStrategy controlStrategy);
    ControlStrategy getControlStrategy(Integer id);
    Integer getCount(Integer gid);
    List<ControlStrategy> getPages(@Param("gid") Integer gid,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
}
