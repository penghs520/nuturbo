package cn.nuturbo.common.origintype;

/**
 * Created by penghs at 2023/11/21 15:45
 */
public abstract class SchemaId extends Identity {

    public SchemaId(String value) {
        super(value);
    }

    public abstract SchemaType schemaType();
}
