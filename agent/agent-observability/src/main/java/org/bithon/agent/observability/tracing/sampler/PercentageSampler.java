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

package org.bithon.agent.observability.tracing.sampler;

import org.bithon.agent.observability.tracing.config.TraceSamplingConfig;
import org.bithon.agent.observability.utils.lang.MathUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A global sampling decision maker based on requests
 *
 * @author frank.chen021@outlook.com
 * @date 2021/2/9 10:55 下午
 */
public class PercentageSampler implements ISampler {
    private final AtomicLong counter = new AtomicLong();
    private final TraceSamplingConfig samplingConfig;

    /**
     * Holding SamplingConfig object so that it supports dynamic configuration
     *
     * @param samplingConfig [1, 100]
     */
    public PercentageSampler(TraceSamplingConfig samplingConfig) {
        this.samplingConfig = samplingConfig;
    }

    @Override
    public SamplingMode decideSamplingMode(Object request) {
        int samplingRate = samplingConfig.getSamplingRate();

        if (samplingRate <= 0) {
            return SamplingMode.NONE;
        }
        if (samplingRate >= 100) {
            return SamplingMode.FULL;
        }

        long reminder = MathUtils.floorMod(counter.addAndGet(samplingRate), 100);
        return reminder > 0 && reminder <= samplingRate ? SamplingMode.FULL : SamplingMode.NONE;
    }
}
