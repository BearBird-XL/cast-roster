package xyz.xionglei.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PERFORMER")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PerformerEntity {

    /*JPA自带的几种主键生成策略

    TABLE： 使用一个特定的数据库表格来保存主键
    SEQUENCE： 根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要与generator一起使用，generator 指定生成主键使用的生成器（可能是orcale中自己编写的序列）
    IDENTITY： 主键由数据库自动生成（主要是支持自动增长的数据库，如mysql）
    AUTO： 主键由程序控制，也是GenerationType的默认值*/
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "GenerationType.IDENTITY")
    @GeneratedValue(generator = "idGenerator")
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "other_name", length = 128)
    private String otherName;

    @Column(name = "img", length = 128)
    private String img;

    @Column(name = "remark", length = 1024)
    private String remark;
}
