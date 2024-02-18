package top.vikingar.viewmodel;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import top.vikingar.utils.ModelMapperSingle;

/**
 * @author vikingar
 * @time 2024/2/16 21:34
 * @description
 */
public class BaseVM {

    @Getter
    protected static ModelMapper modelMapper = ModelMapperSingle.getInstance();

    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}
