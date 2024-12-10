package kodlama.io.rentACar.business.concretes;


import kodlama.io.rentACar.Core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.business.abstarcts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service //This class is a business object
public class BrandManager implements BrandService {


    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    //@Autowired ile bu constructor metodunu yazmaya gerek yok
//    public BrandManager(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //İş kuralları
        List<Brand> brands = brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//
//        for (Brand brand : brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponses.add(responseItem);
//        }
//        return brandsResponses;
//    }
        List<GetAllBrandsResponse> brandsResponse = brands.stream().
                map(brand -> this.modelMapperService.forResponse().
                        map(brand, GetAllBrandsResponse.class)).
                collect(Collectors.toList());
        return brandsResponse;
    }


    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest()
                .map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }


    @Override
    public GetByIdBrandResponse getById(int id) {

        Brand brand = this.brandRepository.findById(id).orElse(null);
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest, Brand.class);

        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }

}
