package com.learningprojects.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
	@Null // this is read only property, someone else cannot set the value
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.uuid.UuidGenerator")
	@UuidGenerator
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID id;

	@Null
	@Version // gives optimistic locking
	private Integer version;

	@Null
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;

	@Null
	@UpdateTimestamp
	private Timestamp lastModifiedDate;

	@NotBlank
	private String beerName;

	@NotNull
	private String beerStyle;

	@NotNull
	@Positive
	@Column(unique = true)
	private Long upc;

	@Positive
	@NotNull
	private BigDecimal price;

	private Integer minOnHand;
	
	private Integer quantityToBrew;
}
