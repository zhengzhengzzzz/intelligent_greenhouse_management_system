package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.entity.SystemConfig;
import cn.hist.greenHouse.mapper.SystemConfigMapper;
import cn.hist.greenHouse.service.SystemConfigService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {
    @Autowired
    private SystemConfigMapper systemConfigMapper;
    @Override
    public ResponseResult addSystemConfig(SystemConfig systemConfig){
        if(systemConfig.getUid() == null){
            return new ResponseResult(404,"输入用户ID不能为空");
        }
        systemConfigMapper.addSystemConfig(systemConfig);
        return new ResponseResult(200,"添加成功");
    }
    @Override
    public ResponseResult deleteSystemConfig(Integer id){
        if(id == null){
            return new ResponseResult(404,"输入ID不能为空");
        }
        SystemConfig systemConfig = systemConfigMapper.getSystemConfig(id);
        if(systemConfig == null){
            return new ResponseResult(404,"请输入正确的ID");
        }
        systemConfigMapper.deleteSystemConfig(id);
        return new ResponseResult(200,"删除成功");
    }
    @Override
    public ResponseResult updateSystemConfig(SystemConfig systemConfig){
        if(systemConfig.getId() == null){
            return new ResponseResult(404,"输入的ID不能为空");
        }
        if(systemConfig.getUid() == null){
            return new ResponseResult(404,"输入用户ID不能为空");
        }
        if(systemConfigMapper.getSystemConfig(systemConfig.getId()) == null){
            return new ResponseResult(404,"请输入正确的ID");
        }
        systemConfigMapper.updateSystemConfig(systemConfig);
        return new ResponseResult(200,"修改成功");
    }
    @Override
    public ResponseResult getSystemConfig(Integer id){
        if(id == null){
            return new ResponseResult(404,"输入的ID不能为空");
        }
        SystemConfig data = systemConfigMapper.getSystemConfig(id);
        if(data == null){
            return new ResponseResult(404,"查询失败,请输入正确的ID");
        }
        return new ResponseResult(200,"查询成功",data);
    }

    @Override
    public Map<String,Object> getPages(Integer uid, Integer pageNum, Integer pageSize){
        Integer offset = (pageNum - 1) * pageSize; //计算偏移量
        List<SystemConfig> list = systemConfigMapper.getPages(uid, offset, pageSize);
        Integer totalCount = systemConfigMapper.getCount(uid);
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;
        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return data;
    }
}
