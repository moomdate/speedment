package com.speedment.plugins.json;

import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.field.*;
import com.speedment.runtime.typemapper.TypeMapper;

public interface User {

    IntField<User, Integer> ID = IntField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getId, User::setId, TypeMapper.primitive(), true);

    StringField<User, String> NAME = StringField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "name"), User::getName, User::setName, TypeMapper.identity(), false);

    ByteField<User, Byte> BYTE_FIELD = ByteField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getByte, User::setByte, TypeMapper.primitive(), false);
    ShortField<User, Short> SHORT_FIELD = ShortField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getShort, User::setShort, TypeMapper.primitive(), false);
    LongField<User, Long> LONG_FIELD = LongField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getLong, User::setLong, TypeMapper.primitive(), false);
    FloatField<User, Float> FLOAT_FIELD = FloatField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getFloat, User::setFloat, TypeMapper.primitive(), false);
    DoubleField<User, Double> DOUBLE_FIELD = DoubleField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getDouble, User::setDouble, TypeMapper.primitive(), false);
    CharField<User, Character> CHAR_FIELD = CharField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getChar, User::setChar, TypeMapper.primitive(), false);
    BooleanField<User, Boolean> BOOLEAN_FIELD = BooleanField.create(ColumnIdentifier.of("speedment_test","speedment_test", "user", "id"), User::getBoolean, User::setBoolean, TypeMapper.primitive(), false);

    int getId();

    User setId(int id);

    String getName();

    User setName(String name);

    byte getByte();

    User setByte(byte val);

    short getShort();

    User setShort(short val);

    long getLong();

    User setLong(long val);

    float getFloat();

    User setFloat(float val);

    double getDouble();

    User setDouble(double val);

    char getChar();

    User setChar(char val);

    boolean getBoolean();

    User setBoolean(boolean val);

}
