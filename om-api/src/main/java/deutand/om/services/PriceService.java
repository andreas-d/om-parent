package deutand.om.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import deutand.om.data.PriceDTO;

public interface PriceService {

	@GET
	@Path("/allpricesforcar/{carid}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PriceDTO> getAllPricesForCar(@PathParam("carid") Long carId);

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	PriceDTO getPriceById(@PathParam("id") Long priceId);

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	PriceDTO createPrice(PriceDTO price);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	PriceDTO updatePrice(PriceDTO price);

	@DELETE
	@Path("/delete/{id}")
	void deletePriceById(@PathParam("id") Long priceId);
}
