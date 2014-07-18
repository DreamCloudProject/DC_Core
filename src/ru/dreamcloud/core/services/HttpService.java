package ru.dreamcloud.core.services;

import java.util.Properties;

import ru.dreamcloud.core.interfaces.IService;

public class HttpService implements IService{
	
	private boolean status = false;
	private String serviceName = "Сервис HTTP протокола";
	private String serviceSysId = "srvc_Http";
	
	public static Properties properties;
	
	private static HttpService instance;
    
    public static synchronized HttpService getInstance() {
        if (instance == null) {
            instance = new HttpService();
        }
        return instance;
    }
    
    private HttpService(){
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
		// TODO Auto-generated method stub
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
