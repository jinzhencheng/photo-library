package jh.studio.test;

import java.util.ArrayList;
import java.util.List;

import jh.studio.dal.PhotoAgentDal;
import jh.studio.entity.PhotoAgent;
import junit.framework.TestCase;

public class PhotoAgentDalTest extends TestCase{

	public void testPhotoDal(){
		List<PhotoAgent> list=new ArrayList<PhotoAgent>();
		list.add(new PhotoAgent(0,1,47));
		list.add(new PhotoAgent(0,1,48));
		PhotoAgentDal dal=new PhotoAgentDal();
		dal.batchAdd(list);
		dal.dispose();
		
	}
}
