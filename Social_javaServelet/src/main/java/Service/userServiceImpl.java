package Service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Entitty.User;

public class userServiceImpl implements UserService{
public UserDao dao ;

	public userServiceImpl() {
	super();
	// TODO Auto-generated constructor stub
	dao = new UserDaoImpl();
}

	@Override
	public User findById(Integer id) {
		
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String passwword) {
		// TODO Auto-generated method stub
		return dao.findByUsernameandPass(username, passwword);
	}

	@Override
	public User resetPasssword(String email) {
		User exitUser = findByEmail(email);
		if(exitUser != null) {
			// (random * (Max - min) +1)+ min 
			String newPass = String.valueOf( (int )(Math.random() *( (9999 - 1000) +1))+ 1000 );
			exitUser.setPassword(newPass);
			return dao.update(exitUser);
		}
		return null ;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin((byte) 1);
		newUser.setIsActive((byte) 1);	
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsername(username);
		user.setIsActive((byte) 0);
		return dao.update(user);
	}

	@Override
	public List<User> findUserByVideoHref(String href) {
		Map<String, Object> params = new HashedMap();
		params.put("videoHref", href);
		return dao.findUserByVideoHref(params);
	}

}
