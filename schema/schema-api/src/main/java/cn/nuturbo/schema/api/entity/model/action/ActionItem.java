package cn.nuturbo.schema.api.entity.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tag")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActionItem.Comment.class, name = "comment"),
        @JsonSubTypes.Type(value = ActionItem.Discard.class, name = "discard"),
        @JsonSubTypes.Type(value = ActionItem.Archive.class, name = "archive"),
        @JsonSubTypes.Type(value = ActionItem.ChangeIssueStatus.class, name = "changeIssueStatus"),
        @JsonSubTypes.Type(value = ActionItem.ChangeProperty.class, name = "changeProperty"),
        @JsonSubTypes.Type(value = ActionItem.CreateRecord.class, name = "createRecord"),
        @JsonSubTypes.Type(value = ActionItem.Notify.class, name = "notify"),
})
public interface ActionItem {

    /**
     * 评论卡片
     */
    class Comment implements ActionItem {

    }

    /**
     * 丢弃卡片
     */
    class Discard implements ActionItem {

    }

    /**
     * 归档卡片
     */
    class Archive implements ActionItem {

    }

    /**
     * 变更事项卡片的状态
     */
    class ChangeIssueStatus implements ActionItem {

    }

    /**
     * 修改属性值：赋值或清除值
     */
    class ChangeProperty implements ActionItem {


    }

    /**
     * 生成记录
     */
    class CreateRecord implements ActionItem {

    }

    /**
     * 消息通知
     */
    class Notify implements ActionItem {
        //TODO 触发消息渠道配置的通知事件（更好复用）
    }

}
