package com.beykent.entities.concretes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "full_name")
	private String fullName;

	private String password;

	@Column(name = "student_no")
	private String studentNo;

	// bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(name = "follower", joinColumns = { @JoinColumn(name = "following_user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "follower_user_id") })
	private List<User> followings;

	// bi-directional many-to-many association to User
	@ManyToMany(mappedBy = "followings")
	private List<User> followers;

}

//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private UUID id;
//
//	@Column(name = "student_no", nullable = false, unique = true)
//	private String studentNo;
//
//	@Column(name = "password", nullable = false, unique = true)
//	private String password;
//
//	@Column(name = "full_name")
//	private String fullName;
//
//	@OneToMany(mappedBy = "followers")
//	private List<Follow> followers;
//
//	@OneToMany(mappedBy = "following")
//	private List<Follow> following;
//
//}
