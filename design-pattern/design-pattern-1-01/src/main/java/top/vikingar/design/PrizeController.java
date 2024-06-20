package top.vikingar.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.card.IQiYiCardService;
import top.vikingar.design.coupon.CouponResult;
import top.vikingar.design.coupon.CouponService;
import top.vikingar.design.goods.DeliverReq;
import top.vikingar.design.goods.GoodsService;

/**
 * @author vikingar
 * @time 2024/6/20 12:41
 * @description
 */
public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        logger.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);
        AwardRes awardRes = null;
        if (req.getAwardType() == 1) {
            // 发放优惠券
            CouponService couponService = new CouponService();
            CouponResult result = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
            awardRes = new AwardRes("0000", result.getInfo());
        } else if (req.getAwardType() == 2) {
            // 发放实物商品
            GoodsService goodsService = new GoodsService();
            DeliverReq deliverReq = new DeliverReq();
            deliverReq.setUserName(queryUserName(req.getUId()));
            deliverReq.setUserPhone(queryUserPhone(req.getUId()));
            deliverReq.setSku(req.getAwardNumber());
            deliverReq.setOrderId(req.getBizId());
            deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
            deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
            deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
            goodsService.deliverGoods(deliverReq);
            awardRes = new AwardRes("0000", "success");

        } else if (req.getAwardType() == 3) {
            // 发放第三方兑换卡
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            iQiYiCardService.grantToken(queryUserPhone(req.getUId()), req.getAwardNumber());
            awardRes = new AwardRes("0000", "发送成功");
        }

        return awardRes;
    }

    private String queryUserPhone(String s) {
        return "1234";
    }

    private String queryUserName(String userId) {
        return "vikingar";
    }


}
