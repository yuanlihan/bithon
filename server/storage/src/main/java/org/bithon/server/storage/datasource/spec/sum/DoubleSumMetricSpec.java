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

package org.bithon.server.storage.datasource.spec.sum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bithon.server.storage.datasource.aggregator.DoubleSumAggregator;
import org.bithon.server.storage.datasource.aggregator.NumberAggregator;
import org.bithon.server.storage.datasource.typing.DoubleValueType;
import org.bithon.server.storage.datasource.typing.IValueType;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * @author frank.chen021@outlook.com
 * @date 2020/12/23
 */
public class DoubleSumMetricSpec extends SumMetricSpec {

    @JsonCreator
    public DoubleSumMetricSpec(@JsonProperty("name") @NotNull String name,
                               @JsonProperty("field") @Nullable String field,
                               @JsonProperty("displayText") @NotNull String displayText,
                               @JsonProperty("unit") @NotNull String unit,
                               @JsonProperty("visible") @Nullable Boolean visible) {
        super(name, field, displayText, unit, visible);
    }

    @JsonIgnore
    @Override
    public String getType() {
        return DOUBLE_SUM;
    }

    @Override
    public IValueType getValueType() {
        return DoubleValueType.INSTANCE;
    }

    @Override
    public NumberAggregator createAggregator() {
        return new DoubleSumAggregator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DoubleSumMetricSpec) {
            return this.name.equals(((DoubleSumMetricSpec) obj).name);
        } else {
            return false;
        }
    }
}
