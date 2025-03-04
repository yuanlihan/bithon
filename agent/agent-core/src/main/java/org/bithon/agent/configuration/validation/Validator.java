/*
 *    Copyright 2020 bithon.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.bithon.agent.configuration.validation;

import org.bithon.agent.configuration.ConfigurationProperties;
import org.bithon.component.commons.utils.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/8/7 10:37
 */
public class Validator {
    public static String validate(Object obj) {

        Map<Class<? extends Annotation>, IValueValidator> validators = new HashMap<Class<? extends Annotation>, IValueValidator>() {{
            put(NotBlank.class, new NotBlankValidator());
            put(Range.class, new RangeValidator());
            put(GreaterThan.class, new GreaterThanValidator());
        }};

        for (Field field : obj.getClass().getDeclaredFields()) {
            for (Map.Entry<Class<? extends Annotation>, IValueValidator> entry : validators.entrySet()) {
                Class<? extends Annotation> annotation = entry.getKey();
                IValueValidator validator = entry.getValue();

                String violation = validateField(obj, field, annotation, validator);
                if (violation != null) {
                    return violation;
                }
            }

        }
        return null;
    }

    private static <T extends Annotation> String validateField(Object object,
                                                               Field field,
                                                               Class<T> validationAnnotation,
                                                               IValueValidator valueValidator) {
        Annotation declaredValidationAnnotation = field.getAnnotation(validationAnnotation);
        if (declaredValidationAnnotation == null) {
            return null;
        }

        String violationMessagePattern;
        try {
            // although this function would be called twice if this field has more than 1 validation annotations
            // by putting this call here, we prevent this call on fields with some types that we don't support
            // this prevents following warning/error when using JDK9+
            // WARNING: An illegal reflective access operation has occurred
            field.setAccessible(true);


            violationMessagePattern = valueValidator.validate(declaredValidationAnnotation,
                                                              field.getType(),
                                                              field.get(object));
            if (violationMessagePattern == null) {
                return null;
            }
        } catch (IllegalAccessException ignored) {
            return null;
        }

        // get field name or configuration property name
        String name;
        ConfigurationProperties cfgAnnotation = object.getClass().getAnnotation(ConfigurationProperties.class);
        if (cfgAnnotation != null) {
            name = cfgAnnotation.prefix() + "." + field.getName();
        } else {
            name = field.getName();
        }

        return String.format(Locale.ENGLISH, violationMessagePattern, name);
    }

    interface IValueValidator {
        /**
         * @return violation message pattern
         */
        String validate(Annotation annotation, Class<?> objectType, Object value);
    }

    static class NotBlankValidator implements IValueValidator {
        @Override
        public String validate(Annotation annotation, Class<?> objectType, Object value) {
            if (objectType.equals(String.class)) {
                if (StringUtils.hasText((String) value)) {
                    // success
                    return null;
                } else {
                    return ((NotBlank) annotation).message();
                }
            }
            return null;
        }
    }

    static class RangeValidator implements IValueValidator {
        @Override
        public String validate(Annotation annotation, Class<?> objectType, Object value) {
            if (value instanceof Number) {
                long v = ((Number) value).longValue();
                long min = ((Range) annotation).min();
                long max = ((Range) annotation).max();
                if (v >= min && v <= max) {
                    return null;
                }
                return "%s " + String.format(Locale.ENGLISH, "should be in the range of [%d, %d], but is %d", min, max, v);
            }
            return "Type of [%s] is not Number, but " + objectType.getSimpleName();
        }
    }

    static class GreaterThanValidator implements IValueValidator {
        @Override
        public String validate(Annotation annotation, Class<?> objectType, Object value) {
            if (value instanceof Number) {
                long input = ((Number) value).longValue();
                long constraint = ((GreaterThan) annotation).value();
                if (input > constraint) {
                    return null;
                }
                return "%s " + String.format(Locale.ENGLISH, "should be greater than [%d], but is %d", input, constraint);
            }
            return "Type of [%s] is not Number, but " + objectType.getSimpleName();
        }
    }
}
