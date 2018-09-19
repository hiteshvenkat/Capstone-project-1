package com.shop.ShopBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.shop.Config.DBConfig;
import com.shop.DAO.DealDAO;
import com.shop.Model.Deal;

import junit.framework.TestCase;

public class DealTestCase extends TestCase {
	AbstractApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	DealDAO dealDAO=(DealDAO) context.getBean("dealDAO");
	
	public void testAddDeal() {
		Deal deal= new Deal();
		deal.setdId("D10");
		deal.setdDesc("Samsung S7 at no interest");
		deal.setdDisc("0% intertest for ICICI card payers");
		assertEquals(true,dealDAO.AddDeal(deal));
	}
	
	public void testFindUserById() {
		Deal deal1=dealDAO.findDealById("D101");
		assertNotNull(deal1);
		String eid="D101";
		String aid=deal1.getdId();
		assertTrue(eid.equals(aid));
	}
	
	public void testUpdateDeal() {
		Deal deal2=dealDAO.findDealById("D101");
		deal2.setdDisc("25% for all mobiles");
		assertTrue(deal2.getdId().equals("D101"));
		dealDAO.UpdateDeal(deal2);
	}
	public void testDeleteDeal() {
		Deal deal3=dealDAO.findDealById("D103");
		assertEquals(true,dealDAO.deleteDeal(deal3.getdId()));
	}
}
