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

package com.sbss.bithon.agent.core.plugin.debug;


import com.sbss.bithon.agent.core.context.AgentContext;
import shaded.net.bytebuddy.agent.builder.AgentBuilder;
import shaded.net.bytebuddy.description.type.TypeDescription;
import shaded.net.bytebuddy.dynamic.DynamicType;
import shaded.net.bytebuddy.utility.JavaModule;
import shaded.org.slf4j.Logger;
import shaded.org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import static java.io.File.separator;

/**
 * @author frankchen
 */
public class TransformationDebugger extends AgentBuilder.Listener.Adapter {
    private static final Logger log = LoggerFactory.getLogger(TransformationDebugger.class);

    private boolean cleaned = false;
    private final File classRootPath;

    public TransformationDebugger() {
        this.classRootPath = new File(AgentContext.getInstance().getAgentDirectory()
                                      + separator
                                      + AgentContext.TMP_DIR
                                      + separator
                                      + "classes");

        // clean up directory before startup
        // this is convenient for debugging
        cleanup();

        try {
            if (!classRootPath.exists()) {
                classRootPath.mkdir();
            }
        } catch (Exception e) {
            log.error("log error", e);
        }
    }

    public synchronized void saveClassToFile(DynamicType dynamicType) {
        try {
            log.info("[{}] Saved to [{}]", dynamicType.getTypeDescription().getTypeName(), classRootPath);
            dynamicType.saveIn(classRootPath);
        } catch (Throwable e) {
            log.warn("Failed to save class {} to file." + dynamicType.getTypeDescription().getActualName(), e);
        }
    }

    @Override
    public void onTransformation(TypeDescription typeDescription,
                                 ClassLoader classLoader,
                                 JavaModule javaModule,
                                 boolean loaded, DynamicType dynamicType) {
        log.info("{} Transformed", typeDescription.getTypeName());
        saveClassToFile(dynamicType);
    }

    @Override
    public void onError(String s,
                        ClassLoader classLoader,
                        JavaModule javaModule,
                        boolean b,
                        Throwable throwable) {
        log.error(String.format("Failed to transform %s", s), throwable);
    }

    private synchronized void cleanup() {
        if (cleaned) {
            return;
        }

        try {
            Files.walk(classRootPath.toPath())
                 .sorted(Comparator.reverseOrder())
                 .map(Path::toFile)
                 .forEach(File::delete);
        } catch (IOException ignored) {
        }
        cleaned = true;
    }
}
