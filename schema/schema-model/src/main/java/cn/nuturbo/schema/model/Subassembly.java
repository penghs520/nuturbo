package cn.nuturbo.schema.model;

import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.origintype.SubassemblyId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 23:36
 * 一些具备通用特性的Schema子组件，比如过滤配置
 */
@Getter
public abstract class Subassembly<ID extends SubassemblyId> {

    private final ID id;

    private final SchemaId belongTo;

    protected Subassembly(ID id, SchemaId belongTo) {
        this.id = Asserts.notNull(id, "id of subassembly can not be null.");
        this.belongTo = Asserts.notNull(belongTo, "belongTo of subassembly can not be null.");
    }

    public ID id() {
        return id;
    }
}
