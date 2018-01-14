package factory_030.abstract_factory.test;

import factory_030.abstract_factory.Computer;
import factory_030.abstract_factory.computer.PCFactory;
import factory_030.abstract_factory.computer.ServerFactory;
import factory_030.abstract_factory.factory.ComputerFactory;

public class TestDrive {

	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
		System.out.println("AbstractFactory PC Config::"+pc);
		System.out.println("AbstractFactory Server Config::"+server);
	}
}