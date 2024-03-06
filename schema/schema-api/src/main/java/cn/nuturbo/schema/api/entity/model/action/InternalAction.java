package cn.nuturbo.schema.api.entity.model.action;

public abstract class InternalAction implements Action {

    /**
     * 评论卡片
     */
    public static class Comment extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("comment");
        }
    }

    /**
     * 丢弃卡片
     */
    public static class Discard extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("abandon");
        }
    }

    /**
     * 归档卡片
     */
    public static class Archive extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("archive");
        }
    }

    /**
     * 变更事项卡片的状态
     */
    public static class ChangeIssueStatus extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("changeIssueStatus");
        }
    }

    /**
     * 修改属性值：赋值或清除值
     */
    public static class ChangeProperty extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("changeProperty");
        }
    }

    /**
     * 生成记录
     */
    public static class CreateRecord extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("createRecord");
        }
    }

    /**
     * 消息通知
     */
    public static class Notify extends InternalAction {

        @Override
        public ActionId getId() {
            return new ActionId("notify");
        }
    }

}
