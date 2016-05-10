package com.zoo.action.video;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awifi.core.action.BaseAction;
import com.awifi.core.page.Page;
import com.awifi.rule.Digits;
import com.awifi.rule.Length;
import com.awifi.rule.NotEmpty;
import com.awifi.rule.Rule;
import com.awifi.util.ResultUtil;
import com.awifi.util.StringUtils;
import com.awifi.util.ValidateUtil;
import com.util.RequestUtil;
import com.zoo.bean.VideoHot;
import com.zoo.bean.VideoNew;
import com.zoo.service.VideoHotService;


@Controller
@RequestMapping(value = "/videoHot")
public class VideoHotController extends BaseAction {

    /** 日志 **/
    private Logger logger = LoggerFactory.getLogger(VideoHotController.class);
    /** 权限service **/
    @Autowired
    private VideoHotService videoHotService;
    
    /**
     * 说明: 跳转到角色列表页面
     * 
     * @return
     * @return String
     * @author dozen.zhang
     * @date 2015年11月15日下午12:30:45
     */
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public String list() {
        return "/statics/html/videoHot.html";
    }

    @RequestMapping(value = "/listMapper.htm", method = RequestMethod.GET)
    public String listMapper() {
        return "/static/html/VideoHotListMapper.html";
    }

    /**
     * 说明:ajax请求角色信息
     * @return
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午12:31:55
     */
    @RequestMapping(value = "/list.json")
    @ResponseBody
    public Object list(HttpServletRequest request) {
        Page page = RequestUtil.getPage(request);
        if(page ==null){
             return this.getResult(301, "page参数错误");
        }
        
        HashMap<String,Object> params= new HashMap<String,Object>();
        String id = request.getParameter("id");
        if(!StringUtils.isBlank(id)){
            params.put("id",id);
        }
        String vname = request.getParameter("vname");
        if(!StringUtils.isBlank(vname)){
            params.put("vname",vname);
        }
        String vnameLike = request.getParameter("vnameLike");
        if(!StringUtils.isBlank(vnameLike)){
            params.put("vnameLike",vnameLike);
        }
        String zbname = request.getParameter("zbname");
        if(!StringUtils.isBlank(zbname)){
            params.put("zbname",zbname);
        }
        String zbnameLike = request.getParameter("zbnameLike");
        if(!StringUtils.isBlank(zbnameLike)){
            params.put("zbnameLike",zbnameLike);
        }
        String viewnum = request.getParameter("viewnum");
        if(!StringUtils.isBlank(viewnum)){
            params.put("viewnum",viewnum);
        }
        String url = request.getParameter("url");
        if(!StringUtils.isBlank(url)){
            params.put("url",url);
        }
        String urlLike = request.getParameter("urlLike");
        if(!StringUtils.isBlank(urlLike)){
            params.put("urlLike",urlLike);
        }
        String type = request.getParameter("type");
        if(!StringUtils.isBlank(type)){
            params.put("type",type);
        }
        String typeLike = request.getParameter("typeLike");
        if(!StringUtils.isBlank(typeLike)){
            params.put("typeLike",typeLike);
        }
        String img = request.getParameter("img");
        if(!StringUtils.isBlank(img)){
            params.put("img",img);
        }
        String imgLike = request.getParameter("imgLike");
        if(!StringUtils.isBlank(imgLike)){
            params.put("imgLike",imgLike);
        }
        String vkey = request.getParameter("vkey");
        if(!StringUtils.isBlank(vkey)){
            params.put("vkey",vkey);
        }
        String vkeyLike = request.getParameter("vkeyLike");
        if(!StringUtils.isBlank(vkeyLike)){
            params.put("vkeyLike",vkeyLike);
        }
        String vfrom = request.getParameter("vfrom");
        if(!StringUtils.isBlank(vfrom)){
            params.put("vfrom",vfrom);
        }
        params.put("page",page);
        List<VideoHot> videoHots = videoHotService.listByParams4Page(params);
        return ResultUtil.getResult(videoHots, page);
    }
    
   /**
    * 说明:ajax请求角色信息 无分页版本
    * @return Object
    * @author dozen.zhang
    * @date 2015年11月15日下午12:31:55
    */
    @RequestMapping(value = "/listAll.json")
    @ResponseBody
    public Object listAll(HttpServletRequest request) {
                HashMap<String,Object> params= new HashMap<String,Object>();
        String id = request.getParameter("id");
        if(!StringUtils.isBlank(id)){
            params.put("id",id);
        }
        String vname = request.getParameter("vname");
        if(!StringUtils.isBlank(vname)){
            params.put("vname",vname);
        }
        String vnameLike = request.getParameter("vnameLike");
        if(!StringUtils.isBlank(vnameLike)){
            params.put("vnameLike",vnameLike);
        }
        String zbname = request.getParameter("zbname");
        if(!StringUtils.isBlank(zbname)){
            params.put("zbname",zbname);
        }
        String zbnameLike = request.getParameter("zbnameLike");
        if(!StringUtils.isBlank(zbnameLike)){
            params.put("zbnameLike",zbnameLike);
        }
        String viewnum = request.getParameter("viewnum");
        if(!StringUtils.isBlank(viewnum)){
            params.put("viewnum",viewnum);
        }
        String url = request.getParameter("url");
        if(!StringUtils.isBlank(url)){
            params.put("url",url);
        }
        String urlLike = request.getParameter("urlLike");
        if(!StringUtils.isBlank(urlLike)){
            params.put("urlLike",urlLike);
        }
        String type = request.getParameter("type");
        if(!StringUtils.isBlank(type)){
            params.put("type",type);
        }
        String typeLike = request.getParameter("typeLike");
        if(!StringUtils.isBlank(typeLike)){
            params.put("typeLike",typeLike);
        }
        String img = request.getParameter("img");
        if(!StringUtils.isBlank(img)){
            params.put("img",img);
        }
        String imgLike = request.getParameter("imgLike");
        if(!StringUtils.isBlank(imgLike)){
            params.put("imgLike",imgLike);
        }
        String vkey = request.getParameter("vkey");
        if(!StringUtils.isBlank(vkey)){
            params.put("vkey",vkey);
        }
        String vkeyLike = request.getParameter("vkeyLike");
        if(!StringUtils.isBlank(vkeyLike)){
            params.put("vkeyLike",vkeyLike);
        }

        List<VideoHot> videoHots = videoHotService.listByParams(params);
        return ResultUtil.getResult(videoHots);
    }
    
    /**
     * @param request 发请求
     * @return Object
     */
    @RequestMapping(value = "/edit.htm")
    public Object edit( HttpServletRequest request) {
        // 查找所有的角色
        return "/static/html/VideoHotEdit.html";
    }
    @RequestMapping(value = "/view.htm")
    public Object viewPage( HttpServletRequest request) {
        return "/static/html/VideoHotView.html";
    }
   
    @RequestMapping(value = "/view.json")
    @ResponseBody
    public Object view(HttpServletRequest request) {
            String id = request.getParameter("id");
        HashMap<String,Object> result =new HashMap<String,Object>();
        if(!StringUtils.isBlank(id)){
            VideoHot bean = videoHotService.selectByPrimaryKey(Long.valueOf(id));
            result.put("bean", bean);
        }
        return this.getResult(result);

      /*  String id = request.getParameter("id");
        VideoNew bean = videoNewService.selectByPrimaryKey(Long.valueOf(id));
        HashMap<String,Object> result =new HashMap<String,Object>();
        result.put("bean", bean);
        return this.getResult(bean);*/
    }

    
    /**
     * 说明:保存角色信息
     * 
     * @param request
     * @return
     * @throws Exception
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午1:33:00
     */
    // @RequiresPermissions(value={"auth:edit" ,"auth:add" },logical=Logical.OR)
    @RequestMapping(value = "/save.json")
    @ResponseBody
    public Object save(HttpServletRequest request) throws Exception {
        VideoHot videoHot =new  VideoHot();
        /*
        String id = request.getParameter("id");
        if(!StringUtils.isBlank(id)){
            videoNew.setId(Long.valueOf(id)) ;
        }
        
        String vname = request.getParameter("vname");
        if(!StringUtils.isBlank(vname)){
            videoNew.setVname(String.valueOf(vname)) ;
        }
        
        String zbname = request.getParameter("zbname");
        if(!StringUtils.isBlank(zbname)){
            videoNew.setZbname(String.valueOf(zbname)) ;
        }
        
        String viewnum = request.getParameter("viewnum");
        if(!StringUtils.isBlank(viewnum)){
            videoNew.setViewnum(Integer.valueOf(viewnum)) ;
        }
        
        String url = request.getParameter("url");
        if(!StringUtils.isBlank(url)){
            videoNew.setUrl(String.valueOf(url)) ;
        }
        
        String type = request.getParameter("type");
        if(!StringUtils.isBlank(type)){
            videoNew.setType(String.valueOf(type)) ;
        }
        
        String img = request.getParameter("img");
        if(!StringUtils.isBlank(img)){
            videoNew.setImg(String.valueOf(img)) ;
        }
        
        String vkey = request.getParameter("vkey");
        if(!StringUtils.isBlank(vkey)){
            videoNew.setVkey(String.valueOf(vkey)) ;
        }
        */
        String id = request.getParameter("id");
        if(!StringUtils.isBlank(id)){
        	videoHot.setId(Long.valueOf(id));
        }
        String vname = request.getParameter("vname");
        if(!StringUtils.isBlank(vname)){
        	videoHot.setVname(vname);
        }
        String zbname = request.getParameter("zbname");
        if(!StringUtils.isBlank(zbname)){
        	videoHot.setZbname(zbname);
        }
        String viewnum = request.getParameter("viewnum");
        if(!StringUtils.isBlank(viewnum)){
        	videoHot.setViewnum(Integer.valueOf(viewnum));
        }
        String url = request.getParameter("url");
        if(!StringUtils.isBlank(url)){
        	videoHot.setUrl(url);
        }
        String type = request.getParameter("type");
        if(!StringUtils.isBlank(type)){
        	videoHot.setType(type);
        }
        String img = request.getParameter("img");
        if(!StringUtils.isBlank(img)){
        	videoHot.setImg(img);
        }
        String vkey = request.getParameter("vkey");
        if(!StringUtils.isBlank(vkey)){
        	videoHot.setVkey(vkey);
        }

        //valid
        ValidateUtil vu = new ValidateUtil();
        String validStr="";
        vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
        vu.add("vname", vname, "视频名称",  new Rule[]{new Length(50),new NotEmpty()});
        vu.add("zbname", zbname, "主播名称",  new Rule[]{new Length(50),new NotEmpty()});
        vu.add("viewnum", viewnum, "视频类型",  new Rule[]{new Digits(10,0)});
        vu.add("url", url, "视屏url",  new Rule[]{new Length(300)});
        vu.add("type", type, "视屏url",  new Rule[]{new Length(10)});
        vu.add("img", img, "视频图片",  new Rule[]{new Length(100)});
        vu.add("vkey", vkey, "视频主键",  new Rule[]{new Length(50)});
        validStr = vu.validateString();
        if(StringUtils.isNotEmpty(validStr)) {
            return ResultUtil.getResult(302,validStr);
        }

        return videoHotService.save(videoHot);
       
    }

    @RequestMapping(value = "/del.json")
    @ResponseBody
    public Object delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        if(StringUtils.isBlank(idStr)){
            return this.getResult(301,"参数不能为空");
        }
        Long id = Long.valueOf(idStr);
        videoHotService.delete(id);
        return this.getResult(SUCC);
    }
     /**
     * 多行删除
     * @param request
     * @return
     * @author dozen.zhang
     */
    @RequestMapping(value = "/mdel.json")
    @ResponseBody
    public Object multiDelete(HttpServletRequest request) {
        String idStr = request.getParameter("ids");
        if(StringUtils.isBlank(idStr)){
            return this.getResult(302, "参数不能为空");
        }
        String idStrAry[]= idStr.split(",");
        Long idAry[]=new Long[idStrAry.length];
        for(int i=0,length=idAry.length;i<length;i++){
            ValidateUtil vu = new ValidateUtil();
            String validStr="";
            String id = idStrAry[i];
                    vu.add("id", id, "主键",  new Rule[]{});

            try{
                validStr=vu.validateString();
            }catch(Exception e){
                e.printStackTrace();
                validStr="验证程序异常";
                return ResultUtil.getResult(302,validStr);
            }
            
            if(StringUtils.isNotEmpty(validStr)) {
                return ResultUtil.getResult(302,validStr);
            }
            idAry[i]=Long.valueOf(idStrAry[i]);
        }
       return  videoHotService.multilDelete(idAry);
    }

   
}
