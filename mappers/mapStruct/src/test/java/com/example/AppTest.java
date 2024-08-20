package com.example;

import com.example.dto.CarDto;
import com.example.entity.Car;
import com.example.mapper.CarMapper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private CarMapper mapper;

    @Before
    public void setup() {
        mapper = Mappers.getMapper(CarMapper.class);
    }

    @Test
    public void test_simple_mapping() {
        Car car = new Car("BMW", 4, "Red", 280);

        CarDto carDto = mapper.carToCarDto(car);

        assertEquals(carDto.getManufacturer(), car.getMake());
        assertEquals(carDto.getSeatCount(), car.getNumberOfSeats());
        assertEquals(carDto.getColor(), car.getColor());
    }
}
