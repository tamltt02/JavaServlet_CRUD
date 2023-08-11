package Service;

import java.sql.Timestamp;
import java.util.List;

import Dao.HistoryDao;
import Dao.HistoryDaoimpl;
import Entitty.History;
import Entitty.User;
import Entitty.Video;

public class HistoryServiceIplm implements HistoryService {
	private HistoryDao dao ;
	 private VideoService videoService  = new VideoServiceimpl();
	public HistoryServiceIplm() {
		super();
		dao = new HistoryDaoimpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<History> findByUser(String user) {
		
		return dao.findByUser(user);
	}

	@Override
	public List<History> findByUserAnhIsLiked(String user) {
		return dao.findByUserAnhIsLiked(user);
	}

	@Override
	public History findByUserIdandVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdandVideoId(userId,videoId);
	}

	@Override
	public History create(User user, Video video) {
		History exitHistory = findByUserIdandVideoId(user.getId(), video.getId());
		
		if(exitHistory == null) {
			exitHistory = new History();
			exitHistory.setUser(user);
			exitHistory.setVideo(video);
			exitHistory.setIsLiked((byte) 0);
			exitHistory.setViewdate(new Timestamp(System.currentTimeMillis()));
			return dao.create(exitHistory);
	}
	return exitHistory ;
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History exitHistory = findByUserIdandVideoId(user.getId(), video.getId());
		if(exitHistory.getIsLiked() == 0) {
			exitHistory.setIsLiked((byte) 1);
			exitHistory.setLikedate(new Timestamp(System.currentTimeMillis()));
		}else {
			exitHistory.setIsLiked((byte) 0);
			exitHistory.setLikedate(null );
		}
		History updateHistory = dao.update(exitHistory);
		return updateHistory != null ? true :false;
	}

}
