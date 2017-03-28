package jh.studio.test;

import java.util.List;
import java.util.Map;

import jh.studio.dal.PhotoDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import junit.framework.TestCase;

public class PhotoDalTest extends TestCase{
	
	public void testFetchYearAndMonth(){
		PhotoDal dal=new PhotoDal();
		Map<String,List<String>> map=dal.fetchYearAndMonth();
		dal.dispose();
	}
	public void testGetYear()
	{
		PhotoDal pDal = new PhotoDal();
		List<String> list = pDal.getYear(Pagination.NULL);
		for(String p:list)
		{
			System.out.println(p);
		}
	}
	
	public void testGetMonth()
	{
		PhotoDal pDal = new PhotoDal();
		List<String> list = pDal.getMonth(Pagination.NULL,"2017");
		for(String p:list)
		{
			System.out.println(p);
		}
	}
	
	public void testGetPicture()
	{
		PhotoDal pDal = new PhotoDal();
		List<Photo> list = pDal.getPicture(Pagination.NULL,"2017","05");
		for(Photo p:list)
		{
			System.out.println(p.getId());
		}
	}
}
