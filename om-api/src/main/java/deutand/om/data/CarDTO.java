package deutand.om.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarDTO {

	private Long id;
	private String model;
	private BrandDTO brandDTO;
	private PriceDTO priceDTO;

	public CarDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}

	public PriceDTO getPriceDTO() {
		return priceDTO;
	}

	public void setPriceDTO(PriceDTO priceDTO) {
		this.priceDTO = priceDTO;
	}
}
