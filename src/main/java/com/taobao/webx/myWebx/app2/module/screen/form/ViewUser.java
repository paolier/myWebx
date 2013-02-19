/*
 * Copyright (c) 2002-2012 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.taobao.webx.myWebx.app2.module.screen.form;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.taobao.webx.myWebx.app2.SiteUser;

public class ViewUser {
    public void execute(TurbineRunData rundata, Context context) {

    	SiteUser user = null;
    	if(context.containsKey("newUser")){
    		user = (SiteUser) context.get("newUser");
    		context.put("newUser", Boolean.TRUE);
    	}
        if(user == null){
        	String userId = rundata.getParameters().getString("id");
        	
        	// FIXME! 从数据库中读userId。
        	user = new SiteUser();
            user.setId(userId);
            user.setPassword("helloworld");
            user.setName("Michael Zhou");
            user.setEmail("zyh@alibaba-inc.com");
            user.setDescription("Hello!");
        }

        context.put("user", user);

    }
}
