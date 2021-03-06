/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.isis.viewer.restfulobjects.applib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import org.junit.Test;

import static org.apache.isis.viewer.restfulobjects.applib.JsonFixture.readJson;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class JsonRepresentationTest_mapIterable {

    private JsonRepresentation jsonRepresentation;

    @Test
    public void forJsonRepresentation() throws IOException {
        jsonRepresentation = new JsonRepresentation(readJson("map.json"));
        final Iterable<Entry<String, JsonRepresentation>> mapIterable = jsonRepresentation.mapIterable();
        final Iterator<Entry<String, JsonRepresentation>> mapIterator = mapIterable.iterator();

        for (int i = 0; i < jsonRepresentation.asJsonNode().size(); i++) {
            assertThat(mapIterator.hasNext(), is(true));
            assertThat(mapIterator.next().getKey(), is(not(nullValue())));
        }
        assertThat(mapIterator.hasNext(), is(false));
    }

}
