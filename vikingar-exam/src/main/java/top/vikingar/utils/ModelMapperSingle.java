package top.vikingar.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author vikingar
 * @time 2024/2/16 21:07
 * @description
 */
public class ModelMapperSingle {

    protected final static ModelMapper modelMapper = new ModelMapper();

    private final static ModelMapperSingle modelMapperSingle = new ModelMapperSingle();


    static {
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static ModelMapper getInstance() {
        return modelMapperSingle.modelMapper;
    }

}
