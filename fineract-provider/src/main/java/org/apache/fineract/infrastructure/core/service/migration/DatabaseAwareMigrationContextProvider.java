/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.infrastructure.core.service.migration;

import static org.apache.fineract.infrastructure.core.domain.FineractPlatformTenantConnection.toProtocol;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAwareMigrationContextProvider {
    private final Map<String, String> contextMapping = Map.of(
            "jdbc:mariadb", "mysql",
            "jdbc:mysql", "mysql",
            "jdbc:postgresql", "postgresql"
    );

    public String provide(DataSource dataSource) {
        String protocol = toProtocol(dataSource);
        String context = contextMapping.get(protocol);
        if (context == null) {
            throw new IllegalStateException("Database is not supported");
        }
        return context;
    }
}
