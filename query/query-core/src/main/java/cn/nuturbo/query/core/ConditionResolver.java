package cn.nuturbo.query.core;

import cn.nuturbo.query.model.condition.Condition;
import org.springframework.stereotype.Component;

/**
 * Created by penghs at 2023/11/22 13:27
 */
@Component
public class ConditionResolver {

    public ResolvedCondition resolve(Condition condition) {
        return new ResolvedCondition(condition.ands(), condition.logics());
    }
}
