package factory_030.abstract_factory.factory;

import factory_030.abstract_factory.Computer;
import factory_030.abstract_factory.ComputerAbstractFactory;

public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}
