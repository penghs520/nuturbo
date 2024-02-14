package cn.nuturbo.common.model.filtercondition.value;

import cn.nuturbo.common.origintype.FieldId;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.common.model.filtercondition.ReferOn;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 11:42
 */
public non-sealed interface NumberValue extends Value {

    class LiteralNumber implements NumberValue {

        private final Number value;

        public LiteralNumber(Number value) {
            this.value = value;
        }

        public Number getValue() {
            return value;
        }
    }

    @Getter
    class ReferNumber implements NumberValue {

        private final ReferOn referOn;
        private final FieldId fieldID;

        public ReferNumber(ReferOn referOn, FieldId fieldID) {
            this.referOn = Asserts.notNull(referOn, "referOn of ReferNumber can not be null.");
            this.fieldID = Asserts.notNull(fieldID, "fieldID of ReferNumber can not be null.");
        }
    }

    class Range implements NumberValue {

        private final NumberValue start;
        private final NumberValue end;

        public Range(NumberValue start, NumberValue end) {
            this.start = Asserts.notNull(start, "start of Range can not be null.");
            this.end = Asserts.notNull(end, "end of Range can not be null.");
            Asserts.isTrue(!(start instanceof Range) && !(end instanceof Range), "start and end of Range can not be Range.");
        }

        public final NumberValue getStart() {
            return start;
        }

        public final NumberValue getEnd() {
            return end;
        }
    }

}
