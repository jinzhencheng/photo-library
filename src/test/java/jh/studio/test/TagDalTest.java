package jh.studio.test;

import java.util.List;

import org.junit.Assert;

import jh.studio.dal.TagDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import junit.framework.TestCase;

public class TagDalTest extends TestCase{

	public void testGetCategory(){

	}

	public void testFetchAll(){
		Pagination page=new Pagination();
		TagDal dal=new TagDal();
		List<Tag> list=dal.getAll(page);
		dal.dispose();
		System.out.println(list.size());
		System.out.println(page.getTotal());
		Assert.assertNotNull(list);
	}
	public void testGetOne(){
		int id=1;
		TagDal dal=new TagDal();
		Tag tag=dal.getOne(id);
		dal.dispose();
		Assert.assertNotNull(tag);
	}
	
	public void testGetAll(){
		TagDal dal=new TagDal();
		List<Tag> list=dal.getAll(null);
		dal.dispose();
		Assert.assertNotNull(list);
	}
}
