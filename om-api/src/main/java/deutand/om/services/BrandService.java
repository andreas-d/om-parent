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

import deutand.om.data.BrandDTO;

public interface BrandService {
	
	@GET
	@Path("/allbrandsforcar/{carid}")
	@Produces(MediaType.APPLICATION_JSON)
	List<BrandDTO> getAllBrandsForCar(@PathParam("carid") Long carId);

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	BrandDTO getBrandById(@PathParam("id") Long brandId);

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	BrandDTO createBrand(BrandDTO brand);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	BrandDTO updateBrand(BrandDTO brand);

	@DELETE
	@Path("/delete/{id}")
	void deleteBrandById(@PathParam("id") Long brandId);
}
