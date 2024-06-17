package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.EnvironmentData;
import cn.hist.greenHouse.entity.GreenHouse;
import cn.hist.greenHouse.mapper.EnvironmentDataMapper;
import cn.hist.greenHouse.service.EnvironmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class EnvironmentDataServiceImpl implements EnvironmentDataService {
    @Autowired
    private EnvironmentDataMapper environmentDataMapper;
    @Override
    public void addEnvironmentData(EnvironmentData environmentData){
        environmentDataMapper.addEnvironmentData(environmentData);
    }
    @Override
    public void deleteEnvironmentData(Integer id){
        environmentDataMapper.deleteEnvironmentData(id);
    }
    @Override
    public void updateEnvironmentData(EnvironmentData environmentData){
        environmentDataMapper.updateEnvironmentData(environmentData);
    }
    @Override
    public EnvironmentData getlatest(Integer gid){
        return environmentDataMapper.getlatest(gid);
    }
    @Override
    public List<Map<String,Object>> getEnvData(Integer gid){
        return environmentDataMapper.getEnvData(gid);
    }
    @Override
    public Map<String, Object> getPages(Integer gid, Integer pageNum, Integer pageSize){
//       计算偏移量
        Integer offset = (pageNum - 1) * pageSize;
        List<EnvironmentData> list = environmentDataMapper.getPages(gid, offset, pageSize);
        Integer totalCount = environmentDataMapper.getCount(gid);
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;

        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return data;
    }
}
