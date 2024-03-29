package cn.nuturbo.schema.repository;

import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.schema.model.Schema;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SchemaRepository<T extends Schema<?>, ID extends SchemaId> {

    void create(T schemaEntity);

    void update(T schemaEntity);

    void delete(ID id);

    Optional<T> findById(ID id);

    default T findByIdElseThrow(ID id) {
        return findById(id).orElseThrow(() -> new IllegalStateException("不存在的%s(%s)".formatted(id.schemaType().name(), id.value())));
    }

    boolean isExists(ID id);

    List<T> findByIds(Collection<ID> ids);

    List<T> findByOrg(OrgId orgId);

    List<T> findByIndex(SchemaId indexId);

}
