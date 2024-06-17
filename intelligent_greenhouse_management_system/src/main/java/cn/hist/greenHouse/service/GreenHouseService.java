package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.GreenHouse;

import java.util.List;
import java.util.Map;

public interface GreenHouseService {
    void addGreenHouse(GreenHouse greenHouse);
    void deleteGreenHouse(Integer id);
    void updateGreenHouse(GreenHouse greenHouse);
//    List<GreenHouse> getGreenHouses(Integer pageNum, Integer pageSize);
//    Integer getGreenHouseCount();
//    GreenHouse getDetails(Integer id);
    GreenHouse getOne(Integer uid);
    Map<String,Object> getPages(Integer uid,Integer pageNum,Integer pageSize);
}
