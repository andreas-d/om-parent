package deutand.om.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarDTO {

	private Long id;
	private String model;
	private Long brandId;
	private Long priceId;

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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
}
