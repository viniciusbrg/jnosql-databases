/*
 *  Copyright (c) 2022 Contributors to the Eclipse Foundation
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.eclipse.jnosql.databases.arangodb.communication;

import java.util.Map;

class AQLQueryResult {
    private final String query;

    private final Map<String, Object> values;

    public AQLQueryResult(String query, Map<String, Object> values) {
        this.query = query;
        this.values = values;
    }

    public String getQuery() {
        return query;
    }

    public Map<String, Object> getValues() {
        return values;
    }


}
