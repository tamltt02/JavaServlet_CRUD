package Entitty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@NamedQuery(name = "Video.findAll", query = "SELECT o FROM Video o")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String href;

	private String poster;
	
	private int views;

	private int shares;

	private String description;

	private byte isActive;

	// bi-directional many-to-one association to History
	@OneToMany(mappedBy = "video")
	private List<History> histories;

	public Video() {
	}

	public Video(int id, String title, String href, String poster, int views, int shares, String description,
			byte isActive, List<History> histories) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.shares = shares;
		this.description = description;
		this.isActive = isActive;
		this.histories = histories;
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

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getShares() {
		return this.shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}



}