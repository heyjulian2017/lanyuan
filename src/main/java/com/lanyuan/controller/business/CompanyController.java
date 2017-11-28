package com.lanyuan.controller.business;


import com.lanyuan.annotation.SayName;
import com.lanyuan.annotation.SystemLog;
import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.business.CompanyFormMap;
import com.lanyuan.mapper.business.CompanyMapper;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/company/")
public class CompanyController extends BaseController {

	@Inject
	private CompanyMapper companyMapper;

	@RequestMapping("test")
	@SayName(name="ln")
	public String test(Model model) throws Exception {

		System.out.println("111###################################");
		return "hi###########################";
	}

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/business/company/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(HttpServletRequest request,String pageNow, String pageSize, String column, String sort) throws Exception {
		CompanyFormMap companyFormMap = getFormMap(CompanyFormMap.class);
		companyFormMap=toFormMap(companyFormMap, pageNow, pageSize,companyFormMap.getStr("orderby"));
		companyFormMap.put("column", column);
		companyFormMap.put("sort", sort);
//		String locked = request.getParameter("locked");
//		if(locked!=null&&!"".equals(locked)) {
//			companyFormMap.put("locked", 1);
//		}
        pageView.setRecords(companyMapper.findByPage(companyFormMap));//不调用默认分页,调用自已的mapper中findByPage
        return pageView;
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/business/company/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module="业务功能管理",methods="业务功能管理-新增企业信息")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addEntity(){
		try {
			CompanyFormMap companyFormMap = getFormMap(CompanyFormMap.class);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = sdf.format(date);
			companyFormMap.put("create_time",dateString);
//		if("2".equals(resFormMap.get("type"))){
//			resFormMap.put("description", Common.htmltoString(resFormMap.get("description")+""));
//		}
//		Object o = resFormMap.get("ishide");
//		if(null==o){
//			resFormMap.set("ishide", "0");
//		}
			companyMapper.addEntity(companyFormMap);
		}
		catch (Exception e){

		}
		return "success";
	}

	/**
	 * 验证组织机构代码是否存在
	 *
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-2-19
	 * @param organization_code
	 * @return
	 */
	@RequestMapping("isExistOrganization_code")
	@ResponseBody
	public boolean isExistOrganization_code(String organization_code) {
		CompanyFormMap account = companyMapper.findbyFrist("organization_code", organization_code, CompanyFormMap.class);
		if (account == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证检验检疫代码是否存在
	 *
	 * @author lanyuan Email：mmm333zzz520@163.com date：2014-2-19
	 * @param inspection_code
	 * @return
	 */
	@RequestMapping("isExistInspection_code")
	@ResponseBody
	public boolean isExistInspection_code(String inspection_code) {
		CompanyFormMap account = companyMapper.findbyFrist("inspection_code", inspection_code, CompanyFormMap.class);
		if (account == null) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("company", companyMapper.findbyFrist("id", id, CompanyFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/business/company/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理-修改用户")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
        CompanyFormMap companyFormMap = getFormMap(CompanyFormMap.class);
        companyMapper.editEntity(companyFormMap);
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="用户管理-删除用户")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			companyMapper.deleteByAttribute("id", id, CompanyFormMap.class);
		}
		return "success";
	}

}