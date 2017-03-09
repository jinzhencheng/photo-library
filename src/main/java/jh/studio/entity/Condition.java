package jh.studio.entity;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description 查询条件父类
 */
public class Condition {
	private String name;
	
	protected Condition(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	
}
