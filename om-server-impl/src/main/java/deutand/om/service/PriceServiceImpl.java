package deutand.om.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import deutand.om.data.PriceDTO;
import deutand.om.persistence.repositories.PriceRepository;
import deutand.om.services.PriceService;

public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceReporitory;

	@Override
	public List<PriceDTO> getAllPricesForCar(Long carId) {
		return priceReporitory.getAllPriceDTOsForCar(carId);
	}

	@Override
	public PriceDTO getPriceById(Long priceId) {
		return priceReporitory.getPriceDTOById(priceId);
	}

	@Override
	public PriceDTO createPrice(PriceDTO price) {
		return priceReporitory.createPrice(price);
	}

	@Override
	public PriceDTO updatePrice(PriceDTO price) {
		return priceReporitory.updatePrice(price);
	}

	@Override
	public void deletePriceById(Long priceId) {
		priceReporitory.deletePrice(priceId);
	}
}
