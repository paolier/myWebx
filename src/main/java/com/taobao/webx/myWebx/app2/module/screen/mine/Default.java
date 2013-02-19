package com.taobao.webx.myWebx.app2.module.screen.mine;

import java.util.Date;

import com.alibaba.citrus.turbine.Context;

public class Default {
	public void execute(Context context){
		context.put("date", new Date());
	}
}
