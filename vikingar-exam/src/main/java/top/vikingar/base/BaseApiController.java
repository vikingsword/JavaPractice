package top.vikingar.base;

import org.modelmapper.ModelMapper;
import top.vikingar.utils.ModelMapperSingle;

/**
 * @author vikingar
 * @time 2024/2/18 11:27
 * @description
 */
public class BaseApiController {

    protected final static String PAGE_SIZE = "10";

    protected final static ModelMapper modelMapper = ModelMapperSingle.getInstance();




}
