package top.vikingar.design;

import top.vikingar.design.ceiling.LevelOneCeiling;
import top.vikingar.design.ceiling.LevelTwoCeiling;
import top.vikingar.design.coat.DuluxCoat;
import top.vikingar.design.coat.LiBangCoat;
import top.vikingar.design.floor.ShengXiangFloor;
import top.vikingar.design.tile.DongPengTile;
import top.vikingar.design.tile.MarcoPoloTile;

/**
 * @author vikingar
 * @time 2024/6/21 10:27
 * @description
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
