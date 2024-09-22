package kadirsametseki.rent_a_car.service;

import kadirsametseki.rent_a_car.dto.converter.ModelConverter;
import kadirsametseki.rent_a_car.dto.request.create.CreateModelRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateModelRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllModelsResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateModelResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetModelResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateModelResponse;
import kadirsametseki.rent_a_car.model.Brand;
import kadirsametseki.rent_a_car.model.Model;
import kadirsametseki.rent_a_car.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final BrandService brandService;
    private final ModelConverter modelConverter;

    public ModelService(ModelRepository modelRepository,
                        BrandService brandService,
                        ModelConverter modelConverter) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
        this.modelConverter = modelConverter;
    }

    public List<GetAllModelsResponse> findAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(modelConverter::convertToGetAllModelsResponse)
                .collect(Collectors.toList());
    }

    public GetModelResponse getModelById(Long id) {
        return modelConverter.convertToGetModelResponse(findModelIfExistsById(id));
    }

    public CreateModelResponse createModel(CreateModelRequest createModelRequest) {
        Brand brand = brandService.findBrandIfExistsById(createModelRequest.getBrandId());
        Model model = new Model(null, createModelRequest.getName(), brand, new ArrayList<>());
        /*Car car = new Car(null, 1999, "06 AD 156", StateType.AVAILABLE, BigDecimal.ONE, model);*/
        /*model.getCars().add(car);*/
        return modelConverter.convertToCreateModelResponse(modelRepository.save(model));
    }

    public UpdateModelResponse updateModel(Long id, UpdateModelRequest updateModelRequest) {
        Brand brand = brandService.findBrandIfExistsById(updateModelRequest.getBrandId());
        findModelIfExistsById(id);
        Model model = new Model(id, updateModelRequest.getName(), brand, new ArrayList<>());
        /*Car car = new Car(null, 2001, "34 FJK 541", StateType.AVAILABLE, BigDecimal.valueOf(1000), model);
        model.getCars().add(car);*/
        return modelConverter.convertToUpdateModelResponse(modelRepository.save(model));
    }

    public void deleteModel(Long id) {
        findModelIfExistsById(id);
        modelRepository.deleteById(id);
    }

    protected Model findModelIfExistsById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
    }
}