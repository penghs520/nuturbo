package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import lombok.Getter;

@Getter
public class NumberFieldValue extends CustomFieldValue {

    private final Number value;

    public NumberFieldValue(CustomFieldId fieldId, Number value) {
        super(fieldId);
        this.value = value;
    }

}
