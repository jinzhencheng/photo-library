package jh.studio.test;

import java.util.List;

import jh.studio.dal.CollectionDal;
import jh.studio.entity.Collection;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import junit.framework.TestCase;

public class CollectionActionTest extends TestCase{
	public void testInsertCollect()
	{
		Collection c = new Collection();
		c.setPhotoId(5);
		c.setUserId(1);
		CollectionDal cDal = new CollectionDal();
		cDal.add(c);
		cDal.dispose();
	}
	
	public void testListByCollect()
	{
		CollectionDal cDal = new CollectionDal();
		List<Photo> list = cDal.list(1, Pagination.NULL);
		for(Photo p:list)
		{
			System.out.println(p.getId());
		}
		cDal.dispose();
	}
}
