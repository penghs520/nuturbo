package cn.nuturbo.schema.api.entity.model.action;

import cn.nuturbo.common.origintype.RelationFieldId;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

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
     * 操作对象：当前卡或关联卡
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tag")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = CurrentCard.class, name = "currentCard"),
            @JsonSubTypes.Type(value = RelatedCard.class, name = "relatedCard"),
    })
    interface OperationObject {

    }

    class CurrentCard implements OperationObject {

    }

    record RelatedCard(RelationFieldId relationFieldId) implements OperationObject {
        @JsonCreator
        public RelatedCard(@JsonProperty("relationFieldId") RelationFieldId relationFieldId) {
            this.relationFieldId = Asserts.notNull(relationFieldId, "relationFieldId is required");
        }
    }

    /**
     * 评论卡片
     */
    record Comment(OperationObject operationObject, TemplatedContent content) implements ActionItem {
        @JsonCreator
        public Comment(@JsonProperty("operationObject") OperationObject operationObject, @JsonProperty("content") TemplatedContent content) {
            this.operationObject = Asserts.notNull(operationObject, "operationObject is required");
            this.content = Asserts.notNull(content, "content is required");
        }
    }

    /**
     * 丢弃卡片
     */
    record Discard(OperationObject operationObject, TemplatedContent reason) implements ActionItem {
        @JsonCreator
        public Discard(@JsonProperty("operationObject") OperationObject operationObject, @JsonProperty("reason") TemplatedContent reason) {
            this.operationObject = Asserts.notNull(operationObject, "operationObject is required");
            this.reason = Asserts.notNull(reason, "reason is required");
        }
    }

    /**
     * 归档卡片
     */
    record Archive(OperationObject operationObject) implements ActionItem {
        @JsonCreator
        public Archive(@JsonProperty("operationObject") OperationObject operationObject) {
            this.operationObject = Asserts.notNull(operationObject, "operationObject is required");
        }
    }

    /**
     * 阻塞卡片
     */
    record Blocking(OperationObject operationObject, TemplatedContent reason) implements ActionItem {
        @JsonCreator
        public Blocking(@JsonProperty("operationObject") OperationObject operationObject, @JsonProperty("reason") TemplatedContent reason) {
            this.operationObject = Asserts.notNull(operationObject, "operationObject is required");
            this.reason = Asserts.notNull(reason, "reason is required");
        }
    }


    /**
     * 变更事项卡片的状态
     */
    record ChangeIssueStatus(OperationObject operationObject) implements ActionItem {

        @JsonCreator
        public ChangeIssueStatus(@JsonProperty("operationObject") OperationObject operationObject) {
            this.operationObject = Asserts.notNull(operationObject, "operationObject is required");
        }
    }

    /**
     * 修改属性值：赋值或清除值
     * 场景：当点击开始工作时，自动填充开始时间，同时
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
