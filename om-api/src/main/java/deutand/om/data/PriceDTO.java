package deutand.om.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PriceDTO {

	private Long id;
	private double price;

	public PriceDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}