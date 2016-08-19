package net.busonline.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.busonline.api.model.vo.BusLine;
import net.busonline.api.service.IBusGatherService;
import net.busonline.core.model.Response;
import net.busonline.core.util.HttpUtil;

@Controller
@RequestMapping("/iBusGather")
public class IBusGatherController {
	@Autowired
	private IBusGatherService iBusGatherService;
	/**
	 * 线路批量上传功能
	 * @param busLine
	 * @return
	 */
	@RequestMapping("/upload")
	public @ResponseBody Response upload(@RequestBody BusLine busLine)throws Exception{
		return iBusGatherService.insertBusInfo(busLine);
	}
	/**
	 * 返回采集过的线路名称
	 * @param request
	 * @return
	 */
	@RequestMapping("/busName")
	public @ResponseBody Response getBusNames(HttpServletRequest request)throws Exception{
		return iBusGatherService.finBusLineInfo(HttpUtil.convert(request));
	}
	/**
	 * 返回字典信息(城市，网段)
	 * @param request
	 * @return
	 */
	@RequestMapping("/dictionary")
	public @ResponseBody Response getDictionary(HttpServletRequest request)throws Exception{
		return iBusGatherService.findBusDictionary(HttpUtil.convert(request));
	}
	/**
	 * 验证线路名称
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/validate")
	public @ResponseBody Response validateBusLineName(HttpServletRequest request)throws Exception{
		return iBusGatherService.validateBusLineName(HttpUtil.convert(request));
	}
	
}
