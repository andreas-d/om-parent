package deutand.om.persistence.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deutand.om.data.BrandDTO;
import deutand.om.persistence.entity.BrandEntity;

@Repository
public class BrandRepository extends AbstractRepository {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BrandEntity> getAllBrands() {
		return getSession().createCriteria(BrandEntity.class).list();
	}

	@Transactional(readOnly = true)
	public List<BrandDTO> getAllBrandDTOs() {
		List<BrandDTO> result = new ArrayList<BrandDTO>();

		for (BrandEntity Brand : getAllBrands()) {
			result.add(Brand.toDTO());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BrandEntity> getAllBrandsForCar(Long carId) {

		Criteria criteria = getSession().createCriteria(BrandEntity.class);
		criteria.add(Restrictions.eq("brand.id", carId));

		return criteria.list();
	}

	@Transactional(readOnly = true)
	public List<BrandDTO> getAllBrandDTOsForCar(Long carId) {
		List<BrandDTO> result = new ArrayList<BrandDTO>();

		for (BrandEntity brand : getAllBrandsForCar(carId)) {
			result.add(brand.toDTO());
		}

		return result;
	}
	
	@Transactional(readOnly = true)
	public BrandEntity getBrandById(Long id) {
		return (BrandEntity) getSession().get(BrandEntity.class, id);
	}

	@Transactional(readOnly = true)
	public BrandDTO getBrandDTOById(Long id) {
		BrandEntity Brand = getBrandById(id);

		if (Brand == null) {
			return null;
		}

		return Brand.toDTO();
	}

	@Transactional(readOnly = false)
	public BrandDTO createBrand(BrandDTO Brand) {
		BrandEntity entity = new BrandEntity(Brand);
		saveBrand(entity);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void saveBrand(BrandEntity Brand) {
		save(Brand);
	}

	@Transactional(readOnly = false)
	public void updateBrand(BrandEntity Brand, BrandDTO dTO) {
		Brand.fromDTO(dTO, true);
		update(Brand);
	}

	@Transactional(readOnly = false)
	public BrandDTO updateBrand(BrandDTO Brand) {

		BrandEntity entity = getBrandById(Brand.getId());

		updateBrand(entity, Brand);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void deleteBrand(Long id) {
		BrandEntity entity = getBrandById(id);

		delete(entity);
	}
}
