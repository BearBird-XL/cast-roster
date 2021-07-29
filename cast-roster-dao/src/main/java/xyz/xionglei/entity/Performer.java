package xyz.xionglei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Performer {

    private Long id;
    private String name;
    private String otherName;
    private String img;
    private String remark;
}
