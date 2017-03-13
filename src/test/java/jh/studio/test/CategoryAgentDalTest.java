package jh.studio.test;

import jh.studio.dal.CategoryAgentDal;
import junit.framework.TestCase;

public class CategoryAgentDalTest extends TestCase{

	public void testIt(){
		int tagId=2;
		CategoryAgentDal dal=new CategoryAgentDal();
		dal.deleteByTag(tagId);
		dal.dispose();
		
	}
}
