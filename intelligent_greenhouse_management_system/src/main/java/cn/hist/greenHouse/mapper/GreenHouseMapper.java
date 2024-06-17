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
    Integer getCount(Integer uid);
    List<GreenHouse> getPages(@Param("uid") Integer uid,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
    GreenHouse getOne(Integer uid);
}
