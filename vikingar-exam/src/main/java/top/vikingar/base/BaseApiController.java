package top.vikingar.base;

import org.modelmapper.ModelMapper;
import top.vikingar.utils.ModelMapperSingle;

/**
 * @author vikingar
 * @time 2024/2/16 21:25
 * @description
 */
public class BaseApiController {

    /**
     * constant page size
     */
    protected final static String DEFAULT_PAGE_SIZE = "10";

    /**
     * constant modelMapper
     */
    protected final static ModelMapper modelMapper = ModelMapperSingle.getInstance();






}
