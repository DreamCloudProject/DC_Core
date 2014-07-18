package ru.dreamcloud.core.services;

import ru.dreamcloud.core.interfaces.IService;

public class IndexingService implements IService {
	
	private boolean status = false;
	private String serviceName = "Сервис индексации";
	private String serviceSysId = "srvc_Index";
	
    private static IndexingService instance;
    
    public static synchronized IndexingService getInstance() {
        if (instance == null) {
            instance = new IndexingService();
        }
        return instance;
    }
    
    private IndexingService(){    	
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
