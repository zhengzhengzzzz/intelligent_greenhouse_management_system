package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUsreByName(String username);
}
