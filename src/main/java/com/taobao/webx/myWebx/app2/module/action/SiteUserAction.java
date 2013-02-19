package com.taobao.webx.myWebx.app2.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.Form;
import com.alibaba.citrus.service.form.FormService;
import com.alibaba.citrus.service.form.Group;
import com.alibaba.citrus.service.requestcontext.rundata.RunData;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.taobao.webx.myWebx.app2.SiteUser;

public class SiteUserAction {
    @Autowired
    private FormService formService; 
    
    public void doRegister(TurbineRunData rundata, Navigator nav, Context context) throws Exception {
        Form form = formService.getForm(); 

        if (form.isValid()) { 
            Group group = form.getGroup("register"); 

            SiteUser user = new SiteUser(); 
            group.setProperties(user); 
            //FIXME
            //save(user);
            System.out.println(user.toString());

            String location="http://localhost:8081/form/welcome.htm";//?id="
                   // + user.getId() + "&new_user=true";
            context.put("newUser", user);
			// 跳转到注册成功页面
//            nav.redirectToLocation(location);
            //nav.forwardTo("form/welcome"); //ok
            
            //nav.redirectTo("app2Link").withTarget("form/viewUser").withParameter("id", user.getId()); //not ok
            //rundata.setRedirectTarget("form/viewUser"); //ok
            nav.forwardTo("form/viewUser"); //ok
        }
    }
}
