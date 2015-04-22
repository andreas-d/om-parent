package deutand.om.persistence.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deutand.om.data.CarDTO;
import deutand.om.persistence.entity.BrandEntity;
import deutand.om.persistence.entity.CarEntity;
import deutand.om.persistence.entity.PriceEntity;

@Repository
public class CarRepository extends AbstractRepository {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CarEntity> getAllCars() {
		return getSession().createCriteria(CarEntity.class).list();
	}

	@Transactional(readOnly = true)
	public List<CarDTO> getAllCarDTOs() {
		List<CarDTO> result = new ArrayList<CarDTO>();

		for (CarEntity car : getAllCars()) {
			result.add(car.toDTO());
		}
		result.sort(new Comparator<CarDTO>() {

			@Override
			public int compare(CarDTO o1, CarDTO o2) {
				return (int) (o1.getId() - o2.getId());
			}
		});

		return result;
	}

	@Transactional(readOnly = true)
	public CarEntity getCarById(Long id) {
		return (CarEntity) getSession().get(CarEntity.class, id);
	}

	@Transactional(readOnly = true)
	public CarDTO getCarDTOById(Long id) {
		CarEntity car = getCarById(id);

		if (car == null) {
			return null;
		}

		return car.toDTO();
	}

	@Transactional(readOnly = false)
	public CarDTO createCar(CarDTO car) {
		BrandEntity brand = (BrandEntity) getSession().get(BrandEntity.class,
				car.getBrandDTO().getId());
		PriceEntity price = (PriceEntity) getSession().get(PriceEntity.class,
				car.getPriceDTO().getId());
		CarEntity entity = new CarEntity(car, brand, price);
		saveCar(entity);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void saveCar(CarEntity car) {
		save(car);
	}

	@Transactional(readOnly = false)
	public void updateCar(CarEntity car, CarDTO dTO) {
		car.fromDTO(dTO, null, null, true);
		update(car);
	}

	@Transactional(readOnly = false)
	public CarDTO updateCar(CarDTO car) {

		CarEntity entity = getCarById(car.getId());

		updateCar(entity, car);

		return entity.toDTO();
	}

	@Transactional(readOnly = false)
	public void deleteCar(Long id) {
		CarEntity entity = getCarById(id);

		delete(entity);
	}
}
