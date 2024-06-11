package cn.hist.greenHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreenHouse {
      private Integer id;
      private Integer uid;
      private String name;
      private String location;
      private String description;

      private List<DeviceInfo> dev;
      private List<AlarmRecord> al;
      private List<EnvironmentData> env;
      private List<ControlStrategy> con;

    public GreenHouse(Integer uid, String name, String location, String description) {
        this.uid = uid;
        this.name = name;
        this.location = location;
        this.description = description;
    }
}
