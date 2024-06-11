package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.service.UserService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/deleteUser")
    public ResponseResult deleteUser(@RequestParam Integer id){
        userService.deleteUser(id);
        return new ResponseResult(200,"删除用户成功");
    }
    @PutMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult(200,"修改用户成功");
    }
    @GetMapping("/getUsers")
    public ResponseResult getUsers(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<User> list = userService.getUsers(pageNum,pageSize);
        Integer totalCount = userService.getUserCount();
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;

        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return new ResponseResult(200,"用户查询成功",data);
    }
}
