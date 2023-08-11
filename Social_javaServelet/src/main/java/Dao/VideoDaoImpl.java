package Dao;

import java.util.List;

import Entitty.User;
import Entitty.Video;

public class VideoDaoImpl extends AbstracDao<Video>  implements VideoDao{

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql = "select o from Video o where  o.href = ? 0";
		return super.findone(Video.class ,sql,href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class ,true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findAll(Video.class ,true,pageNumber,pageSize);
	}

	@Override
	public Video create(Video entity) {
		return super.create(entity);
	}

	@Override
	public Video update(Video entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public Video delete(Video entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
