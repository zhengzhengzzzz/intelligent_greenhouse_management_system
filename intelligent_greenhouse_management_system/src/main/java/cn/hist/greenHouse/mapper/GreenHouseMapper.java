package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.GreenHouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GreenHouseMapper {
    void addGreenHouse(GreenHouse greenHouse);
    void deleteGreenHouse(Integer id);
    void updateGreenHouse(GreenHouse greenHouse);
    List<GreenHouse> getGreenHouses(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    Integer getGreenHouseCount();
    GreenHouse getDetails(Integer id);
}
