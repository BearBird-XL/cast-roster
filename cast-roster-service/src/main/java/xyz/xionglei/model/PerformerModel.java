package xyz.xionglei.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PerformerModel {

    private Long id;
    private String name;
    private String otherName;
    private String img;
    private String remark;

}
