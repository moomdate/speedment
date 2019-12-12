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
package com.speedment.common.tuple;

import com.speedment.common.tuple.getter.TupleGetter0;
import com.speedment.common.tuple.getter.TupleGetter;

/**
 * This interface defines a generic {@link Tuple} of degree 1 that can hold
 * non-null values. A Tuple is type safe, immutable and thread safe. For tuples
 * that can hold null elements see {@link TupleOfNullables}. For mutable tuples
 * see {@link MutableTuple} 
 * 
 * This {@link Tuple} has a degree of 1
 * <p>
 * Generated by com.speedment.sources.pattern.tuple.TuplePattern
 * 
 * @param <T0> type of element 0
 * 
 * @author Per Minborg
 * 
 * @see Tuple
 * @see TupleOfNullables
 * @see MutableTuple
 */
public interface Tuple1<T0> extends Tuple {
    
    /**
     * Returns the 0th element from this tuple.
     * 
     * @return the 0th element from this tuple.
     */
    T0 get0();
    
    @Override
    default int degree() {
        return 1;
    }
    
    default Object get(int index) {
        if (index == 0) {
            return get0();
        } else {
            throw new IndexOutOfBoundsException(String.format("Index %d is outside bounds of tuple of degree %s", index, degree()));
        }
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 0th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 0th position
     * @param <T0> the 0th element type
     */
    static <T0> TupleGetter0<Tuple1<T0>, T0> getter0() {
        return Tuple1::get0;
    }
}