package vikingar.usermanager.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vikingar
 * @time 2024/1/9 15:24
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {

    // 当前页码
    private Integer pageNum = 1;

    // 每一页显示的数量
    private Integer pageSize = 2;

    // 根据用户查询
    private String name;

}
