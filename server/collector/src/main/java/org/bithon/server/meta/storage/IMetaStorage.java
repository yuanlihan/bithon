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

package org.bithon.server.meta.storage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bithon.server.meta.Metadata;
import org.bithon.server.meta.MetadataType;

import java.util.Collection;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/31 9:49 上午
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface IMetaStorage {

    void saveApplicationInstance(String applicationName, String applicationType, String instance);

    Collection<Metadata> getMetadataByType(MetadataType type);

    /**
     * @param instanceName host+port
     */
    String getApplicationByInstance(String instanceName);

    boolean isApplicationExist(String applicationName);

    void initialize();
}
