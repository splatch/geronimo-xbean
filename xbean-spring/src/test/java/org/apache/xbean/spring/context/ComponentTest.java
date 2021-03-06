/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.xbean.spring.context;

import junit.framework.TestCase;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;

import org.apache.xbean.test.support.example.ContainerBean;
import org.apache.xbean.test.support.example.InnerBean;

public class ComponentTest extends TestCase {

    protected void setUp() throws Exception {
        InnerBean.INSTANCE = null;
    }
    
    public void test1() {
        test("org/apache/xbean/spring/context/component-spring.xml");
    }

    public void test2() {
        test("org/apache/xbean/spring/context/component-xbean.xml");
    }
    
    protected void test(String file) {
        BeanFactory f = new ClassPathXmlApplicationContext(file);
        ContainerBean container = (ContainerBean) f.getBean("container");
        assertNotNull(container);
        assertNotNull(container.getBeans());
        assertEquals(1, container.getBeans().length);
    }

}
