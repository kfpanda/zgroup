package com.zoo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoo.bean.VideoHot;
import com.zoo.bean.VideoNew;

public interface VideoHotMapper {
    int deleteByPrimaryKey(Long id);
    int insert(VideoHot record);
    int insertSelective(VideoHot record);
    VideoHot selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(VideoHot record);
    int updateByPrimaryKey(VideoHot record);
    List<VideoHot> listByParams(Map map);
    List<VideoHot> listByParams4Page(Map map);
	int countByParams(HashMap params);
}