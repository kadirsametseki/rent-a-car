package kadirsametseki.rent_a_car.dto.converter;

import kadirsametseki.rent_a_car.dto.response.get.GetAllCarsResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateCarResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetCarResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateCarResponse;
import kadirsametseki.rent_a_car.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public GetAllCarsResponse convertToGetAllCarsResponse(Car from) {
        return new GetAllCarsResponse(
                from.getId(),
                from.getModelYear(),
                from.getPlate(),
                from.getState(),
                from.getDailyPrice());
    }

    public GetCarResponse convertToGetCarResponse(Car from) {
        return new GetCarResponse(
                from.getId(),
                from.getModel().getId(),
                from.getModelYear(),
                from.getPlate(),
                from.getState(),
                from.getDailyPrice(),
                from.getModel().getName(),
                from.getModel().getBrand().getName());
    }

    public CreateCarResponse convertToCreateCarResponse(Car from) {
        return new CreateCarResponse(
                from.getId(),
                from.getModel().getId(),
                from.getModelYear(),
                from.getPlate(),
                from.getState(),
                from.getDailyPrice());
    }

    public UpdateCarResponse convertToUpdateCarResponse(Car from) {
        return new UpdateCarResponse(
                from.getId(),
                from.getModel().getId(),
                from.getModelYear(),
                from.getPlate(),
                from.getState(),
                from.getDailyPrice());
    }
}