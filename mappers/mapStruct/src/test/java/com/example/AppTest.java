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

    @Test
    public void test_simple_mapping2() {
        CarDto carDto = new CarDto("BMW", 4, "Red");

        Car car = mapper.carDtoToCar(carDto);

        assertEquals(car.getMake(), carDto.getManufacturer());
        assertEquals(car.getNumberOfSeats(), carDto.getSeatCount());
        assertEquals(car.getColor(), carDto.getColor());
        assertEquals(car.getSpeed(), 0);
    }
}
