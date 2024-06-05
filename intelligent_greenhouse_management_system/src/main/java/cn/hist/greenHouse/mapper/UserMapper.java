package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
//    void addUser(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
    List<User> getUsers(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    Integer getUsersCount();
}
