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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bithon.server.storage.metrics.IFilter;
import org.bithon.server.web.service.datasource.api.impl.QueryAggregator;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/30 8:20 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSeriesQueryRequest {
    @Valid
    @NotNull
    private IntervalRequest interval;

    @NotEmpty
    private String dataSource;

    private List<IFilter> filters;
    private List<String> metrics;
    private List<QueryAggregator> aggregators;

    private List<String> groupBy;
}
