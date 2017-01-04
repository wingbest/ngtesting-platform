package cn.mobiu.events.action.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mobiu.events.constants.Constant;
import cn.mobiu.events.entity.EvtClient;
import cn.mobiu.events.service.UserService;
import cn.mobiu.events.util.AuthPassport;


@Controller
@RequestMapping(Constant.API_PATH_CLIENT + "user/")
public class UserAction extends BaseAction {
	@Autowired
	UserService userService;
	
	@AuthPassport(validate = true)
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getEvent(HttpServletRequest request, @RequestBody Map<String, Object> json) {
		Map<String, Object> ret = new HashMap<String, Object>();

		String eventId = json.get("eventId").toString();
		EvtClient client = (EvtClient) request.getSession().getAttribute(Constant.HTTP_SESSION_CLIENT_KEY);
		

		ret.put("code", Constant.RespCode.SUCCESS.getCode());
		return ret;
	}


}
