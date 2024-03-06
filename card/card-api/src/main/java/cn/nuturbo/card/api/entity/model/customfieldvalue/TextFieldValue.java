package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import lombok.Getter;

@Getter
public class TextFieldValue extends CustomFieldValue {

    private final String value;

    public TextFieldValue(CustomFieldId fieldId, String value) {
        super(fieldId);
        this.value = value;
    }

}
