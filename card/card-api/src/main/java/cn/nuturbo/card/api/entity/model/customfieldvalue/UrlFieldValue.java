package cn.nuturbo.card.api.entity.model.customfieldvalue;

import cn.nuturbo.common.origintype.CustomFieldId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

@Getter
public class UrlFieldValue extends CustomFieldValue {

    //支持多选，比如一个人扮演多个角色
    private final Url value;

    public UrlFieldValue(CustomFieldId fieldId, Url value) {
        super(fieldId);
        this.value = value;
    }

    public record Url(String url, String name) {
        public Url(String url, String name) {
            this.url = Asserts.notBlank(url, "url is required");
            this.name = name;
        }
    }

}
