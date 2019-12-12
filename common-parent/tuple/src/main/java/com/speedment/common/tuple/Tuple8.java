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
import com.speedment.common.tuple.getter.TupleGetter1;
import com.speedment.common.tuple.getter.TupleGetter2;
import com.speedment.common.tuple.getter.TupleGetter3;
import com.speedment.common.tuple.getter.TupleGetter4;
import com.speedment.common.tuple.getter.TupleGetter5;
import com.speedment.common.tuple.getter.TupleGetter6;
import com.speedment.common.tuple.getter.TupleGetter7;
import com.speedment.common.tuple.getter.TupleGetter;

/**
 * This interface defines a generic {@link Tuple} of degree 8 that can hold
 * non-null values. A Tuple is type safe, immutable and thread safe. For tuples
 * that can hold null elements see {@link TupleOfNullables}. For mutable tuples
 * see {@link MutableTuple} 
 * 
 * This {@link Tuple} has a degree of 8
 * <p>
 * Generated by com.speedment.sources.pattern.tuple.TuplePattern
 * 
 * @param <T0> type of element 0
 * @param <T1> type of element 1
 * @param <T2> type of element 2
 * @param <T3> type of element 3
 * @param <T4> type of element 4
 * @param <T5> type of element 5
 * @param <T6> type of element 6
 * @param <T7> type of element 7
 * 
 * @author Per Minborg
 * 
 * @see Tuple
 * @see TupleOfNullables
 * @see MutableTuple
 */
public interface Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> extends Tuple {
    
    /**
     * Returns the 0th element from this tuple.
     * 
     * @return the 0th element from this tuple.
     */
    T0 get0();
    
    /**
     * Returns the 1st element from this tuple.
     * 
     * @return the 1st element from this tuple.
     */
    T1 get1();
    
    /**
     * Returns the 2nd element from this tuple.
     * 
     * @return the 2nd element from this tuple.
     */
    T2 get2();
    
    /**
     * Returns the 3rd element from this tuple.
     * 
     * @return the 3rd element from this tuple.
     */
    T3 get3();
    
    /**
     * Returns the 4th element from this tuple.
     * 
     * @return the 4th element from this tuple.
     */
    T4 get4();
    
    /**
     * Returns the 5th element from this tuple.
     * 
     * @return the 5th element from this tuple.
     */
    T5 get5();
    
    /**
     * Returns the 6th element from this tuple.
     * 
     * @return the 6th element from this tuple.
     */
    T6 get6();
    
    /**
     * Returns the 7th element from this tuple.
     * 
     * @return the 7th element from this tuple.
     */
    T7 get7();
    
    @Override
    default int degree() {
        return 8;
    }
    
    default Object get(int index) {
        switch (index) {
            case 0 : return get0();
            case 1 : return get1();
            case 2 : return get2();
            case 3 : return get3();
            case 4 : return get4();
            case 5 : return get5();
            case 6 : return get6();
            case 7 : return get7();
            default : throw new IndexOutOfBoundsException(String.format("Index %d is outside bounds of tuple of degree %s", index, degree()));
        }
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 0th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 0th position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter0<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T0> getter0() {
        return Tuple8::get0;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 1st element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 1st position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter1<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T1> getter1() {
        return Tuple8::get1;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 2nd element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 2nd position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter2<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T2> getter2() {
        return Tuple8::get2;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 3rd element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 3rd position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter3<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T3> getter3() {
        return Tuple8::get3;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 4th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 4th position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter4<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T4> getter4() {
        return Tuple8::get4;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 5th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 5th position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter5<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T5> getter5() {
        return Tuple8::get5;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 6th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 6th position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter6<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T6> getter6() {
        return Tuple8::get6;
    }
    
    /**
     * Returns a {@link TupleGetter getter} for the 7th element in the {@code
     * Tuple}.
     * 
     * @return     the element at the 7th position
     * @param <T0> the 0th element type
     * @param <T1> the 1st element type
     * @param <T2> the 2nd element type
     * @param <T3> the 3rd element type
     * @param <T4> the 4th element type
     * @param <T5> the 5th element type
     * @param <T6> the 6th element type
     * @param <T7> the 7th element type
     */
    static <T0, T1, T2, T3, T4, T5, T6, T7> TupleGetter7<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>, T7> getter7() {
        return Tuple8::get7;
    }
}