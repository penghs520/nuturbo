package cn.nuturbo.query.core;

import cn.nuturbo.common.entity.Vertex;
import cn.nuturbo.query.model.condition.Condition;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 12:33
 */
public interface VertexQueryService {

    List<Vertex> query(QueryContext queryContext, Condition condition);

    PageResult pageQuery(QueryContext queryContext, Condition condition);

    Integer count(QueryContext queryContext, Condition condition);
}
