package com.chefshare.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 100)
	private String content;

	@Column(nullable = false, length = 10)
	private String cuisine;

	@Column(nullable = false, length = 50)
	private String region;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(nullable = true, length = 100)
	private String map;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "email")
	private User email;

	@Lob
	private String image;
	
	@Column(length = 100)
	private String filePath;
	
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;
}
