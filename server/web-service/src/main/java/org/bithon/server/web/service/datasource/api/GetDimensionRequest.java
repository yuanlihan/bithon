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

package org.bithon.server.web.service.datasource.api;

import lombok.Data;
import org.bithon.server.storage.metrics.IFilter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/3/7 5:29 下午
 */
@Data
public class GetDimensionRequest {

    @NotEmpty
    private String startTimeISO8601;

    @NotEmpty
    private String endTimeISO8601;

    @NotNull
    private String dataSource;

    @Valid
    private Collection<IFilter> filters = Collections.emptyList();

    /**
     * dimension name
     */
    @NotNull
    private String name;

    /**
     * Indicate the type of {@link #name}
     * name
     * alias
     */
    private String type = "name";
}
