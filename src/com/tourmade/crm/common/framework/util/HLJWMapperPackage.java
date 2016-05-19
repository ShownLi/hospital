package com.tourmade.crm.common.framework.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HLJWMapperPackage {
	public abstract java.lang.String value() default "";
}
