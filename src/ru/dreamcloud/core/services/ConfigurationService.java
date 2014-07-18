package ru.dreamcloud.core.services;

import java.util.Properties;

import ru.dreamcloud.core.interfaces.IService;

public class ConfigurationService implements IService {

	private boolean status = false;
	private String serviceName = "Сервис конфигурации";
	private String serviceSysId = "srvc_Config";
	
	public static Properties properties;
	
    private static ConfigurationService instance;
    
    public static synchronized ConfigurationService getInstance() {
        if (instance == null) {
            instance = new ConfigurationService();
        }
        return instance;
    }
    
    private ConfigurationService(){
    	properties = new Properties();
    }
    
	@Override
	public void run() {
		status = true;
		System.out.println(serviceName + " стартован!");		
	}

	@Override
	public void stop() {
		status = false;		
		System.out.println(serviceName + " остановлен!");
	}

	@Override
	public boolean status() {
		return status;		
	}

	@Override
	public String serviceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}

	@Override
	public String serviceSysId() {
		// TODO Auto-generated method stub
		return serviceSysId;
	}

}
