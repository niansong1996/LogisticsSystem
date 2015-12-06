package edu.nju.lms.data;

public enum City {
	北京(1),上海(2),广州(3),南京(4);
	
	private int value=0;
	
	private City(int value){
		this.value=value;
	}
	
	public int value(){
		return this.value;
	}
	
	public static int returnValue(String name){
		City temp=City.valueOf(name);
		return temp.value;
	}
	
	public static City valueof(int value){
		switch(value){
			case 1:
				return 北京;
			case 2:
				return 上海;
			case 3:
				return 广州;
			case 4:
				return 南京;
			default:
				return null;
		}
	}
}
