package com.beykent.entities.concretes;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // veritabanı objesi olduğunu belirtiyoruz
@Data // get ve set fonksiyonlarının otommatik tanımlanması
@AllArgsConstructor // tüm field'ların constructoru
@NoArgsConstructor // boş constructor
@Table(name = "announcements") // veritabanı tablo ismi
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "title") // veritabanı kolon isimleri
	private String title;

	@Column(name = "text")
	private String text;

	@Column(name = "banner")
	private Boolean banner;

	@Column(name = "media_location")
	private String mediaLocation;

}
