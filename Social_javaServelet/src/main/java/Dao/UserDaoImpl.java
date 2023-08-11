package Dao;

import java.util.List;
import java.util.Map;

import Constant.NameStored;
import Entitty.User;

public class UserDaoImpl extends AbstracDao<User>  implements UserDao{

	@Override
	public User findById(Integer id) {
		return super.findByID(User.class, id);
				}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where  o.email = ? 0";
		return super.findone(User.class ,sql,email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select o from User o where  o.username = ? 0";
		return super.findone(User.class ,sql,username);
	}

	@Override
	public User findByUsernameandPass(String username, String password) {
		String sql = "select o from User o where  o.username = ? 0 and o.password =? 1";
		return super.findone(User.class ,sql,username,password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUserByVideoHref( Map<String, Object> params) {		
		return super.callStore(NameStored.FIND_USER_LIKED, params);
	}

}
