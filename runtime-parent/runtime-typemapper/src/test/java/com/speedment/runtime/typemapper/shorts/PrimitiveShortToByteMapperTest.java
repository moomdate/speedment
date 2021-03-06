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
package com.speedment.runtime.typemapper.shorts;

import com.speedment.runtime.typemapper.AbstractTypeMapperTest;

import java.util.HashMap;
import java.util.Map;

import static com.speedment.runtime.typemapper.TypeMapper.Category;
import static com.speedment.runtime.typemapper.TypeMapper.Ordering;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class PrimitiveShortToByteMapperTest extends AbstractTypeMapperTest<Short, Byte, PrimitiveShortToByteMapper> {


    PrimitiveShortToByteMapperTest() {
        super(
            Short.class,
            Byte.class,
            Category.BYTE,
            Ordering.RETAIN,
            PrimitiveShortToByteMapper::new);
    }

    @Override
    protected Map<Short, Byte> testVector() {
        Map<Short, Byte> map = new HashMap<>();
        map.put(Short.valueOf("0"), Byte.valueOf("0"));
        map.put(null, null);
        return map;
    }

    @Override
    protected void getJavaType() {
        assertEquals(byte.class, typeMapper().getJavaType(column()));
    }
}