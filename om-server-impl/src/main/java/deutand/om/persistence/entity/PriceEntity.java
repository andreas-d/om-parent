package deutand.om.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import deutand.om.data.PriceDTO;

@Entity
@Table(name = "PRICE")
public class PriceEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PRICE")
	private double price;

	public PriceEntity() {
	}

	public PriceEntity(PriceDTO dTO) {
		fromDTO(dTO, false);
	}

	public PriceDTO toDTO() {
		PriceDTO dTO = new PriceDTO();
		dTO.setId(getId());
		dTO.setPrice(getPrice());

		return dTO;
	}

	public void fromDTO(PriceDTO dTO, boolean isUpdate) {
		if (isUpdate) {
			setId(dTO.getId());
		}

		setPrice(dTO.getPrice());
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
