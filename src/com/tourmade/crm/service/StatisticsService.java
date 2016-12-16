package com.tourmade.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
@Service
@Transactional(readOnly = false)
public class StatisticsService extends BaseService {

}
