package cn.nuturbo.schema.model;

import cn.nuturbo.common.model.filtercondition.Condition;
import cn.nuturbo.common.origintype.FilterId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 23:32
 */
@Getter
public class FilterConfig extends Subassembly<FilterId> {

    private final Condition condition;

    public FilterConfig(FilterId filterID, SchemaId belongTo, Condition condition) {
        super(filterID, belongTo);
        this.condition = Asserts.notNull(condition, "condition of filterConfig can not be null.");
    }
}
