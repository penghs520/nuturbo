package cn.nuturbo.common.vo;

import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2024/2/15 6:41
 */
public record Operator(MemberId memberId, OrgId orgId, String username) {
    @JsonCreator
    public Operator(@JsonProperty("memberId") MemberId memberId, @JsonProperty("orgId") OrgId orgId, @JsonProperty("username") String username) {
        this.memberId = Asserts.notNull(memberId, "memberId is required");
        this.orgId = Asserts.notNull(orgId, "orgId is required");
        this.username = Asserts.notNull(username, "username is required");
    }
}
