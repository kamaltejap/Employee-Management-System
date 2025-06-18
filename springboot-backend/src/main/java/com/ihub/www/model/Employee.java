package com.ihub.www.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	 @Column(name = "date_of_joining")
	 @JsonFormat(pattern = "yyyy-MM-dd")
	 private LocalDate dateOfJoining;
	 
	 @Column(name = "is_deleted")
	  private boolean isDeleted = false;

	    @Column(name = "deleted_at")
	    private LocalDate deletedAt;
 
	    public LocalDate getDateOfJoining() {
	        return dateOfJoining;
	    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setIsDeleted(boolean b) {
		// TODO Auto-generated method stub
		this.isDeleted=b;
		
	}
	public boolean getIsDeleted() {
		return isDeleted;
		
	}

	public LocalDate getDeletedAt() {
	    return deletedAt;
	}

	public void setDeletedAt(LocalDate deletedAt) {
	    this.deletedAt = deletedAt;
	}
}