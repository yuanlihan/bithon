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

package org.bithon.server.web.service.tracing.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

/**
 * @author frank.chen021@outlook.com
 * @date 25/11/21 3:05 pm
 */
@Data
@AllArgsConstructor
public class TraceTopo {

    @Data
    public static class Node {
        /**
         * node name
         */
        private final String name;
        private final String application;
        private final String instance;

        private int level;

        /**
         * node index in a level from one
         */
        private int nodeIndex;

        /**
         * node count of the level that this node belongs to
         */
        private int nodeCount;

        public Node(String name, String application, String instance) {
            this.name = name;
            this.application = application;
            this.instance = instance;
            this.level = 1;
        }
    }

    @Data
    public static class Link {
        private String source;
        private String target;

        public Link(String source, String target) {
            this.source = source;
            this.target = target;
        }

        private int count;

        public Link incrCount() {
            count++;
            return this;
        }
    }

    private Collection<Node> nodes;
    private Collection<Link> links;
    private int maxLevel;

    /**
     * max node count in a level
     */
    private int maxNodeCount;
}
