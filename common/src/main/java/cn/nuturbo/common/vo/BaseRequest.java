package cn.nuturbo.common.vo;

import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/14 6:21
 */
@Getter
public abstract class BaseRequest {

    private final MemberId memberId;

    protected BaseRequest(MemberId memberId) {
        this.memberId = Asserts.notNull(memberId, "memberId is required");
    }
}
