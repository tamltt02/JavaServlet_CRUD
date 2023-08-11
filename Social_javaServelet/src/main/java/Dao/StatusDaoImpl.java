package Dao;

import java.util.ArrayList;
import java.util.List;

import Entitty.User;
import dto.VideoLikedInfo;

public class StatusDaoImpl extends AbstracDao<Object[]> implements StatusDao{

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql = "select v.id,v.title,v.href , cast(sum(cast(h.isLiked as int)) as int) as totalLiked "
				+ "from Video v left join History h"
				+ " on h.video.id = v.id "
				+ "where v.isActive = 1 group by v.id,v.title,v.href "
				+ "order by    cast(sum(cast(h.isLiked as int)) as int) desc";
		List<Object[]> objects = super.findManyNativeQuery(sql);
		List<VideoLikedInfo> result = new ArrayList<VideoLikedInfo>();
		objects.forEach(object -> {
			VideoLikedInfo videolikeInfo = setDataLikeInfo(object);
			result.add(videolikeInfo);
		});
		return result;
	}

	
	private VideoLikedInfo  setDataLikeInfo(Object[] object) {
		VideoLikedInfo videolikeInfo = new VideoLikedInfo();
		videolikeInfo.setVideoId((Integer)object[0]);
		videolikeInfo.setTitle((String) object[1]);
		videolikeInfo.setHref((String)  object[2]);
		videolikeInfo.setTotalLike(  object[3] == null ? 0 : (Integer) object[3]);
		return videolikeInfo;
	}



}
