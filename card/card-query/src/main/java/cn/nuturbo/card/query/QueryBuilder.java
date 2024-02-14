package cn.nuturbo.card.query;

import cn.nuturbo.card.query.bo.ResolvedCondition;
import cn.nuturbo.card.query.bo.ResolvedReturn;
import cn.nuturbo.card.query.vo.QueryContext;
import org.springframework.stereotype.Component;

/**
 * Created by penghs at 2023/11/22 13:10
 */
@Component
public class QueryBuilder {


    public String buildQuery(QueryContext queryContext, ResolvedCondition condition, ResolvedReturn resolvedReturn) {
        return null;
    }

    static class Builder {

        private final StringBuilder query = new StringBuilder();

        private Builder(String match) {
            query.append(match).append(" ");
        }

        /**
         * @param match MATCH (n)
         */
        public static Builder startByMatch(String match) {
            return new Builder(match);
        }

        public Builder another(Builder builder) {
            query.append("\n").append(builder.build()).append("\n");
            return this;
        }

        /**
         * @param where WHERE n.name = '张三'
         */
        public Builder where(String where) {
            query.append(where).append(" ");
            return this;
        }

        /**
         * @param with WITH n
         */
        public Builder with(String with) {
            query.append(with).append(" ");
            return this;
        }

        /**
         * @param returnStr RETURN n
         */
        public Builder return_(String returnStr) {
            query.append(returnStr).append(" ");
            return this;
        }

        /**
         * @param orderBy ORDER BY n.name DESC
         */
        public Builder orderBy(String orderBy) {
            query.append(orderBy).append(" ");
            return this;
        }

        public Builder skipAndLimit(int skip, int limit) {
            query.append("SKIP ").append(skip).append(" LIMIT ").append(limit).append(" ");
            return this;
        }

        public String build() {
            return query.toString();
        }
    }


    public static void main(String[] args) {
        String cypher = Builder.startByMatch("MATCH (n)")
                .where("WHERE n.name = '张三'")
                .with("WITH n")
                .another(Builder.startByMatch("MATCH (m)").where("WHERE m.name = '李四'").with("WITH n,m"))
                .return_("RETURN n")
                .orderBy("ORDER BY n.name DESC")
                .skipAndLimit(0, 10)
                .build();
        System.out.println(cypher);
    }
}
