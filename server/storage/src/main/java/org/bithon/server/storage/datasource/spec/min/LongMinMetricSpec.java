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

package org.bithon.server.storage.datasource.spec.min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bithon.server.storage.datasource.aggregator.LongMinAggregator;
import org.bithon.server.storage.datasource.aggregator.NumberAggregator;
import org.bithon.server.storage.datasource.spec.IMetricSpec;
import org.bithon.server.storage.datasource.typing.IValueType;
import org.bithon.server.storage.datasource.typing.LongValueType;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/3/16
 */
public class LongMinMetricSpec extends MinMetricSpec {

    @JsonCreator
    public LongMinMetricSpec(@JsonProperty("name") @NotNull String name,
                             @JsonProperty("field") @Nullable String field,
                             @JsonProperty("displayText") @NotNull String displayText,
                             @JsonProperty("unit") @NotNull String unit,
                             @JsonProperty("visible") @Nullable Boolean visible) {
        super(name, field, displayText, unit, visible);
    }

    @JsonIgnore
    @Override
    public String getType() {
        return IMetricSpec.LONG_MIN;
    }

    @Override
    public IValueType getValueType() {
        return LongValueType.INSTANCE;
    }

    @Override
    public NumberAggregator createAggregator() {
        return new LongMinAggregator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LongMinMetricSpec) {
            return this.name.equals(((LongMinMetricSpec) obj).name);
        } else {
            return false;
        }
    }
}
