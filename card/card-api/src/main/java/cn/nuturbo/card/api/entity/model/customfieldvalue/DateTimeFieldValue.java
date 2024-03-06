package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DateTimeFieldValue extends CustomFieldValue {

    private final LocalDateTime value;

    public DateTimeFieldValue(CustomFieldId fieldId, LocalDateTime value) {
        super(fieldId);
        this.value = value;
    }

}
