package Dao;

import java.util.List;

import Entitty.History;

public interface HistoryDao {
	List<History> findByUser (String user);
	List<History> findByUserAnhIsLiked (String user);
	History	 findByUserIdandVideoId (Integer userId , Integer videoId);
	History create(History entity);
	History update(History entity);

}
