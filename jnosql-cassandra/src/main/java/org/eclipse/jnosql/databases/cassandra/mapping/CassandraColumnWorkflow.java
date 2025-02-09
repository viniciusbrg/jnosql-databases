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
package org.eclipse.jnosql.databases.cassandra.mapping;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Typed;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.column.ColumnEntityConverter;
import org.eclipse.jnosql.mapping.column.ColumnEventPersistManager;
import org.eclipse.jnosql.mapping.column.ColumnWorkflow;

@Typed(CassandraColumnWorkflow.class)
@ApplicationScoped
class CassandraColumnWorkflow extends ColumnWorkflow {

    @Inject
    private ColumnEventPersistManager columnEventPersistManager;

    @Inject
    private CassandraColumnEntityConverter converter;


    @Override
    protected ColumnEventPersistManager getEventManager() {
        return columnEventPersistManager;
    }

    @Override
    protected ColumnEntityConverter getConverter() {
        return converter;
    }
}
