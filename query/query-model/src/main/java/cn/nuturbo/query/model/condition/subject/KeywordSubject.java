package cn.nuturbo.query.model.condition.subject;

import cn.nuturbo.common.origintype.Path;
import cn.nuturbo.query.model.condition.subject.Subject;

/**
 * Created by penghs at 2023/11/22 11:20
 */
public final class KeywordSubject implements Subject {

    @Override
    public Path getPath() {
        return null;
    }

    @Override
    public String getName() {
        return "关键字过滤";
    }
}
