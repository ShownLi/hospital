package com.tourmade.crm.common.framework;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public abstract class BaseService {

	protected transient Logger logger = Logger.getLogger(getClass());

}
