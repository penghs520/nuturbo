package cn.nuturbo.schema.model;

import cn.nuturbo.common.origintype.FilterID;
import cn.nuturbo.common.origintype.SchemaID;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.Condition;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 23:32
 */
@Getter
public class FilterConfig extends Subassembly<FilterID> {

    private final Condition condition;

    public FilterConfig(FilterID filterID, SchemaID belongTo, Condition condition) {
        super(filterID, belongTo);
        this.condition = Asserts.notNull(condition, "condition of filterConfig can not be null.");
    }
}
