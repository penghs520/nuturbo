package cn.nuturbo.schema.model;

import cn.nuturbo.common.model.filtercondition.Condition;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 23:32
 */
@Getter
public class FilterConfig extends Subassembly<ConditionId> {

    private final Condition condition;

    public FilterConfig(ConditionId conditionID, SchemaId belongTo, Condition condition) {
        super(conditionID, belongTo);
        this.condition = Asserts.notNull(condition, "condition of filterConfig can not be null.");
    }
}
