package vikingar.basicspring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vikingar.basicspring.mapper.CatMapper;
import vikingar.basicspring.service.CatService;

/**
 * @author: vikingar
 * @time: 2024/1/9 12:43
 * @description:
 */
@Service("catService")
public class CatServiceImpl implements CatService {

    @Autowired
    private CatMapper catMapper;


    @Override
    public String getName() {
        return catMapper.getName();
    }
}
