package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.GreenHouse;

import java.util.List;

public interface GreenHouseService {
    void addGreenHouse(GreenHouse greenHouse);
    void deleteGreenHouse(Integer id);
    void updateGreenHouse(GreenHouse greenHouse);
    List<GreenHouse> getGreenHouses(Integer pageNum, Integer pageSize);
    Integer getGreenHouseCount();
    GreenHouse getDetails(Integer id);
}
