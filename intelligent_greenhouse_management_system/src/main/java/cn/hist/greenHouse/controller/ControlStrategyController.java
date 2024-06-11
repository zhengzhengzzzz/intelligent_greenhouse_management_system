package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.ControlStrategy;
import cn.hist.greenHouse.service.ControlStrategyService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/con")
public class ControlStrategyController {
    @Autowired
    private ControlStrategyService controlStrategyService;
    @PostMapping("/addCon")
    public ResponseResult addCon(@RequestBody ControlStrategy controlStrategy){
        return controlStrategyService.addControlStrategy(controlStrategy);
    }
    @DeleteMapping("/deleteCon")
    public ResponseResult deleteCon(@RequestParam Integer id){
        return controlStrategyService.deleteControlStrategy(id);
    }
    @PutMapping("/updateCon")
    public ResponseResult updateCon(@RequestBody ControlStrategy controlStrategy){
        return controlStrategyService.updateControlStrategy(controlStrategy);
    }
    @GetMapping("/getCon")
    public ResponseResult getCon(@RequestParam Integer id){
        return controlStrategyService.getControlStrategy(id);
    }
}
