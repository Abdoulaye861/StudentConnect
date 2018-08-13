package com.students.infrastructure.util;

import java.util.List;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@Component 
public class OrikaBeanMapper extends ConfigurableMapper { 
    private MapperFactory factory; 

    public OrikaBeanMapper() { 
        super(false); 
        init(); 
    } 

    private void registerClassMap(Class a, Class b) { 
        this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register(); 
    } 

    /** 
     * Register class map with fields to exclude 
     * 
     * @param a 
     * @param b 
     * @param excludeFields 
     */ 
    private void registerClassMap(Class a, Class b, String... excludeFields) { 
        ClassMapBuilder builder = this.factory.classMap(a, b); 
        for (String excludeField : excludeFields) { 
            builder.exclude(excludeField); 
        } 
        builder.mapNulls(true).mapNullsInReverse(true).byDefault().register(); 
    } 

    /** 
     * {@inheritDoc} 
     */ 
    @Override 
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) { 
        factoryBuilder.compilerStrategy(new JavassistCompilerStrategy()); 
    } 

    /** 
     * User Orika to convert entity => DTO / DTO => entity 
     * 
     * @param from 
     * @param toClass 
     * @param <T> 
     * @param <U>     return 
     */ 
    public <T, U> T convertDTO(U from, Class<T> toClass) { 

        if (from == null) { 
            return null; 
        } 

        return map(from, toClass); 
    } 

    /** 
     * User Orika to convert entity => DTO / DTO => entity 
     * 
     * @param from 
     * @param toClass 
     * @param <T> 
     * @param <U> 
     * @return 
     */ 
    public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) { 

        if (from == null) { 
            return null; 
        } 

        return mapAsList(from, toClass); 
    } 

} 