package cn.nuturbo.query.model.condition;

import cn.nuturbo.common.origintype.Path;

/**
 * Created by penghs at 2023/11/22 11:47
 */
public non-sealed class ReferOnCurrentMember implements ReferOn {

    private final Path path;

    public ReferOnCurrentMember(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return path;
    }
}
