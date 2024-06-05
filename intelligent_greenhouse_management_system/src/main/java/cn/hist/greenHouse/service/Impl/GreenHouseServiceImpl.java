package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.GreenHouse;
import cn.hist.greenHouse.mapper.GreenHouseMapper;
import cn.hist.greenHouse.service.GreenHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenHouseServiceImpl implements GreenHouseService {
    @Autowired
    private GreenHouseMapper greenHouseMapper;
    @Override
    public void addGreenHouse(GreenHouse greenHouse){
        greenHouseMapper.addGreenHouse(greenHouse);
    }
    @Override
    public void deleteGreenHouse(Integer id){
        greenHouseMapper.deleteGreenHouse(id);
    }
    @Override
    public void updateGreenHouse(GreenHouse greenHouse){
        greenHouseMapper.updateGreenHouse(greenHouse);
    }
    @Override
    public List<GreenHouse> getGreenHouses(Integer pageNum, Integer pageSize){
        if(pageNum == 1){
            pageNum = 0;
        }
        return greenHouseMapper.getGreenHouses(pageNum,pageSize);
    }
    @Override
    public Integer getGreenHouseCount(){
        return greenHouseMapper.getGreenHouseCount();
    }
}
