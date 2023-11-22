package cn.nuturbo.query.model.condition;

import cn.nuturbo.common.origintype.Path;

/**
 * Created by penghs at 2023/11/22 11:48
 */
public non-sealed class ReferOnSelf implements ReferOn {

    private final Path path;

    public ReferOnSelf(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return path;
    }
}
