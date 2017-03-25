package jh.studio.test;

import java.util.List;

import jh.studio.dal.CollectionDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import junit.framework.TestCase;

public class CollectionTest extends TestCase{
	public void testList(){
		int userId=1;
		Pagination page=new Pagination();
		page.setPage(1);
		CollectionDal dal=new CollectionDal();
		List<Photo> list=dal.list(userId, page);
		dal.dispose();
		for(Photo p:list){
			System.out.println(p.getName());
		}
	}
}
