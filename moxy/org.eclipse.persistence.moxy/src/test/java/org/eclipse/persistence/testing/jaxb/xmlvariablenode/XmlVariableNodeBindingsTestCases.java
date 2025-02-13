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
//     Denise Smith - May 2013
package org.eclipse.persistence.testing.jaxb.xmlvariablenode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XmlVariableNodeBindingsTestCases extends JAXBWithJSONTestCases{
     protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlvariablenode/root.xml";
        protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlvariablenode/root.json";
        protected final static String OXM_BINDINGS = "org/eclipse/persistence/testing/jaxb/xmlvariablenode/root-oxm.xml";


    public XmlVariableNodeBindingsTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        setClasses(new Class<?>[]{RootNoAnnotations.class});
    }

    @Override
     protected Map  getProperties(){
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(OXM_BINDINGS);

        HashMap<String, Source> metadataSourceMap = new HashMap<String, Source>();
        metadataSourceMap.put("org.eclipse.persistence.testing.jaxb.xmlvariablenode", new StreamSource(inputStream));
        Map<String, Map<String, Source>> properties = new HashMap<String, Map<String, Source>>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, metadataSourceMap);

        return properties;
    }

    @Override
    protected Object getControlObject() {
        RootNoAnnotations r = new RootNoAnnotations();
        r.name = "theRootName";
        r.things = new ArrayList<Thing>();
        Thing thing1 = new Thing();
        thing1.thingName = "thinga";
        thing1.thingValue = "thingavalue";

        Thing thing2 = new Thing();
        thing2.thingName = "thingb";
        thing2.thingValue = "thingbvalue";

        Thing thing3 = new Thing();
        thing3.thingName = "thingc";
        thing3.thingValue = "thingcvalue";
        r.things.add(thing1);
        r.things.add(thing2);
        r.things.add(thing3);
        return r;
    }

}
