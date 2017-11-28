package com.lanyuan.controller.business;


import com.lanyuan.controller.index.BaseController;
import com.lanyuan.entity.business.CompanyFormMap;
import com.lanyuan.entity.business.InspectionRecordFormMap;
import com.lanyuan.entity.business.PackageFormMap;
import com.lanyuan.mapper.business.CompanyMapper;
import com.lanyuan.mapper.business.InspectionRecordMapper;
import com.lanyuan.mapper.business.PackageMapper;
import com.lanyuan.plugin.PageView;
import com.lanyuan.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lanyuan 2014-11-19+
 * @version 3.0v
 * @Email: mmm333zzz520@163.com
 */
@Controller
@RequestMapping("/inspection/")
public class InspectionRecordController extends BaseController {

    @Inject
    private InspectionRecordMapper inspectionRecordMapper;

    @Inject
    private PackageMapper packageMapper;

    @Inject
    private CompanyMapper companyMapper;

    @RequestMapping("list")
    public String listUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/business/inspection/list";
    }

    @ResponseBody
    @RequestMapping("findByPage")
    public PageView findByPage(HttpServletRequest request, String pageNow, String pageSize, String column, String sort) throws Exception {
        InspectionRecordFormMap inspectionRecordFormMap = getFormMap(InspectionRecordFormMap.class);
        inspectionRecordFormMap = toFormMap(inspectionRecordFormMap, pageNow, pageSize, inspectionRecordFormMap.getStr("orderby"));
        inspectionRecordFormMap.put("column", column);
        inspectionRecordFormMap.put("sort", sort);
        pageView.setRecords(inspectionRecordMapper.findByPage(inspectionRecordFormMap));//不调用默认分页,调用自已的mapper中findByPage
        return pageView;
    }

    @RequestMapping("putRecord")
    @ResponseBody
    public String putRecord(HttpServletRequest request) {

        try {

            String weight = request.getParameter("weight");
            String barcode = request.getParameter("barcode");

            if (barcode != null && !"".equals(barcode)&&weight != null && !"".equals(weight)) {

                String organization_code = barcode.substring(0, 9);
                String batch = barcode.substring(9, 20);
                String package_code = barcode.substring(20, 24).replace("0","");
                String quantity = barcode.substring(24, barcode.length());

                InspectionRecordFormMap inspectionRecordFormMap = getFormMap(InspectionRecordFormMap.class);
                inspectionRecordFormMap.put("organization_code", organization_code);
                inspectionRecordFormMap.put("batch", batch);
                inspectionRecordFormMap.put("product_quantity", quantity);
                inspectionRecordFormMap.put("package_code", package_code);


                PackageFormMap packageFormMap = getFormMap(PackageFormMap.class);
                packageFormMap.put("package_code_reversed", package_code);
                List<PackageFormMap> packageFormMaps = packageMapper.findByMap(packageFormMap);

                if (packageFormMaps.size() > 0) {
                    PackageFormMap temp = packageFormMaps.get(0);
                    inspectionRecordFormMap.put("package_type", temp.get("package_type"));
                    inspectionRecordFormMap.put("package_material", temp.get("package_material"));
                    inspectionRecordFormMap.put("package_cover", temp.get("package_cover"));
                }

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                inspectionRecordFormMap.put("inspection_time", dateString);
                inspectionRecordFormMap.put("inspection_weight", Float.parseFloat(weight));

                List<CompanyFormMap> companyFormMaps = companyMapper.findByAttribute("organization_code", organization_code, CompanyFormMap.class);
                if (companyFormMaps.size() > 0)
                    inspectionRecordFormMap.put("company_name", companyFormMaps.get(0).get("company_name"));
                else
                    inspectionRecordFormMap.put("company_name", "查无该企业");

                inspectionRecordMapper.addEntity(inspectionRecordFormMap);
                return  "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("recordGenerate")
    public String recordGenerate(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/business/inspection/recordGenerate";
    }


}