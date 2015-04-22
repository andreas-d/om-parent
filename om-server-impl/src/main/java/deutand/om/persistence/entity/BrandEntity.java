package deutand.om.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import deutand.om.data.BrandDTO;

@Entity
@Table(name = "BRAND")
public class BrandEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public BrandEntity() {
	}

	public BrandEntity(BrandDTO dTO) {
		fromDTO(dTO, false);
	}

	public BrandDTO toDTO() {
		BrandDTO dTO = new BrandDTO();
		dTO.setId(getId());
		dTO.setName(getName());

		return dTO;
	}

	public void fromDTO(BrandDTO dTO, boolean isUpdate) {
		if (isUpdate) {
			setId(dTO.getId());
		}

		setName(dTO.getName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
