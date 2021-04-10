/*
 *    Copyright 2020 bithon.cn
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

package com.sbss.bithon.server.metric.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sbss.bithon.server.metric.input.InputRow;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.function.Function;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/14
 */
public class EndwithFilter implements IFilter {
    @Getter
    @NotNull
    private final String field;

    @Getter
    @NotNull
    private final Object suffix;

    private final Function<String, Boolean> shouldIncludeExpr;

    public EndwithFilter(@JsonProperty("field") String field,
                         @JsonProperty("suffix") @NotNull Object suffix) {
        this.field = field;
        this.suffix = suffix;

        if (suffix instanceof String) {
            shouldIncludeExpr = inputString -> inputString.endsWith((String) suffix);
        } else if (suffix instanceof Collection) {
            Collection<?> suffixList = (Collection<?>) suffix;
            shouldIncludeExpr = inputString -> {
                for (Object s : suffixList) {
                    if (inputString.endsWith(s.toString())) {
                        return true;
                    }
                }
                return false;
            };
        } else {
            shouldIncludeExpr = inputString -> false;
        }
    }

    @Override
    public boolean shouldInclude(InputRow inputRow) {
        Object val = inputRow.getCol(this.field);
        if (val == null) {
            return false;
        }
        return shouldIncludeExpr.apply(val.toString());
    }
}
