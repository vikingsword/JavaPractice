package vikingar.basicspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: vikingar
 * @time: 2024/1/9 12:40
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    private Integer id;

    private String name;

    private Integer age;

}
