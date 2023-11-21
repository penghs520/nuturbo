package cn.nuturbo.common.origintype;

/**
 * Created by penghs at 2023/11/21 17:48
 */
public enum VertexKind {
    Member("成员类型"),
    Team("团队类型，用来创建团队卡，团队类型可以用来创建架构线、应用配置方案"),
    Issue("事项类型，用来创建具有工作状态的事项卡"),
    Record("记录类型，用来创建不可变更的某种记录，如打卡记录"),
    Abstract("抽象类型，可以被其他普通类型所继承，以获得共同的属性（包括关联属性）、行为");

    final String desc;

    VertexKind(String desc) {
        this.desc = desc;
    }
}
