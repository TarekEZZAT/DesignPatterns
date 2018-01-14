
public class Subscriber implements Observer{
	
	private String name;
	private Observable topic;
	
	public Subscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate( this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}

	public void setSubject(Observable sub) {
		this.topic=sub;
	}

}