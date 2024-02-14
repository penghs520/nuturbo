package cn.nuturbo.common.model.filtercondition.value;

import cn.nuturbo.common.model.filtercondition.ReferOn;
import cn.nuturbo.common.origintype.CustomFieldId;
import cn.nuturbo.common.utils.Asserts;
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
        private final CustomFieldId customFieldId;

        public ReferNumber(ReferOn referOn, CustomFieldId customFieldId) {
            this.referOn = Asserts.notNull(referOn, "referOn is required");
            this.customFieldId = Asserts.notNull(customFieldId, "customFieldId is required");
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
