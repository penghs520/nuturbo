package cn.nuturbo.common.origintype;

/**
 * Created by penghs at 2023/11/21 15:48
 */
public sealed interface FieldID permits CustomFieldID, InternalFieldID, RelatedFieldID {

}
