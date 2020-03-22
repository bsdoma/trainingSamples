package com.training.hibernate.orphanremoval;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity (name = "Account")
@Table(name = "OrphanAccount")
public class OrphanAccountEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer           accountId;
    @Column(name = "ACC_NO", unique = false, nullable = false, length = 100)
    private String            accountNumber;
 
    @ManyToOne
    private OrphanEmployeeEntity orphanEmployee;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public OrphanEmployeeEntity getOrphanEmployee() {
		return orphanEmployee;
	}

	public void setOrphanEmployee(OrphanEmployeeEntity orphanEmployee) {
		this.orphanEmployee = orphanEmployee;
	}

    
    
}