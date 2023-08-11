package Service;

import java.util.List;

import Dao.VideoDao;
import Dao.VideoDaoImpl;
import Entitty.Video;

public class VideoServiceimpl implements VideoService {
public VideoDao dao ;

	public VideoServiceimpl() {
		super();
		// TODO Auto-generated constructor stub
		dao = new VideoDaoImpl();
	}

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber,pageSize);
	}

	@Override
	public Video create(Video entity) {
		entity.setIsActive((byte) 1);
		entity.setViews(0);
		entity.setShares(0);
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		return dao.update(entity);
	}

	@Override
	public Video delete(String href) {//không dekete khỏi database
		Video entity =dao.findByHref(href);
		entity.setIsActive((byte) 0);
		return dao.update(entity);
	}

}
