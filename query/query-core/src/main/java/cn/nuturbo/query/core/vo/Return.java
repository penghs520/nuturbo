package cn.nuturbo.query.core.vo;

import cn.nuturbo.common.origintype.FieldID;
import cn.nuturbo.common.origintype.Path;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

/**
 * Created by penghs at 2023/11/22 18:16
 */
@Getter
public class Return {

    private Set<FieldID> fields;

    private Map<Path, Set<FieldID>> fieldsOfRelatedVertex;

}
