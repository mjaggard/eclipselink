/*
 * Copyright (c) 1998, 2020 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.tests.queries.report;

import java.util.*;
import org.eclipse.persistence.expressions.*;
import org.eclipse.persistence.testing.models.employee.domain.*;
import org.eclipse.persistence.queries.*;

/**
 * ReportQuery test for Scenario 1.1
 * SELECT F_NAME, L_NAME FROM EMPLOYEE
 */
public class Scenario6_1 extends ReportQueryTestCase {
    public Scenario6_1() {
        setDescription("Place holder");
    }

    protected void buildExpectedResults() {
        ExpressionBuilder builder = new ExpressionBuilder();

        Vector employees = getSession().readAllObjects(Employee.class);

        for (Enumeration e = employees.elements(); e.hasMoreElements();) {
            Employee emp = (Employee)e.nextElement();
            Object[] result = new Object[3];
            result[0] = emp.getFirstName();
            result[1] = emp.getLastName();
            result[2] = null;
            addResult(result, null);
        }
    }
protected void setup()  throws Exception
{
        super.setup();
        reportQuery = new ReportQuery(new ExpressionBuilder());

        reportQuery.setReferenceClass(Employee.class);
        reportQuery.addAttribute("firstName");
        reportQuery.addAttribute("lastName");
        reportQuery.addAttribute("empty", null);
    }
}