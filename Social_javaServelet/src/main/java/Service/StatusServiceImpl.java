package Service;

import java.util.List;

import Dao.StatusDao;
import Dao.StatusDaoImpl;
import dto.VideoLikedInfo;

public class StatusServiceImpl implements StatusService {
 private StatusDao dao;
 
	public StatusServiceImpl() {
		super();
		dao = new StatusDaoImpl();
	}

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		// TODO Auto-generated method stub
		return dao.findVideoLikedInfo();
	}

}
