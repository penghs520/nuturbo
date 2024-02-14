package cn.nuturbo.card.query.vo;

import cn.nuturbo.common.origintype.FieldId;
import cn.nuturbo.common.origintype.Path;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

/**
 * Created by penghs at 2023/11/22 18:16
 */
@Getter
public class Return {

    private Set<FieldId> fields;

    private Map<Path, Set<FieldId>> fieldsOfRelatedCard;

}
