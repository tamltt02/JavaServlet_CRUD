package Service;

import java.util.List;
import java.util.Map;

import Entitty.User;

public interface UserService {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User login(String username, String passwword);
	User resetPasssword(String email );
	List<User> findAll ();
	List<User> findAll (int pageNumber, int pageSize);
	User create(String username, String password, String email );
	User update(User entity);
	User delete(String username);
	List<User> findUserByVideoHref (String href);
}
