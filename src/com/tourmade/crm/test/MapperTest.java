package com.tourmade.crm.test;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.mysql.jdbc.Connection;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.mapper.crmcase.CaseMapper;

public class MapperTest {
    ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    CaseMapper caseMapper=(CaseMapper)factory.getBean("caseMapper");
    
    Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
    Connection conn  = DriverManager.getConnection("proxool.别名:driver:url","用户名","密码");
    
    @Test
    public void Casetest(){
    	Customer customer = new Customer();
    	customer.setChineseName("奥斯卡了国际");
    	customer.setEnglishName("sakgk");
    	customer.setCustomerId(45486);
    	caseMapper.updateCustomer(customer);
    }
}
