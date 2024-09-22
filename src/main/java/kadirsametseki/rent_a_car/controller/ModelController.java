package kadirsametseki.rent_a_car.controller;

import kadirsametseki.rent_a_car.dto.request.create.CreateModelRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateModelRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllModelsResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateModelResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetModelResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateModelResponse;
import kadirsametseki.rent_a_car.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<GetAllModelsResponse> getAllModels() {
        return modelService.findAllModels();
    }

    @GetMapping("/{id}")
    public GetModelResponse getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse createModel(@RequestBody CreateModelRequest createModelRequest) {
        return modelService.createModel(createModelRequest);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse updateModel(@PathVariable Long id, @RequestBody UpdateModelRequest updateModelRequest) {
        return modelService.updateModel(id, updateModelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }
}