package cn.nuturbo.schema.model;

import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 19:54
 */
@Getter
@Setter
public abstract class Schema<ID extends SchemaId> {

    private final ID id;

    private final OrgId orgId;

    private final String name;

    private final String description;

    protected Schema(ID id, OrgId orgId, String name, String description) {
        this.id = Asserts.notNull(id, "id of schema can not be null.");
        this.orgId = Asserts.notNull(orgId, "orgId of schema can not be null.");
        this.name = Asserts.notBlank(name, "name of schema can not be blank.");
        this.description = description;
    }

    public abstract SchemaId belongTo();

    public abstract List<SchemaId> secondaryIndexes();
}
