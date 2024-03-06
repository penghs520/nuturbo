package cn.nuturbo.card.api;

import cn.nuturbo.card.api.request.CreateCardRequest;
import cn.nuturbo.card.api.entity.model.Card;
import cn.nuturbo.common.vo.Operator;
import cn.nuturbo.common.vo.Result;
import lombok.NonNull;

/**
 * Created by penghs at 2024/2/14 6:02
 */
public interface CardRemoteService {

    //新建卡片
    Result<Card> createCard(@NonNull CreateCardRequest createCardRequest, @NonNull Operator operator) throws Exception;

    //归档卡片

    //丢弃卡片

    //修改卡片名称

    //修改卡片描述

    //修改卡片字段

    //修改卡片状态

    //添加关联

    //删除关联

    //评论卡片   存在图上，两条关系：评论和回复

    //关注卡片

    //取消关注卡片

    //上传附件

    //删除附件

}
