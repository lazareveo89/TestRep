package p48.test.model;

import java.math.BigDecimal;

public class Account {
    private Integer id;
    
    private BigDecimal money;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public BigDecimal getMoney() {
	return money;
    }

    public void setMoney(BigDecimal money) {
	this.money = money;
    }
    
    
}
