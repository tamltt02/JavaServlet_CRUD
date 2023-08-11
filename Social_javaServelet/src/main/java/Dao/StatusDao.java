package Dao;

import java.util.List;

import Entitty.User;
import dto.VideoLikedInfo;

public interface StatusDao {
	List<VideoLikedInfo> findVideoLikedInfo();
}
