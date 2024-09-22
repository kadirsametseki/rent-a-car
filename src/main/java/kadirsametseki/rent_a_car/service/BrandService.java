package kadirsametseki.rent_a_car.service;

import kadirsametseki.rent_a_car.dto.converter.BrandConverter;
import kadirsametseki.rent_a_car.dto.request.create.CreateBrandRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateBrandRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllBrandsResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetBrandResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateBrandResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateBrandResponse;
import kadirsametseki.rent_a_car.exception.BrandNotFoundException;
import kadirsametseki.rent_a_car.model.Brand;
import kadirsametseki.rent_a_car.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    public BrandService(BrandRepository brandRepository, BrandConverter brandConverter) {
        this.brandRepository = brandRepository;
        this.brandConverter = brandConverter;
    }

    public List<GetAllBrandsResponse> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandConverter::convertToGetAllBrandsResponse)
                .collect(Collectors.toList());
    }

    public GetBrandResponse getBrandById(Long id) {
        Brand brand = findBrandIfExistsById(id);
        return brandConverter.convertToGetBrandResponse(brand);
    }

    public CreateBrandResponse createBrand(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand(null, createBrandRequest.getName(), new ArrayList<>());
        return brandConverter.convertToCreateBrandResponse(brandRepository.save(brand));
    }

    public UpdateBrandResponse updateBrand(Long id, UpdateBrandRequest updateBrandRequest) {
        findBrandIfExistsById(id);
        Brand brand = new Brand(id, updateBrandRequest.getName(), new ArrayList<>());
        return brandConverter.convertToUpdateBrandResponse(brandRepository.save(brand));
    }

    public void deleteBrand(Long id) {
        findBrandIfExistsById(id);
        brandRepository.deleteById(id);
    }

    protected Brand findBrandIfExistsById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException("Brand not found with id: " + id));
    }
}