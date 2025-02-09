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


import org.eclipse.jnosql.communication.Settings;
import org.eclipse.jnosql.databases.arangodb.communication.ArangoDBDocumentConfiguration;
import org.eclipse.jnosql.databases.arangodb.communication.ArangoDBDocumentManagerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.util.function.Supplier;

enum DocumentDatabase implements Supplier<ArangoDBDocumentManagerFactory> {

    INSTANCE;

    private final GenericContainer arangodb =
            new GenericContainer("arangodb/arangodb:latest")
                    .withExposedPorts(8529)
                    .withEnv("ARANGO_NO_AUTH", "1")
                    .waitingFor(Wait.forHttp("/")
                            .forStatusCode(200));

    {
        arangodb.start();
    }

    @Override
    public ArangoDBDocumentManagerFactory get() {
        ArangoDBDocumentConfiguration configuration = new ArangoDBDocumentConfiguration();
        configuration.addHost(arangodb.getHost(), arangodb.getFirstMappedPort());
        return configuration.apply(Settings.builder().build());
    }
}
