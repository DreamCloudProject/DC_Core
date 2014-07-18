package ru.dreamcloud.core.interfaces;

public interface IService {
	
	void run();
	void stop();
	boolean status();
	String serviceName();
	String serviceSysId();

}
