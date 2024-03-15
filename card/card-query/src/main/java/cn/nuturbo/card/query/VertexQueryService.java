package cn.nuturbo.card.query;

import cn.nuturbo.card.query.vo.PageResult;
import cn.nuturbo.card.query.vo.Return;
import cn.nuturbo.common.model.filtercondition.Condition;
import cn.nuturbo.card.query.vo.QueryContext;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 12:33
 */
public interface VertexQueryService {

    PageResult pageQuery(QueryContext queryContext, Condition condition, Return rtn);

    Integer count(QueryContext queryContext, Condition condition);
}
