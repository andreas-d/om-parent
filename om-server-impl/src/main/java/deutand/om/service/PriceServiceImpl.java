package deutand.om.service;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deutand.om.data.PriceDTO;
import deutand.om.persistence.repositories.PriceRepository;
import deutand.om.services.PriceService;

@Path("/price")
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceReporitory;

	@Override
	public List<PriceDTO> getAllPrices() {
		return priceReporitory.getAllPriceDTOs();
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
