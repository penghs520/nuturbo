package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DateFieldValue extends CustomFieldValue {

    private final LocalDate value;

    public DateFieldValue(CustomFieldId fieldId, LocalDate value) {
        super(fieldId);
        this.value = value;
    }

}
