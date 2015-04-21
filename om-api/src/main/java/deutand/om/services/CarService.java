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

import deutand.om.data.CarDTO;

public interface CarService {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	List<CarDTO> getAllCars();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	CarDTO getCarById(@PathParam("id") Long carId);

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	CarDTO createCar(CarDTO car);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	CarDTO updateCar(CarDTO car);

	@DELETE
	@Path("/delete/{id}")
	void deleteCarById(@PathParam("id") Long carId);
}
