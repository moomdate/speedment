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

package com.speedment.runtime.core.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.function.Supplier;

final class SqlSupplierTest {

    @ParameterizedTest
    @ValueSource(strings = "test")
    void wrap(String input) throws SQLException {
        assertThrows(NullPointerException.class, () -> SqlSupplier.wrap(null));

        Supplier<String> supplier = () -> input;
        SqlSupplier<String> sqlSupplier = SqlSupplier.wrap(supplier);

        assertNotNull(sqlSupplier);
        assertEquals(input, sqlSupplier.get());
    }
}
