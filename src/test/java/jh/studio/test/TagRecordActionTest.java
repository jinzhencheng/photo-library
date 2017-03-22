package jh.studio.test;

import java.util.List;

import org.junit.Assert;

import jh.studio.dal.PhotoAgentDal;
import jh.studio.dal.RecordDal;
import jh.studio.dal.TagDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.Record;
import jh.studio.entity.Tag;
import junit.framework.TestCase;

public class TagRecordActionTest extends TestCase{
	
	public void testListPhotoByTagName(){
		String searchName = "h";
		String userId = "1";
		PhotoAgentDal paDal = new PhotoAgentDal();
		List<Photo> list = paDal.getPhotoByTagName(searchName, Pagination.NULL);
		for(Photo p:list)
		{
			System.out.println(p.getPath());
		}
		paDal.dispose();
		
		RecordDal rDal = new RecordDal();
		Record r = new Record();
		r.setContent(searchName);
		r.setUserId(Integer.parseInt(userId));
		rDal.add(r);
		rDal.dispose();
	}
}
