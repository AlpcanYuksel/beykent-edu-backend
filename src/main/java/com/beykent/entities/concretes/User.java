package com.beykent.entities.concretes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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

	@Column(name = "media_location")
	private String profilePhoto;

	@Column(name = "personal_information")
	private String personalInformation;

	// bi-directional many-to-many association to User

	@ManyToMany
	@JoinTable(name = "follower", joinColumns = { @JoinColumn(name = "following_user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "follower_user_id") })
	private List<User> followings;

	// bi-directional many-to-many association to User

	@ManyToMany(mappedBy = "followings")
	private List<User> followers;

	@OneToMany(mappedBy = "user")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Post> posts;

	@OneToMany(mappedBy = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<PostLike> postLike;

	@OneToMany(mappedBy = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<UserClub> userClubs;

	@OneToMany(mappedBy = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<InternshipApplication> internshipApplications;

	@OneToMany(mappedBy = "user")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Comment> comments;

	@OneToMany(mappedBy = "user")
	private List<CommentLike> commentLikes;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

}
