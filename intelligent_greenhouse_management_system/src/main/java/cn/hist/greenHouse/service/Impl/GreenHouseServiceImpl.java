package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.EnvironmentData;
import cn.hist.greenHouse.entity.GreenHouse;
import cn.hist.greenHouse.mapper.GreenHouseMapper;
import cn.hist.greenHouse.service.GreenHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public Map<String,Object> getPages(@RequestParam Integer uid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        //计算偏移量
        Integer offset = (pageNum - 1) * pageSize;
        List<GreenHouse> list = greenHouseMapper.getPages(uid, offset, pageSize);
        Integer totalCount = greenHouseMapper.getCount(uid);
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;
        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return data;
    }
    @Override
    public GreenHouse getOne(Integer uid){
        return greenHouseMapper.getOne(uid);
    }
//    @Override
//    public List<GreenHouse> getGreenHouses(Integer pageNum, Integer pageSize){
//        if(pageNum == 1){
//            pageNum = 0;
//        }
//        return greenHouseMapper.getGreenHouses(pageNum,pageSize);
//    }
//    @Override
//    public Integer getGreenHouseCount(){
//        return greenHouseMapper.getGreenHouseCount();
//    }
//    @Override
//    public GreenHouse getDetails(Integer id){
//        return greenHouseMapper.getDetails(id);
//    }
}
