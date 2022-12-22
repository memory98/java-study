package prob3;

public class Duck extends Bird {
	public void fly() {
		System.out.println("오리("+name+")가 날지 않습니다.");
	}
	
	@Override
	public String toSting() {
		// TODO Auto-generated method stub
		return "오리의 이름은 "+name+" 입니다.";
	}
}
