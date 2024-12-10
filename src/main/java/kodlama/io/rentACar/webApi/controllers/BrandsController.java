package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstarcts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
    @Autowired
    private BrandService brandService;

    //Autowired ile bu işlem yapılır
//    public BrandsController(BrandService brandService) {
//        this.brandService = brandService;
//
//    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();

    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id)
    {
        return (GetByIdBrandResponse) brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest)
    {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
    {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        this.brandService.delete(id);
    }


}
