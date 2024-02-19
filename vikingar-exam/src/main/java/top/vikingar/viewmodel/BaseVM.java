package top.vikingar.viewmodel;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import top.vikingar.utils.ModelMapperSingle;


public class BaseVM {
    /**
     * The constant modelMapper.
     * -- GETTER --
     *  Gets model mapper.
     *
     * @return the model mapper

     */
    @Getter
    protected static ModelMapper modelMapper = ModelMapperSingle.getInstance();


    /**
     * Sets model mapper.
     *
     * @param modelMapper the model mapper
     */
    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}
