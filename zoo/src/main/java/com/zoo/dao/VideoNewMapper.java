package com.zoo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoo.bean.VideoNew;

public interface VideoNewMapper {

    
    /**
     * 直播列表查询
     * @author xhb 
     */
    List<VideoNew> selectVideoList(VideoNew record);
    
    

    int deleteByPrimaryKey(Long id);

    
    int insert(VideoNew record);

   
    int insertSelective(VideoNew record);

    
    VideoNew  selectByPrimaryKey(Long id);

    /**
     * 说明:根据主键修改所存在属性内容
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
    int updateByPrimaryKeySelective(VideoNew record);

    /**
     * 说明:根据主键修改record完整内容
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
    int updateByPrimaryKey(VideoNew record);

    /**
     * 说明:根据map查找bean结果集
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
    List<VideoNew> listByParams(Map map);
    
    /**
     * 说明:根据bean查找bean结果集
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
    List<VideoNew> listByParams4Page(Map map);
    
    /**
     * 说明:根据map查找map结果集
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
   /* List<Map> selectMapByBean4Page(VideoNew record);*/
    
   
    /**
     * 说明:根据map查找map结果集
     * @param VideoNew  
     * @return int 更新数量
     * @author dozen.zhang
     * @date 2015年5月14日上午11:34:13
     */
    /*List<VideoNew> selectBeanByMap4Page(HashMap map);
    
    int countByBean(VideoNew record);*/
    
    int countByParams(HashMap map);

    int countByOrParams(HashMap map);

      
}