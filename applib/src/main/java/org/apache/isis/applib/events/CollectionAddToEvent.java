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


package org.apache.isis.applib.events;

import org.apache.isis.applib.Identifier;


/**
 * Represents a check as to whether a particular object to be added to a collection is valid or not.
 * 
 * <p>
 * If {@link #getReason()} is not <tt>null</tt> then provides the reason why the object is invalid;
 * otherwise the object is valid.
 * 
 * @see CollectionRemoveFromEvent
 */
public class CollectionAddToEvent extends ValidityEvent {

    private static final long serialVersionUID = 1L;

    private final Object proposed;

    public CollectionAddToEvent(final Object source, final Identifier collectionIdentifier, final Object proposed) {
        super(source, collectionIdentifier);
        this.proposed = proposed;
    }

    /**
     * The object that is being added.
     * 
     * @return
     */
    public Object getProposed() {
        return proposed;
    }

}
