package cn.nuturbo.card.query;

import cn.nuturbo.card.query.vo.PageResult;
import cn.nuturbo.card.query.vo.QueryContext;
import cn.nuturbo.card.query.vo.Return;
import cn.nuturbo.common.model.filtercondition.Condition;
import org.springframework.stereotype.Service;

/**
 * Created by penghs at 2023/11/22 13:10
 */
@Service
public class DefaultVertexQueryService implements VertexQueryService {

    private final ConditionResolver conditionResolver;
    private final ReturnResolver returnResolver;
    private final QueryBuilder queryBuilder;

    public DefaultVertexQueryService(ConditionResolver conditionResolver, ReturnResolver returnResolver, QueryBuilder queryBuilder) {
        this.conditionResolver = conditionResolver;
        this.returnResolver = returnResolver;
        this.queryBuilder = queryBuilder;
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
