package com.lanyuan.controller.business;

import com.lanyuan.controller.index.BaseController;
import com.lanyuan.util.Common;
import org.apache.commons.lang.StringUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/barcode/")
public class BarCodeController extends BaseController {

	/**
	 * 生成条形码
	 *
	 */
	@RequestMapping("listUI")
	public String listUI() {
		return Common.BACKGROUND_PATH + "/business/barCode/list";
	}

	@RequestMapping("generateBarcode")
	public void generateBarcode(HttpServletResponse response,
								@RequestParam(value="organization_code") String organization_code,
								@RequestParam(value="batch") String batch,
								@RequestParam(value="quantity") String quantity,
								@RequestParam(value="package_code") String package_code
								) throws IOException {

		response.reset(); // 必要地清除response中的缓存信息
		response.setContentType("application/OCTET-STREAM;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(("条形码" + ".png").getBytes(), "iso-8859-1"));
		String msg = "";
		if(package_code!=null&&!"".equals(package_code)) {
			int j = 4 - package_code.length();
			for(int i=0 ; i < j ; i++){
				package_code += "0";
			}
			msg = organization_code+batch+package_code+quantity;
//			msg = organization_code;
		}
		ServletOutputStream ous = response.getOutputStream();
		if (StringUtils.isEmpty(msg) || ous == null) {
			return;
		}

		//编码规则
		Code128Bean bean = new Code128Bean();
//		Code39Bean bean = new Code39Bean();

		// 精细度
		final int dpi = 150;
		// module宽度
		final double moduleWidth = UnitConv.in2mm(2.0f / dpi);

		// 配置对象
		bean.setModuleWidth(moduleWidth);
//		bean.setWideFactor(3);
		bean.doQuietZone(false);

		String format = "image/png";
		try {

			//输出到流
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

			// 生成条形码
			bean.generateBarcode(canvas, msg);

			// 结束绘制
			canvas.finish();

			ous.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}