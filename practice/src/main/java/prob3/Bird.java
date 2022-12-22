package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sing() {
		System.out.println("오리("+name+")가  소리내어 웁니다.");

	}
	
	public abstract String toSting();
	
	public abstract void fly();

}