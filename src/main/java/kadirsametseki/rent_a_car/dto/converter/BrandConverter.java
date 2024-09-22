package kadirsametseki.rent_a_car.dto.converter;

import kadirsametseki.rent_a_car.dto.response.*;
import kadirsametseki.rent_a_car.dto.response.create.CreateBrandResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetAllBrandsResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetBrandResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateBrandResponse;
import kadirsametseki.rent_a_car.model.Brand;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BrandConverter {

    private final BrandModelConverter converter;

    public BrandConverter(BrandModelConverter converter) {
        this.converter = converter;
    }

    public CreateBrandResponse convertToCreateBrandResponse(Brand from) {
        return new CreateBrandResponse(
                from.getId(),
                from.getName());
    }

    public UpdateBrandResponse convertToUpdateBrandResponse(Brand from) {
        return new UpdateBrandResponse(from.getId(), from.getName());
    }

    public ModelBrandResponse convertToModelBrandResponse(Brand from) {
        if (from == null) {
            return new ModelBrandResponse(0L, "null");
        }
        return new ModelBrandResponse(from.getId(), from.getName());
    }

    public GetAllBrandsResponse convertToGetAllBrandsResponse(Brand from) {
        return new GetAllBrandsResponse(
                from.getId(),
                from.getName(),
                from.getModels()
                        .stream()
                        .map(converter::convertToBrandModelResponse)
                        .collect(Collectors.toList()));
    }

    public GetBrandResponse convertToGetBrandResponse(Brand from) {
        return new GetBrandResponse(
                from.getId(),
                from.getName(),
                from.getModels()
                        .stream()
                        .map(converter::convertToBrandModelResponse)
                        .collect(Collectors.toList()));
    }
}