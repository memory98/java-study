package prob3;

public class Sparrow extends Bird {
	public void fly() {
		System.out.println("참새("+name+")가 날아다닙니다.");
	}
	
	@Override
	public String toSting() {
		// TODO Auto-generated method stub
		return "참새의 이름은 "+name+" 입니다.";
	}
}
