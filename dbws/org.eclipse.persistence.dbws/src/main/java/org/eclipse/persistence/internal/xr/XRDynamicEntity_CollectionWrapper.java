/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     mnorman - convert DBWS to use new EclipseLink public Dynamic Persistence APIs
package org.eclipse.persistence.internal.xr;

//javase imports
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//EclipseLink imports

public class XRDynamicEntity_CollectionWrapper extends XRDynamicEntity implements Collection<Object> {

    static final String ITEMS_PROPERTY = "items";
    public static final XRDynamicPropertiesManager DPM = new XRDynamicPropertiesManager();
    static {
        Set<String> propertiesNameSet = new HashSet<>();
        propertiesNameSet.add(ITEMS_PROPERTY);
        DPM.setPropertyNames(propertiesNameSet);
    }

    public XRDynamicEntity_CollectionWrapper() {
        super();
        super.set(ITEMS_PROPERTY, new ArrayList<>());
    }

    @Override
    public XRDynamicPropertiesManager fetchPropertiesManager() {
        return DPM;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(Object e) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).add(e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends Object> c) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).addAll(c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).clear();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).contains(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(Collection<?> c) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).containsAll(c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isEmpty() {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<Object> iterator() {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).iterator();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).remove(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection<?> c) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).removeAll(c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> c) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).retainAll(c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int size() {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return ((Collection<Object>)propertiesMap.get(ITEMS_PROPERTY).getValue()).toArray(a);
    }
}
