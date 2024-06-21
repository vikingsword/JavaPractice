package top.vikingar.design;

/**
 * @author vikingar
 * @time 2024/6/21 10:14
 * @description
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter);

    IMenu appendCoat(Matter matter);

    IMenu appendFloor(Matter matter);

    IMenu appendTile(Matter matter);

    String getDetail();
}
