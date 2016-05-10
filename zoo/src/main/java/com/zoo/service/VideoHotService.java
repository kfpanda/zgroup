package com.zoo.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.awifi.core.bean.ResultDTO;
import com.awifi.util.ResultUtil;
import com.awifi.util.ValidateUtil;
import com.zoo.bean.VideoHot;
import com.zoo.bean.VideoNew;
import com.zoo.dao.VideoHotMapper;

@Service
public class VideoHotService {

	/** * 引入 VideoNewMapper */
	@Resource
	private VideoHotMapper videoHotMapper;
	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 说明:list by page and params根据参数返回列表
     * @return List<HashMap>
     * @author dozen.zhang
     * @date 2015年11月15日下午12:36:24
     */
    public List<VideoHot> listByParams4Page(HashMap params) {
        return videoHotMapper.listByParams4Page(params);
    }
    public List<VideoHot> listByParams(HashMap params) {
        return videoHotMapper.listByParams(params);
    }

     /**
     * 说明:countByParams 根据参数提取个数
     * @return int
     * @author dozen.zhang
     * @date 2015年11月15日下午12:36:24
     */
    public int countByParams(HashMap params) {
           return videoHotMapper.countByParams(params);
    }

    /*
     * 说明:
     * @param VideoNew
     * @return
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午1:33:54
     */
    public ResultDTO save(VideoHot videoHot) {
        // 进行字段验证
       ValidateUtil<VideoNew> vu = new ValidateUtil<VideoNew>();
        
         //逻辑业务判断判断
       //判断是否有uq字段
       
       //判断是更新还是插入
        if (videoHot.getId()==null) {
               
        	videoHotMapper.insert(videoHot);
        } else {
        	videoHotMapper.updateByPrimaryKey(videoHot);
        }
        return ResultUtil.getSuccResult();
    }
    /**
    * 说明:根据主键删除数据
    * description:delete by key
    * @param id
    * @return void
    * @author dozen.zhang
    * @date 2015年12月27日下午10:56:38
    */
    public void delete(Long  id){
    	videoHotMapper.deleteByPrimaryKey(id);
    }   
    /**
    * 说明:根据主键获取数据
    * description:delete by key
    * @param id
    * @return void
    * @author dozen.zhang
    * @date 2015年12月27日下午10:56:38
    */
    public VideoHot selectByPrimaryKey(Long id){
       return videoHotMapper.selectByPrimaryKey(id);
    }
    /**多id删除
     * @param idAry
     * @return
     * @author dozen.zhang
     */
    public ResultDTO multilDelete(Long[] idAry) {
        for(int i=0;i<idAry.length;i++){
        	videoHotMapper.deleteByPrimaryKey(idAry[i]);
        }
        return ResultUtil.getSuccResult();
    }
}
