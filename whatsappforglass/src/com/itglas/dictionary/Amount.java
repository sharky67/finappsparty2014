package com.itglas.dictionary;

import java.math.BigDecimal;

public class Amount {
	public String name;
	public BigDecimal value;
	public int position; //position in the string
	
	public Amount(String name, BigDecimal value) {
		this.value = value;
		this.name = name;
		this.position = -1;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
