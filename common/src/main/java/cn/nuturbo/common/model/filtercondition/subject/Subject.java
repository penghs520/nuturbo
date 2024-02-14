package cn.nuturbo.common.model.filtercondition.subject;

import cn.nuturbo.common.origintype.Path;

/**
 * Created by penghs at 2023/11/22 11:07
 */
public sealed interface Subject permits KeywordSubject, NumberSubject {

    Path getPath();

    String getName();

}
