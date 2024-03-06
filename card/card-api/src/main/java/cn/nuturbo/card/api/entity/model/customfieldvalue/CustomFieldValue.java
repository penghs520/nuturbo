package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/21 17:56
 */
@Getter
public abstract class CustomFieldValue {

    private final CustomFieldId fieldId;

    protected CustomFieldValue(CustomFieldId fieldId) {
        this.fieldId = Asserts.notNull(fieldId, "fieldId is required");
    }
}
