package kadirsametseki.rent_a_car.controller;

import kadirsametseki.rent_a_car.dto.request.create.CreateBrandRequest;
import kadirsametseki.rent_a_car.dto.request.update.UpdateBrandRequest;
import kadirsametseki.rent_a_car.dto.response.get.GetAllBrandsResponse;
import kadirsametseki.rent_a_car.dto.response.get.GetBrandResponse;
import kadirsametseki.rent_a_car.dto.response.create.CreateBrandResponse;
import kadirsametseki.rent_a_car.dto.response.update.UpdateBrandResponse;
import kadirsametseki.rent_a_car.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<GetAllBrandsResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse createBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.createBrand(createBrandRequest);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse updateBrand(@PathVariable Long id, @RequestBody UpdateBrandRequest request) {
        return brandService.updateBrand(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}
