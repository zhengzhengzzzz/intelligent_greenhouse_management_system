package cn.hist.greenHouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GreenHouse {
      private Integer id;
      private Integer uid;
      private String name;
      private String location;
      private String description;

    public GreenHouse(Integer uid, String name, String location, String description) {
        this.uid = uid;
        this.name = name;
        this.location = location;
        this.description = description;
    }
}
