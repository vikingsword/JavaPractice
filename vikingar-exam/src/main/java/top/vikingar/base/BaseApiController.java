package top.vikingar.base;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import top.vikingar.content.WebContext;
import top.vikingar.domain.User;
import top.vikingar.utils.ModelMapperSingle;

/**
 * @author vikingar
 * @time 2024/2/18 11:27
 * @description
 */
public class BaseApiController {

    protected final static String PAGE_SIZE = "10";

    protected final static ModelMapper modelMapper = ModelMapperSingle.getInstance();

    @Autowired
    protected WebContext webContext;

    public User getCurrentUser() {
        return webContext.getCurrentUser();
    }



}
