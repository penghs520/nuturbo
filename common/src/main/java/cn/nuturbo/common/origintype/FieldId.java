package cn.nuturbo.common.origintype;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by penghs at 2024/2/14 20:22
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "tag")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomFieldId.class, name = "CustomFieldId"),
        @JsonSubTypes.Type(value = InternalFieldId.class, name = "InternalFieldId"),
        @JsonSubTypes.Type(value = RelationFieldId.class, name = "RelationFieldId")
})
public sealed interface FieldId permits CustomFieldId, InternalFieldId, RelationFieldId {

}