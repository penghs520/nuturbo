package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.jdbc.support.SqlValue;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by penghs at 2023/11/21 15:32
 */
public abstract class Identity implements Serializable, SqlValue {

    private final String value;

    //for se/de
    protected Identity() {
        this.value = null;
    }

    public Identity(String value) {
        Asserts.notBlank(value, "Identity value can't be blank");
        this.checkFormat(value);
        this.value = value;
    }

    protected abstract void checkFormat(String id) throws IdentityFormattedException;

    @JsonValue
    public final String value() {
        return value;
    }

    public static String randomId() {
        return NanoID.random();
    }

    @Override
    public void setValue(PreparedStatement ps, int paramIndex) throws SQLException {
        ps.setString(paramIndex, this.value);
    }

    @Override
    public void cleanup() {

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof String str) {
            return Objects.equals(value, str);
        }
        //类型不一样，但value一样也认为是相等
        if (o instanceof Identity oid) {
            return Objects.equals(value, oid.value);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public final String toString() {
        return value;//toString如果不返回origin value，会有一定的风险，因为有些代码片段里会直接会拿Identity和字符串进行相加
    }

    public static class IdentityFormattedException extends RuntimeException {
        public IdentityFormattedException(String message) {
            super(message);
        }
    }
}
