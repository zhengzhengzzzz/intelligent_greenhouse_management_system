package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.GreenHouse;
import cn.hist.greenHouse.service.GreenHouseService;
import cn.hist.greenHouse.service.Impl.GreenHouseServiceImpl;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/greenHouse")
public class GreenHouseController {
    @Autowired
    private GreenHouseService greenHouseService;
    @PostMapping("/addGreenHouse")
    public ResponseResult addGreenHouse(@RequestBody GreenHouse greenHouse){
        greenHouseService.addGreenHouse(greenHouse);
        return new ResponseResult(200,"添加温室成功");
    }
    @DeleteMapping("/deleteGreenHouse/{id}")
    public ResponseResult deleteGreenHouse(@PathVariable Integer id){
        greenHouseService.deleteGreenHouse(id);
        return new ResponseResult(200,"删除温室成功");
    }
    @PutMapping("/updateGreenHouse")
    public ResponseResult updateGreenHouse(@RequestBody GreenHouse greenHouse){
        greenHouseService.updateGreenHouse(greenHouse);
        return new ResponseResult(200,"修改温室成功");
    }

    @GetMapping("/getPages")
    public ResponseResult getPages(@RequestParam Integer uid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Map<String,Object> data = greenHouseService.getPages(uid,pageNum,pageSize);
        return new ResponseResult(200,"查询成功",data);
    }
    @GetMapping("/getOne")
    public ResponseResult getOne(@RequestParam Integer uid){
        GreenHouse data = greenHouseService.getOne(uid);
        return new ResponseResult(200,"查询成功",data);
    }
    //    @GetMapping("/getGreenHouses")
//    public ResponseResult getGreenHouse(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
//                                          @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
//        List<GreenHouse> list = greenHouseService.getGreenHouses(pageNum,pageSize);
//        Integer totalCount = greenHouseService.getGreenHouseCount();
//        Integer totalPages = (totalCount + pageSize-1) / pageSize;
//
//        Map<String,Object> data = new TreeMap<>();
//        data.put("list",list);
//        data.put("currentPage",pageNum);
//        data.put("totalCount",totalCount);
//        data.put("totalPages",totalPages);
//        return new ResponseResult(200,"分页查询成功",data);
//    }
//    @GetMapping("/getDetails")
//    public ResponseResult getDetails(@RequestParam Integer id){
//        GreenHouse data = greenHouseService.getDetails(id);
//        return new ResponseResult(200,"查询成功",data);
//    }
}
