package com.beykent.entities.concretes;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "created_datetime")
	private Date createdDatetime;

	@Column(name = "written_text")
	private String writtenText;

	@Column(name = "media_location")
	private String mediaLocation;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "postId")
	private List<PostLike> postLike;
}
