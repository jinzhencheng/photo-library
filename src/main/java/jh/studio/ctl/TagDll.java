package jh.studio.ctl;

import java.util.List;

import com.google.gson.Gson;

import jh.studio.condition.TagCond;
import jh.studio.dal.TagDal;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;

public class TagDll {
	public String show(){
		String name="";
		Condition condition=new TagCond(name); 
		Pagination page=new Pagination();
		TagDal dal=new TagDal();
		List<Tag> list=dal.search(condition, page);
		dal.dispose();
		Gson gson=new Gson();
		String listJson=gson.toJson(list);
		return listJson;
	}
}
