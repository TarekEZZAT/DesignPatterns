
package factory_030.abstract_factory.computer;

import factory_030.abstract_factory.Computer;
import factory_030.abstract_factory.ComputerAbstractFactory;
import factory_030.abstract_factory.Server;

public class ServerFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public ServerFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public Computer createComputer() {
		return new Server(ram,hdd,cpu);
	}

}