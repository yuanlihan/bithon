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

package com.sbss.bithon.agent.core.utils;

import shaded.org.yaml.snakeyaml.Yaml;
import shaded.org.yaml.snakeyaml.constructor.Constructor;
import shaded.org.yaml.snakeyaml.representer.Representer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;

/**
 * @author frankchen
 */
public class YamlUtils {

    public static <T> T load(String yml,
                             Class<T> clazz) throws Exception {
        try (InputStream is = URLClassLoader.getSystemResourceAsStream(yml)) {
            if (is == null) {
                throw new FileNotFoundException(yml);
            }
            return new Yaml().loadAs(is, clazz);
        }
    }

    public static <T> T load(File yml,
                             Class<T> clazz) throws IOException {
        try (InputStream is = new FileInputStream(yml)) {
            Representer representer = new Representer();
            representer.getPropertyUtils().setSkipMissingProperties(true);
            return new Yaml(new Constructor(clazz), representer).loadAs(is, clazz);
        }
    }

    public static <T> T load(String yml,
                             Class<T> clazz,
                             ClassLoader classLoader) throws Exception {
        try (InputStream is = classLoader.getResourceAsStream(yml)) {
            if (is == null) {
                throw new FileNotFoundException(yml);
            }
            return new Yaml().loadAs(is, clazz);
        }
    }
}
