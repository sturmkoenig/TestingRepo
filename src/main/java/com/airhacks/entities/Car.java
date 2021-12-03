
package com.airhacks.entities;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {})
public class Car {

	@XmlElement
	private String id;
	@XmlElement
	private String name;

	@NotNull(message = "Price must be set!")
	@XmlElement
	private Long price;

	@XmlElement
	private String producer;

	@Override
	public String toString() {
		return this.name + " " + this.id + " costs: " + this.price.toString();
	}

}
