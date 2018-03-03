//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
package edu.aspire.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.transaction.annotation.Transactional;
import edu.aspire.domains.Customer;

public class NewCustomerController implements Controller {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional(readOnly = false)
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String cname = req.getParameter("cname").trim();
		String email = req.getParameter("email").trim();
		String mobile = req.getParameter("mobile").trim();
		
		Customer cust = new Customer();
		cust.setCname(cname);
		cust.setEmail(email);
		cust.setMobile(Long.parseLong(mobile));
		
		Integer cid = (Integer)hibernateTemplate.save(cust);
		return new ModelAndView("success", "cid", cid);
	}
}