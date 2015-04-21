package deutand.om.service;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deutand.om.data.CarDTO;
import deutand.om.persistence.repositories.CarRepository;
import deutand.om.services.CarService;

@Path("/car")
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<CarDTO> getAllCars() {
		return carRepository.getAllCarDTOs();
	}

	@Override
	public CarDTO getCarById(Long carId) {
		return carRepository.getCarDTOById(carId);
	}

	@Override
	public CarDTO createCar(CarDTO car) {
		return carRepository.createCar(car);
	}

	@Override
	public CarDTO updateCar(CarDTO car) {
		return carRepository.updateCar(car);
	}

	@Override
	public void deleteCarById(Long carId) {
		carRepository.deleteCar(carId);
	}
}
