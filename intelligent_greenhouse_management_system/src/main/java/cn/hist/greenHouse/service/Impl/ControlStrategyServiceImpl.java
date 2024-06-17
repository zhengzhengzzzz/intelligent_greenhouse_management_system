package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.ControlStrategy;
import cn.hist.greenHouse.mapper.ControlStrategyMapper;
import cn.hist.greenHouse.service.ControlStrategyService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ControlStrategyServiceImpl implements ControlStrategyService {
    @Autowired
    private ControlStrategyMapper controlStrategyMapper;
    @Override
    public ResponseResult addControlStrategy(ControlStrategy controlStrategy){
        if(controlStrategy.getGid()==null){
            return new ResponseResult(404,"必须传入温室编号");
        }
        controlStrategyMapper.addControlStrategy(controlStrategy);
        return new ResponseResult(200,"添加成功");
    }
    public ResponseResult deleteControlStrategy(Integer id){
        ControlStrategy con = controlStrategyMapper.getControlStrategy(id);
        if(con == null){
            return new ResponseResult(404,"删除失败");
        }
        controlStrategyMapper.deleteControlStrategy(id);
        return new ResponseResult(200,"删除成功");
    }
    public ResponseResult updateControlStrategy(ControlStrategy controlStrategy){
        ControlStrategy con = controlStrategyMapper.getControlStrategy(controlStrategy.getId());
        if(con == null){
            return new ResponseResult(404,"修改失败");
        }
        controlStrategyMapper.updateControlStrategy(controlStrategy);
        return new ResponseResult(200,"修改成功");
    }
    public ResponseResult getControlStrategy(Integer id){
        ControlStrategy data = controlStrategyMapper.getControlStrategy(id);
        if(data == null){
            return new ResponseResult(404,"查询失败");
        }
        return new ResponseResult(200,"查询成功",data);
    }

    public Map<String,Object> getPages(Integer gid,Integer pageNum,Integer pageSize){
       Integer offset = (pageNum - 1) * pageSize;
        List<ControlStrategy> list = controlStrategyMapper.getPages(gid,offset,pageSize);
        Integer totalCount = controlStrategyMapper.getCount(gid);
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;
        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return data;
    }
}
