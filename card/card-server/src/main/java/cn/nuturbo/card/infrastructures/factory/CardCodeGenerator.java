package cn.nuturbo.card.infrastructures.factory;

import cn.nuturbo.common.origintype.OrgId;
import org.springframework.stereotype.Service;

/**
 * Created by penghs at 2024/2/14 15:23
 */
@Service
public class CardCodeGenerator {

    public String newCode(OrgId orgId) {
        return "card-" + System.currentTimeMillis();//TODO
    }
}
