package cn.nuturbo.common.origintype;

/**
 * Created by penghs at 2023/11/21 15:48
 */
public sealed interface FieldId permits CustomFieldId, InternalFieldId, RelationFieldId {

}
