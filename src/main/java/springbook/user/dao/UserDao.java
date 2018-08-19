package springbook.user.dao;

import java.util.List;

import springbook.user.domain.User;

public interface UserDao {
	void add(final User user);
	User get(String id);
	void deleteAll();
	int getCount();
	List<User> getAll();
}
