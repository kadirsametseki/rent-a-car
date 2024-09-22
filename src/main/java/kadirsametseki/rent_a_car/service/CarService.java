package kadirsametseki.rent_a_car.service;

import kadirsametseki.rent_a_car.dto.converter.CarConverter;
import kadirsametseki.rent_a_car.dto.request.create.CreateCarRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateCarRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllCarsResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateCarResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetCarResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateCarResponse;
import kadirsametseki.rent_a_car.model.Car;
import kadirsametseki.rent_a_car.model.Model;
import kadirsametseki.rent_a_car.model.StateType;
import kadirsametseki.rent_a_car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final ModelService modelService;
    private final CarConverter carConverter;

    public CarService(CarRepository carRepository,
                      ModelService modelService,
                      CarConverter carConverter) {
        this.carRepository = carRepository;
        this.modelService = modelService;
        this.carConverter = carConverter;
    }

    public List<GetAllCarsResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carConverter::convertToGetAllCarsResponse)
                .collect(Collectors.toList());
    }

    public GetCarResponse getBrandById(Long id) {
        return carConverter.convertToGetCarResponse(findCarIfExistsById(id));
    }

    public CreateCarResponse createCar(CreateCarRequest createCarRequest) {
        Model model = modelService.findModelIfExistsById(createCarRequest.getModelId());
        Car car = new Car(null, createCarRequest.getModelYear(),
                createCarRequest.getPlate(), StateType.AVAILABLE, createCarRequest.getDailyPrice(), model);

        return carConverter.convertToCreateCarResponse(carRepository.save(car));
    }

    public UpdateCarResponse updateCar(Long id, UpdateCarRequest updateCarRequest) {
        findCarIfExistsById(id);
        Model model = modelService.findModelIfExistsById(updateCarRequest.getModelId());
        Car car = new Car(id, updateCarRequest.getModelYear(),
                updateCarRequest.getPlate(), updateCarRequest.getState(), updateCarRequest.getDailyPrice(), model);

        return carConverter.convertToUpdateCarResponse(carRepository.save(car));
    }

    public void deleteCar(Long id) {
        findCarIfExistsById(id);
        carRepository.deleteById(id);
    }

    protected Car findCarIfExistsById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }
}