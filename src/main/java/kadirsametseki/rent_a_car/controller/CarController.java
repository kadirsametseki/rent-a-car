package kadirsametseki.rent_a_car.controller;

import kadirsametseki.rent_a_car.dto.request.create.CreateCarRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateCarRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllCarsResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateCarResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetCarResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateCarResponse;
import kadirsametseki.rent_a_car.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<GetAllCarsResponse> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public GetCarResponse getCarById(@PathVariable Long id) {
        return carService.getBrandById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse createCar(@RequestBody CreateCarRequest createCarRequest) {
        return carService.createCar(createCarRequest);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse updateCar(@PathVariable Long id, @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.updateCar(id, updateCarRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
