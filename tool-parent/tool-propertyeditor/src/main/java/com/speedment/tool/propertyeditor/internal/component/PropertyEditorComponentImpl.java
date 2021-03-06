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
package com.speedment.tool.propertyeditor.internal.component;

import com.speedment.common.injector.Injector;
import com.speedment.common.injector.annotation.ExecuteBefore;
import com.speedment.common.mapstream.MapStream;
import com.speedment.runtime.config.*;
import com.speedment.runtime.config.trait.*;
import com.speedment.tool.config.*;
import com.speedment.tool.config.trait.*;
import com.speedment.tool.propertyeditor.PropertyEditor;
import com.speedment.tool.propertyeditor.component.PropertyEditorComponent;
import com.speedment.tool.propertyeditor.editor.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.speedment.common.injector.State.INITIALIZED;
import static java.util.Objects.requireNonNull;

/**
 *
 * @author Simon Jonasson
 * @since  3.0.0
 */
public final class PropertyEditorComponentImpl implements PropertyEditorComponent {
    
    private final Map<Class<?>, Map<String, Supplier<PropertyEditor<?>>>> factoryMap; // Ordered based on insert
    private Injector injector;
    
    public PropertyEditorComponentImpl (){
        this.factoryMap = Collections.synchronizedMap(new LinkedHashMap<>());
    }

    @ExecuteBefore(INITIALIZED)
    public void setInjector(Injector injector) {
        this.injector = requireNonNull(injector);
    }

    @ExecuteBefore(INITIALIZED)
    public void installEditors() {
        install(HasEnabledProperty.class,    HasEnableUtil.ENABLED,    EnabledPropertyEditor::new);
        install(HasNameProperty.class,       HasNameUtil.NAME,          NamePropertyEditor::new);
        install(HasAliasProperty.class,      HasAliasUtil.ALIAS,        AliasPropertyEditor::new);
        install(HasNullableProperty.class,   HasNullableUtil.NULLABLE,  NullablePropertyEditor::new);
        install(HasOrderTypeProperty.class,  HasOrderTypeUtil.ORDER_TYPE, OrderTypePropertyEditor::new);
        install(ColumnProperty.class,        ColumnUtil.AUTO_INCREMENT, AutoIncrementPropertyEditor::new);
        install(HasTypeMapperProperty.class, HasTypeMapperUtil.TYPE_MAPPER, TypeMapperPropertyEditor::new);
        install(DbmsProperty.class,          DbmsUtil.TYPE_NAME,        DbmsTypePropertyEditor::new);
        install(DbmsProperty.class,          DbmsUtil.IP_ADDRESS,       IpAdressPropertyEditor::new);
        install(DbmsProperty.class,          DbmsUtil.PORT,             PortNumberEditor::new);
        install(DbmsProperty.class,          DbmsUtil.USERNAME,         UsernamePropertyEditor::new);
        install(DbmsProperty.class,          DbmsUtil.CONNECTION_URL,   ConnectionUrlPropertyEditor::new);
        install(IndexProperty.class,         IndexUtil.UNIQUE,          UniquePropertyEditor::new);
        install(ProjectProperty.class,       ProjectUtil.COMPANY_NAME,           CompanyNamePropertyEditor::new);
        install(ProjectProperty.class,       ProjectUtil.PACKAGE_LOCATION,       PackageLocationPropertyEditor::new);
        install(HasPackageNameProperty.class,   HasPackageNameUtil.PACKAGE_NAME,          PackageNameEditor::new);
        install(ForeignKeyColumnProperty.class, ForeignKeyColumnUtil.FOREIGN_COLUMN_NAME, ForeignKeyColumnEditor::new);
    }
    
    @Override
    public <DOC extends DocumentProperty> Stream<PropertyEditor.Item> getUiVisibleProperties(DOC document) {
        return MapStream.of(factoryMap)                                         // MapStream<Class, Map<String, Supplier<PropertyEditor>>>
            .filterKey(clazz -> clazz.isAssignableFrom(document.getClass()))    // MapStream<Class, Map<String, Supplier<PropertyEditor>>>
            .flatMapValue(m -> MapStream.of(m))                                 // MapStream<Class, Map.Entry<String, Supplier<PropertyEditor>>>
            .mapKey((clazz, entry) -> entry.getKey())                           // MapStream<String, Map.Entry<String, Supplier<PropertyEditor>>>
            .mapValue(Map.Entry::getValue)                                      // MapStream<String, Supplier<PropertyEditor>>
            .distinctKeys((a, b) -> b)                                          // If keys collide, keep newest
            .values()                                                           // Stream<Supplier<PropertyEditor>>
            .map(Supplier::get)                                                 // Stream<PropertyEditor>  (pre inject)
            .map(injector::inject)                                              // Stream<PropertyEditor>  (post inject)
            .map(factory -> {                                                   // Stream<PropertyEditor<DOC>>
                @SuppressWarnings("unchecked")
                final PropertyEditor<DOC> casted =
                    (PropertyEditor<DOC>) factory;
                return casted;
            })
            .flatMap(factory -> factory.fieldsFor(document));                   // Stream<PropertyEditor.Item>
    }

    @Override
    public <DOC extends DocumentProperty> void install(Class<DOC> documentType, String propertyKey, Supplier<PropertyEditor<DOC>> factory) {
        acquire(documentType).put(propertyKey, factory);
    }
    
    private <DOC extends DocumentProperty> Map<String, Supplier<PropertyEditor<DOC>>> acquire(Class<DOC> documentType){
        @SuppressWarnings("unchecked")
        final Map<String, Supplier<PropertyEditor<DOC>>> result = (Map<String, Supplier<PropertyEditor<DOC>>>) (Object)
            factoryMap.computeIfAbsent(
                documentType, 
                d -> Collections.synchronizedMap( new LinkedHashMap<>() )
            );
        return result;
    }
}
