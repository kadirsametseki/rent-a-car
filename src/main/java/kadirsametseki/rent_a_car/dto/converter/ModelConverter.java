package kadirsametseki.rent_a_car.dto.converter;

import kadirsametseki.rent_a_car.dto.response.create.CreateModelResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetAllModelsResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetModelResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateModelResponse;
import kadirsametseki.rent_a_car.model.Model;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ModelConverter {

    private final BrandConverter brandConverter;
    private final CarConverter carConverter;

    public ModelConverter(BrandConverter brandConverter, CarConverter carConverter) {
        this.brandConverter = brandConverter;
        this.carConverter = carConverter;
    }

    public GetAllModelsResponse convertToGetAllModelsResponse(Model from) {
        return new GetAllModelsResponse(
                from.getId(),
                from.getName(),
                brandConverter.convertToModelBrandResponse(from.getBrand()),
                from.getCars()
                        .stream()
                        .map(carConverter::convertToGetAllCarsResponse)
                        .collect(Collectors.toList()));
    }

    public GetModelResponse convertToGetModelResponse(Model from) {
        return new GetModelResponse(
                from.getId(),
                from.getName(),
                brandConverter.convertToModelBrandResponse(from.getBrand()),
                from.getCars()
                        .stream()
                        .map(carConverter::convertToGetCarResponse)
                        .collect(Collectors.toList()));
    }

    public CreateModelResponse convertToCreateModelResponse(Model from) {
        return new CreateModelResponse(
                from.getId(),
                from.getBrand().getId(),
                from.getName());
    }

    public UpdateModelResponse convertToUpdateModelResponse(Model from) {
        return new UpdateModelResponse(
                from.getId(),
                from.getBrand().getId(),
                from.getName());
    }


}