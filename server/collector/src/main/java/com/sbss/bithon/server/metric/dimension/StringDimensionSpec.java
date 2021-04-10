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

package com.sbss.bithon.server.metric.dimension;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sbss.bithon.server.metric.dimension.transformer.IDimensionTransformer;
import com.sbss.bithon.server.metric.typing.IValueType;
import com.sbss.bithon.server.metric.typing.StringValueType;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * @author frank.chen021@outlook.com
 * @date 2020/12/11 10:11 上午
 */
public class StringDimensionSpec extends AbstractDimensionSpec {

    @JsonCreator
    public StringDimensionSpec(@JsonProperty("name") @NotNull String name,
                               @JsonProperty("displayText") @NotNull String displayText,
                               @JsonProperty("isRequired") Boolean isRequired,
                               @JsonProperty("visible") Boolean visible,
                               @JsonProperty("transformer") @Nullable IDimensionTransformer transformer) {
        super(name, displayText, isRequired, visible, transformer);
    }

    @Override
    public IValueType getValueType() {
        return StringValueType.INSTANCE;
    }

    @Override
    public <T> T accept(IDimensionSpecVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
