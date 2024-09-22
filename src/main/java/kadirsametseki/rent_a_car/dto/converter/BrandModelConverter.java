package kadirsametseki.rent_a_car.dto.converter;

import kadirsametseki.rent_a_car.dto.response.BrandModelResponse;
import kadirsametseki.rent_a_car.model.Model;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BrandModelConverter {

    private final CarConverter converter;

    public BrandModelConverter(CarConverter converter) {
        this.converter = converter;
    }

    public BrandModelResponse convertToBrandModelResponse(Model from) {
        return new BrandModelResponse(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getCars()
                        .stream()
                        .map(converter::convertToGetAllCarsResponse)
                        .collect(Collectors.toList()));
    }
}