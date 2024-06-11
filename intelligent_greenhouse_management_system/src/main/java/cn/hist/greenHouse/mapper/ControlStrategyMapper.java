package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.ControlStrategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ControlStrategyMapper {
    void addControlStrategy(ControlStrategy controlStrategy);
    void deleteControlStrategy(Integer id);
    void updateControlStrategy(ControlStrategy controlStrategy);
    ControlStrategy getControlStrategy(Integer id);
}
