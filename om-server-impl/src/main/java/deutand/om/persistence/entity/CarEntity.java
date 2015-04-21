package deutand.om.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import deutand.om.data.CarDTO;

@Entity
@Table(name = "CAR")
public class CarEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "MODEL")
	private String model;

	@OneToOne(fetch = FetchType.EAGER)
	private BrandEntity brand;

	@OneToOne(fetch = FetchType.EAGER)
	private PriceEntity price;

	public CarEntity() {
	}
	
	public CarEntity(CarDTO dTO, BrandEntity brand, PriceEntity price) {
		fromDTO(dTO, brand, price, false);
	}

	public CarDTO toDTO() {
		CarDTO dTO = new CarDTO();
		dTO.setId(getId());
		dTO.setModel(getModel());
		dTO.setBrandId(getBrand().getId());
		dTO.setPriceId(getPrice().getId());

		return dTO;
	}

	public void fromDTO(CarDTO dTO, BrandEntity brand, PriceEntity price, boolean isUpdate) {
		if (!isUpdate) {
			setId(dTO.getId());
		}
		if (brand != null) {
			setBrand(brand);
		}
		if (price != null) {
			setPrice(price);
		}

		setModel(dTO.getModel());
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

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public PriceEntity getPrice() {
		return price;
	}

	public void setPrice(PriceEntity price) {
		this.price = price;
	}
}
