package Service;

import java.util.List;

import Entitty.History;
import Entitty.User;
import Entitty.Video;

public interface HistoryService {
	List<History> findByUser(String user);

	List<History> findByUserAnhIsLiked(String user);

	History findByUserIdandVideoId(Integer userId, Integer videoId);

	History create(User user, Video video);

	boolean updateLikeOrUnlike(User user,String videoHref);
}
