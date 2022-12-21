package tv;

public class TV {
	private int channel; // (1~255)
	private int volume; // 0~100
	private boolean power;
	
	public TV(int channel,int volume,boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		this.channel = channel;
		if(this.channel>255) this.channel =1;
		else if(this.channel<1) this.channel = 255;
	}
	public void channel(boolean up) {
		if(up) {
			this.channel+=1;
			if(this.channel>255) this.channel =1 ;
		} else {
			this.channel-=1;
			if(this.channel<0) this.channel=255;
		}

	}
	public void volume(int volume) {
		this.volume = volume;
		if(this.volume>100) this.volume =0;
	}
	
	public void volume(boolean up) {
		if(up) {
			this.volume+=1;
			if(this.volume>100) this.volume =0 ;
		} else {
			this.volume-=1;
			if(this.volume<0) this.volume=100;
		}

	}
	public void status() {
		System.out.println("TV[power="+(power?"on":"off")+", channel="+channel+", volume="+volume+"]");
	}
}
