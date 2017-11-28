package com.lanyuan.controller.business;


import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.business.PackageFormMap;
import com.lanyuan.mapper.business.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/package/")
public class PackageController extends BaseController {

	@Inject
	private PackageMapper packageMapper;


}