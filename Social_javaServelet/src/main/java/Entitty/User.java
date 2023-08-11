package Entitty;

import java.io.Serializable;
import javax.persistence.*;

import Constant.NameStored;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;

import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedStoredProcedureQuery(name = NameStored.FIND_USER_LIKED,
			procedureName = "getUser",
			resultClasses = {User.class},
			parameters = @StoredProcedureParameter(name ="videoHref", type = String.class))

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String password;

	private String username;
	
	private byte isActive;

	private byte isAdmin;

	// bi-directional many-to-one association to History
	@OneToMany(mappedBy = "user")
	private List<History> histories;

	public User() {
	}

	public User(int id, String email, String password, String username, byte isActive, byte isAdmin,
			List<History> histories) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.histories = histories;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}



}