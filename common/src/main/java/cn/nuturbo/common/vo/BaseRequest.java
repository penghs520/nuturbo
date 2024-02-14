package cn.nuturbo.common.vo;

import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by penghs at 2024/2/14 6:21
 */
@Getter
public abstract class BaseRequest implements Serializable {

    private final MemberId memberId;

    protected BaseRequest(MemberId memberId) {
        this.memberId = Asserts.notNull(memberId, "memberId is required");
    }
}
