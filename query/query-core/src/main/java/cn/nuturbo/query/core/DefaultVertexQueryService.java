package cn.nuturbo.query.core;

import cn.nuturbo.common.entity.Vertex;
import cn.nuturbo.query.core.bo.ResolvedReturn;
import cn.nuturbo.query.core.vo.QueryContext;
import cn.nuturbo.query.core.bo.ResolvedCondition;
import cn.nuturbo.query.core.vo.PageResult;
import cn.nuturbo.query.core.vo.Return;
import cn.nuturbo.query.model.condition.Condition;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 13:10
 */
@Service
public class DefaultVertexQueryService implements VertexQueryService {

    private final ConditionResolver conditionResolver;
    private final ReturnResolver returnResolver;
    private final QueryBuilder queryBuilder;
    private final QueryRunner queryRunner;

    public DefaultVertexQueryService(ConditionResolver conditionResolver, ReturnResolver returnResolver, QueryBuilder queryBuilder, QueryRunner queryRunner) {
        this.conditionResolver = conditionResolver;
        this.returnResolver = returnResolver;
        this.queryBuilder = queryBuilder;
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Vertex> query(QueryContext queryContext, Condition condition, Return rtn) {
        ResolvedCondition resolvedCondition = conditionResolver.resolve(condition);
        ResolvedReturn resolvedReturn = returnResolver.resolve(rtn);
        String query = queryBuilder.buildQuery(queryContext, resolvedCondition, resolvedReturn);
        return queryRunner.runQuery(query);
    }

    @Override
    public PageResult pageQuery(QueryContext queryContext, Condition condition, Return rtn) {
        return null;
    }

    @Override
    public Integer count(QueryContext queryContext, Condition condition) {
        return null;
    }
}
