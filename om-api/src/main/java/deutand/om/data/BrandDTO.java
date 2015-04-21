package deutand.om.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BrandDTO {

	private Long id;
	private String name;

	public BrandDTO() {
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
