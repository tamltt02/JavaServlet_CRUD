package Entitty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;
	
	private String description;

	private byte isLiked;

	@Temporal(TemporalType.TIMESTAMP)
	private Date likedate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date viewdate;



	public History() {
	}

	public History(int id, User user, Video video, String description, byte isLiked, Date likedate, Date viewdate) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.description = description;
		this.isLiked = isLiked;
		this.likedate = likedate;
		this.viewdate = viewdate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsLiked() {
		return this.isLiked;
	}

	public void setIsLiked(byte isLiked) {
		this.isLiked = isLiked;
	}

	public Date getLikedate() {
		return this.likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}

	public Date getViewdate() {
		return this.viewdate;
	}

	public void setViewdate(Date viewdate) {
		this.viewdate = viewdate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}