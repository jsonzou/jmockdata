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
package com.github.jsonzou.jmockdata.mockdata;

/**
 * <p>模拟数据结果包装类</p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public abstract class JmockDataWrapper {
    private JmockDataContext jmockDataContext;

    public JmockDataContext getJmockDataContext() {
        return jmockDataContext;
    }

    public void setJmockDataContext(JmockDataContext jmockDataContext) {
        this.jmockDataContext = jmockDataContext;
    }
}
