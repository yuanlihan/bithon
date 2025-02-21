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

package org.bithon.server.commons;

import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author frank.chen021@outlook.com
 * @date 2022/12/1 20:56
 */
public class UrlUtils {
    public static Map<String, String> parseURLParameters(String uriText) {
        if (uriText == null) {
            return Collections.emptyMap();
        }

        URI uri;
        try {
            uri = new URI(uriText);
        } catch (URISyntaxException ignored) {
            return Collections.emptyMap();
        }

        String query = uri.getQuery();
        if (!StringUtils.hasText(query)) {
            return Collections.emptyMap();
        }

        Map<String, String> variables = new TreeMap<>();
        int fromIndex = 0;
        int toIndex = 0;
        while (toIndex != -1) {
            String name;
            String value;
            toIndex = query.indexOf('=', fromIndex);
            if (toIndex - fromIndex > 1) {
                name = query.substring(fromIndex, toIndex);
                fromIndex = toIndex + 1;
                toIndex = query.indexOf('&', fromIndex);
                if (toIndex == -1) {
                    value = query.substring(fromIndex);
                } else {
                    value = query.substring(fromIndex, toIndex);
                }
                variables.put(name, value);
                fromIndex = toIndex + 1;
            } else {
                fromIndex = query.indexOf('&', toIndex) + 1;
            }
        }
        return variables;
    }
}
