package cn.nuturbo.query.core;

import cn.nuturbo.common.entity.Vertex;
import cn.nuturbo.query.model.condition.Condition;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 13:10
 */
@Service
public class DefaultVertexQueryService implements VertexQueryService {

    private final ConditionResolver conditionResolver;
    private final QueryBuilder queryBuilder;
    private final QueryRunner queryRunner;

    public DefaultVertexQueryService(ConditionResolver conditionResolver, QueryBuilder queryBuilder, QueryRunner queryRunner) {
        this.conditionResolver = conditionResolver;
        this.queryBuilder = queryBuilder;
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Vertex> query(QueryContext queryContext, Condition condition) {
        ResolvedCondition resolvedCondition = conditionResolver.resolve(condition);
        String query = queryBuilder.buildQuery(queryContext, resolvedCondition);
        return queryRunner.runQuery(query);
    }

    @Override
    public PageResult pageQuery(QueryContext queryContext, Condition condition) {
        return null;
    }

    @Override
    public Integer count(QueryContext queryContext, Condition condition) {
        return null;
    }
}
