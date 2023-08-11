package Dao;

import java.util.List;

import Entitty.History;

public class HistoryDaoimpl extends AbstracDao<History>  implements HistoryDao{

	@Override
	public List<History> findByUser(String user) {
		String sql = "select o from History o where o.user.username=? 0 and o.video.isActive = 1 "
				+ "order by o.viewdate DESC";
		return super.findmany(History.class, sql, user);
	}

	@Override
	public List<History> findByUserAnhIsLiked(String user) {
		String sql = "select o from History o where o.user.username=? 0 and o.isLiked = 1"
				+ " and o.video.isActive = 1 "
				+ "order by o.viewdate DESC";
		return super.findmany(History.class, sql, user);
	}

	@Override
	public History findByUserIdandVideoId(Integer userId, Integer videoId) {
		String sql = "select o from History o where o.user.id=? 0 and o.video.id =? 1";
		return super.findone(History.class, sql, userId,videoId);
	}
}
