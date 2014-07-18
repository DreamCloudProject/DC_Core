package ru.dreamcloud.core.services;

import ru.dreamcloud.core.interfaces.IService;
import ru.dreamcloud.storage.DC_Storage;

public class StorageService implements IService {
	
	private boolean status = false;
	private String serviceName = "Сервис хранилища";
	private String serviceSysId = "srvc_Storage";
	
	private static DC_Storage storage;
	
    private static StorageService instance;
    
    public static synchronized StorageService getInstance() {
        if (instance == null) {
            instance = new StorageService();
        }
        return instance;
    }
    
    private StorageService(){
    	storage = new DC_Storage();
    }

	@Override
	public void run() {
		status = true;    	
		System.out.println(serviceName + " стартован!");
		storage.initEnvironment("D:/_work/projects/DC_Core/berkeleyDB/dcbase");
	}
	
	public DC_Storage getStorage() {
		return storage;
	}

	@Override
	public void stop() {
		status = false;
		storage.closeAllDataSources();
		storage.closeEnvironment();
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
