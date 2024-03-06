package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import cn.nuturbo.common.origintype.EnumItemId;
import lombok.Getter;

import java.util.List;

@Getter
public class EnumFieldValue extends CustomFieldValue {

    //支持多选，比如一个人扮演多个角色
    private final List<EnumItemId> value;

    public EnumFieldValue(CustomFieldId fieldId, List<EnumItemId> value) {
        super(fieldId);
        this.value = value;
    }

}
