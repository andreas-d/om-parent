package deutand.om.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import deutand.om.data.BrandDTO;
import deutand.om.persistence.repositories.BrandRepository;
import deutand.om.services.BrandService;

public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> getAllBrandsForCar(Long carId) {
		return brandRepository.getAllBrandDTOsForCar(carId);
	}

	@Override
	public BrandDTO getBrandById(Long brandId) {
		return brandRepository.getBrandDTOById(brandId);
	}

	@Override
	public BrandDTO createBrand(BrandDTO brand) {
		return brandRepository.createBrand(brand);
	}

	@Override
	public BrandDTO updateBrand(BrandDTO brand) {
		return brandRepository.updateBrand(brand);
	}

	@Override
	public void deleteBrandById(Long brandId) {
		brandRepository.deleteBrand(brandId);
	}
}
