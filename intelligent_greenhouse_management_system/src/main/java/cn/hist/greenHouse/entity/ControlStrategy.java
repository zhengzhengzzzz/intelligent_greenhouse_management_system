package cn.hist.greenHouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ControlStrategy {
    private Integer id;
    private Integer gid;
    private String parameter;
    private Integer min;
    private Integer max;
    private String action;

    public ControlStrategy(Integer gid, String parameter, Integer min, Integer max, String action) {
        this.gid = gid;
        this.parameter = parameter;
        this.min = min;
        this.max = max;
        this.action = action;
    }
}
