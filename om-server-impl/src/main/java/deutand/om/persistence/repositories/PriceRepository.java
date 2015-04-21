package deutand.om.persistence.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deutand.om.data.PriceDTO;
import deutand.om.persistence.entity.PriceEntity;

@Repository
public class PriceRepository extends AbstractRepository {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PriceEntity> getAllPrices() {
		return getSession().createCriteria(PriceEntity.class).list();
	}

	@Transactional(readOnly = true)
	public List<PriceDTO> getAllPriceDTOs() {
		List<PriceDTO> result = new ArrayList<PriceDTO>();

		for (PriceEntity Price : getAllPrices()) {
			result.add(Price.toDTO());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PriceEntity> getAllPricesForCar(Long carId) {

		Criteria criteria = getSession().createCriteria(PriceEntity.class);
		criteria.add(Restrictions.eq("price.id", carId));

		return criteria.list();
	}

	@Transactional(readOnly = true)
	public List<PriceDTO> getAllPriceDTOsForCar(Long carId) {
		List<PriceDTO> result = new ArrayList<PriceDTO>();

		for (PriceEntity price : getAllPricesForCar(carId)) {
			result.add(price.toDTO());
		}

		return result;
	}

	@Transactional(readOnly = true)
	public PriceEntity getPriceById(Long id) {
		return (PriceEntity) getSession().get(PriceEntity.class, id);
	}

	@Transactional(readOnly = true)
	public PriceDTO getPriceDTOById(Long id) {
		PriceEntity Price = getPriceById(id);

		if (Price == null) {
			return null;
		}

		return Price.toDTO();
	}

	@Transactional(readOnly = false)
	public PriceDTO createPrice(PriceDTO Price) {
		PriceEntity entity = new PriceEntity(Price);
		savePrice(entity);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void savePrice(PriceEntity Price) {
		save(Price);
	}

	@Transactional(readOnly = false)
	public void updatePrice(PriceEntity Price, PriceDTO dTO) {
		Price.fromDTO(dTO, true);
		update(Price);
	}

	@Transactional(readOnly = false)
	public PriceDTO updatePrice(PriceDTO Price) {

		PriceEntity entity = getPriceById(Price.getId());

		updatePrice(entity, Price);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void deletePrice(Long id) {
		PriceEntity entity = getPriceById(id);

		delete(entity);
	}
}
