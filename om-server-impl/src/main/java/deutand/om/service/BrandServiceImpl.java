package deutand.om.service;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deutand.om.data.BrandDTO;
import deutand.om.persistence.repositories.BrandRepository;
import deutand.om.services.BrandService;

@Path("/brand")
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> getAllBrands() {
		return brandRepository.getAllBrandDTOs();
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
