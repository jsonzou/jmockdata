/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jsonzou.jmockdata.utils;

import java.lang.reflect.Array;

/**
 * Created by jsonzou on 2016/12/18.
 */
public class MockUtil {
    public static <T> T[] mockArray(Class<T> componeType, int minLen, int maxLen) {
        Integer len = RandomUtil.randomIntegerNotZero(maxLen);
        Object mockDataArr = Array.newInstance(componeType, len);

        return (T[]) mockDataArr;
    }
}
