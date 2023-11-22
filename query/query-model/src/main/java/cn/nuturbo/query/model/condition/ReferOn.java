package cn.nuturbo.query.model.condition;

import cn.nuturbo.common.origintype.Path;

/**
 * Created by penghs at 2023/11/22 11:46
 */
public sealed interface ReferOn
        permits ReferOnSelf, ReferOnCurrentMember {

    Path path();

}
