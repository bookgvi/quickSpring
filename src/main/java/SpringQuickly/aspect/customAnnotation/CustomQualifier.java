package SpringQuickly.aspect.customAnnotation;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.enterprise.util.AnnotationLiteral;
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Documented
public @interface CustomQualifier {
    TimeUnit value() default TimeUnit.DAYS;
    public static final class Literal extends AnnotationLiteral<CustomQualifier> implements CustomQualifier {
        private static final long serialVersionUID = 1L;
        public static final Literal INSTANCE = of(TimeUnit.DAYS);
        private final TimeUnit value;
        public static Literal of(TimeUnit value) {
            return new Literal(value);
        }
        private Literal(TimeUnit value) {
            this.value = value;
        }
        public TimeUnit value() {
            return value;
        }
    }
}
