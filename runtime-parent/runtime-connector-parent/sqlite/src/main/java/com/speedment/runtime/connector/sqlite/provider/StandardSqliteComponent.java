/*
 *
 * Copyright (c) 2006-2019, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.connector.sqlite.provider;

import com.speedment.common.injector.annotation.ExecuteBefore;
import com.speedment.common.injector.annotation.WithState;
import com.speedment.runtime.connector.sqlite.SqliteComponent;
import com.speedment.runtime.connector.sqlite.SqliteDbmsType;
import com.speedment.runtime.core.component.DbmsHandlerComponent;

import static com.speedment.common.injector.State.INITIALIZED;

/**
 * @author Emil Forslund
 * @since  3.1.10
 */
public final class StandardSqliteComponent implements SqliteComponent {

    @ExecuteBefore(INITIALIZED)
    public void onInitialize(
        final @WithState(INITIALIZED) DbmsHandlerComponent dbmsHandlerComponent,
        final @WithState(INITIALIZED) SqliteDbmsType sqliteDbmsType
    ) {
        dbmsHandlerComponent.install(sqliteDbmsType);
    }

}