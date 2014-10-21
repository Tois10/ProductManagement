package id.co.skyforce.basicjsp.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class PartTimeEmployee extends Employee {
	
	@Column(name = "work_hour")
	private BigDecimal workHour;
	
	public BigDecimal getWorkHour() {
		return workHour;
	}
	
	public void setWorkHour(BigDecimal workHour) {
		this.workHour = workHour;
	}

}
