package com.nt.bpp;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBO;

@Component("bpp")
public class BODOJBeanPostProccessor implements BeanPostProcessor {
	
	public BODOJBeanPostProccessor() {
		System.out.println("BODOJBeanPostProcessor:0-param constructor");
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanid) throws BeansException {
		System.out.println("BPP::postProcessAfterInitialization(-,-)-->bean class"+bean.getClass());
		if(bean instanceof BaseBO){
			((BaseBO) bean).setDoj(new Date());
		}
		return bean;
	}

}
