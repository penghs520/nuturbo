package cn.nuturbo.query.model.condition.subject;

import cn.nuturbo.common.origintype.FieldID;
import cn.nuturbo.common.origintype.Path;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 12:00
 */
@Getter
public final class NumberSubject implements Subject {

    private final Path path;
    private final FieldID fieldID;
    private final String name;

    public NumberSubject(Path path, FieldID fieldID, String name) {
        this.path = path;
        this.fieldID = Asserts.notNull(fieldID, "fieldID of NumberSubject can not be null.");
        this.name = name;
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public String getName() {
        return name;
    }
}
