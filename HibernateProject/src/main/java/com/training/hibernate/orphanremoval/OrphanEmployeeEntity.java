package com.training.hibernate.orphanremoval;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrphanEmployee")
public class OrphanEmployeeEntity implements Serializable
{
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer           employeeId;
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String            firstName;
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String            lastName;
 
    @OneToMany(orphanRemoval = true, mappedBy = "orphanEmployee")
    private Set<OrphanAccountEntity> accounts;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<OrphanAccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<OrphanAccountEntity> accounts) {
		this.accounts = accounts;
	}
    
    
    
}
