package cn.nuturbo.query.model.condition.operator;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.value.NullValue;
import cn.nuturbo.query.model.condition.value.NumberValue;
import cn.nuturbo.query.model.condition.value.Value;

/**
 * Created by penghs at 2023/11/22 11:52
 */
public non-sealed interface NumberOperator extends Operator {

    class GreaterThan implements NumberOperator {

        private final NumberValue value;

        public GreaterThan(NumberValue value) {
            this.value = Asserts.notNull(value, "value of GreaterThan operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class GreaterThanOrEqual implements NumberOperator {

        private final NumberValue value;

        public GreaterThanOrEqual(NumberValue value) {
            this.value = Asserts.notNull(value, "value of GreaterThanOrEqual operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class LessThan implements NumberOperator {

        private final NumberValue value;

        public LessThan(NumberValue value) {
            this.value = Asserts.notNull(value, "value of LessThan operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class LessThanOrEqual implements NumberOperator {

        private final NumberValue value;

        public LessThanOrEqual(NumberValue value) {
            this.value = Asserts.notNull(value, "value of LessThanOrEqual operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class Equal implements NumberOperator {

        private final NumberValue value;

        public Equal(NumberValue value) {
            this.value = Asserts.notNull(value, "value of Equal operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class NotEqual implements NumberOperator {

        private final NumberValue value;

        public NotEqual(NumberValue value) {
            this.value = Asserts.notNull(value, "value of NotEqual operator can not be null.");
        }

        @Override
        public Value getValue() {
            return value;
        }
    }

    class Between implements NumberOperator {

        private final NumberValue start;
        private final NumberValue end;

        public Between(NumberValue start, NumberValue end) {
            this.start = Asserts.notNull(start, "start of Between operator can not be null.");
            this.end = Asserts.notNull(end, "end of Between operator can not be null.");
        }

        @Override
        public NumberValue.Range getValue() {
            return new NumberValue.Range(start, end);
        }
    }

    class NotBetween implements NumberOperator {

        private final NumberValue start;
        private final NumberValue end;

        public NotBetween(NumberValue start, NumberValue end) {
            this.start = Asserts.notNull(start, "start of NotBetween operator can not be null.");
            this.end = Asserts.notNull(end, "end of NotBetween operator can not be null.");
        }

        @Override
        public NumberValue.Range getValue() {
            return new NumberValue.Range(start, end);
        }

    }

    class IsNull implements NumberOperator {

        @Override
        public NullValue getValue() {
            return NullValue.getInstance();
        }
    }

    class IsNotNull implements NumberOperator {

        @Override
        public NullValue getValue() {
            return NullValue.getInstance();
        }
    }
}
