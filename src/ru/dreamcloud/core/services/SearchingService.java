package ru.dreamcloud.core.services;

import ru.dreamcloud.core.interfaces.IService;

public class SearchingService implements IService {
	
	private boolean status = false;
	private String serviceName = "Сервис поисковых запросов";
	private String serviceSysId = "srvc_Search";
	
    private static SearchingService instance;
    
    public static synchronized SearchingService getInstance() {
        if (instance == null) {
            instance = new SearchingService();
        }
        return instance;
    }
    
    private SearchingService(){    	
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
		return serviceName;
	}

	@Override
	public String serviceSysId() {
		// TODO Auto-generated method stub
		return serviceSysId;
	}

}
