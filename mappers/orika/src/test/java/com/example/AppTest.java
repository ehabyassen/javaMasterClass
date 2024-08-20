package com.example;

import com.example.beans.Destination;
import com.example.beans.Source;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://orika-mapper.github.io/orika-docs/index.html
public class AppTest {

    private MapperFactory mapperFactory;

    @Before
    public void setup() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Source.class, Destination.class) //creates a new ClassMapBuilder
                .field("name", "givenName") //registers custom fields mappings
                .byDefault() //to map fields with the same names from src and destination classes
                .register(); //registers the mapping with the MapperFactory
    }

    @Test
    public void test_forward_mapping_with_default_mapper() {
        Source source = new Source("John", 30);
        MapperFacade mapper = mapperFactory.getMapperFacade();

        //DTO newDTO = mapperFacade.map(entity, DTO.class);
        Destination destination = mapper.map(source, Destination.class);

        assertEquals(destination.getGivenName(), source.getName());
        assertEquals(destination.getAge(), source.getAge());
    }

    @Test
    public void test_forward_mapping_with_bound_mapper() {
        Source source = new Source("Maria", 25);
        BoundMapperFacade<Source, Destination> mapper = mapperFactory.getMapperFacade(Source.class, Destination.class);

        Destination destination = mapper.map(source);

        assertEquals(destination.getGivenName(), source.getName());
        assertEquals(destination.getAge(), source.getAge());
    }

    @Test
    public void test_reverse_mapping_with_bound_mapper() {
        Destination destination = new Destination("Marko", 40);
        BoundMapperFacade<Source, Destination> mapper = mapperFactory.getMapperFacade(Source.class, Destination.class);

        Source source = mapper.mapReverse(destination);

        assertEquals(source.getName(), destination.getGivenName());
        assertEquals(source.getAge(), destination.getAge());
    }
}
