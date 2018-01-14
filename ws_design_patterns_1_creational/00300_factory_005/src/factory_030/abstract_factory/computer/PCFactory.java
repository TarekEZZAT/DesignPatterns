package factory_030.abstract_factory.computer;

import factory_030.abstract_factory.Computer;
import factory_030.abstract_factory.ComputerAbstractFactory;
import factory_030.abstract_factory.PC;

public class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public PCFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	@Override
	public Computer createComputer() {
		return new PC(ram,hdd,cpu);
	}

}