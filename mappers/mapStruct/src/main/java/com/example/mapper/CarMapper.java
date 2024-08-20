package com.example.mapper;

import com.example.dto.CarDto;
import com.example.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//causes the MapStruct code generator to create an implementation of the CarMapper interface during build-time.
@Mapper
public interface CarMapper {

    /*
        In the generated method implementations all readable properties from the source type (e.g. Car) will be copied
        into the corresponding property in the target type (e.g. CarDto)

        When a property has the same name as its target entity counterpart, it will be mapped implicitly

        When a property has a different name in the target entity, its name can be specified via the @Mapping annotation
     */

    @Mapping(target = "manufacturer", source = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    CarDto carToCarDto(Car car);
}
