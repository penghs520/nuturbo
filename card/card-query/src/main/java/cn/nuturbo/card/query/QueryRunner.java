package cn.nuturbo.card.query;

import cn.nuturbo.common.model.Card;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by penghs at 2023/11/22 13:16
 */
@Component
public class QueryRunner {

    public List<Card> runQuery(String query) {
        return Collections.emptyList();
    }
}
