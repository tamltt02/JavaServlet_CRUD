package Service;

import java.util.List;

import dto.VideoLikedInfo;

public interface StatusService {
	List<VideoLikedInfo> findVideoLikedInfo();
	
}
