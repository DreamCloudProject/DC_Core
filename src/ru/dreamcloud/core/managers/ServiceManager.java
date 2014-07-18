package ru.dreamcloud.core.managers;

import java.util.ArrayList;
import java.util.List;

import ru.dreamcloud.core.interfaces.IService;
import ru.dreamcloud.core.services.ConfigurationService;
import ru.dreamcloud.core.services.HttpService;
import ru.dreamcloud.core.services.IndexingService;
import ru.dreamcloud.core.services.SearchingService;
import ru.dreamcloud.core.services.StorageService;

public class ServiceManager {

	private List<IService> services;
	
	public ServiceManager() {
		services = new ArrayList<IService>();
		
		registerService(ConfigurationService.getInstance());
		registerService(StorageService.getInstance());
		registerService(IndexingService.getInstance());
		registerService(SearchingService.getInstance());
		registerService(HttpService.getInstance());


	}

	public void runAll() {
		for (IService service : services) {
			runService(service);
		}
	}

	public void runService(IService service) {
		if (services.contains(service)) {
			if (!service.status()) {
				service.run();
			} else {
				System.out.println(service.serviceName() + " уже запущен!");
			}
		} else {
			System.out.println(service.serviceName() + " с таким именем не зарегистрирован!");
		}
	}
	
	public IService getService(int PID) {		
		try {
			return services.get(PID);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("По данному PID нет зарегистрированных сервисов!");
			return null;
		}		
	}

	public void stopService(IService service) {
		if (service.status()) {
			service.stop();
		} else {
			System.out.println(service.serviceName() + " не запущен!");
		}
	}

	public void registerService(IService service) {
		if (!services.contains(service)) {
			services.add(service);
		} else {
			System.out.println(service.serviceName() + " уже зарегистрирован!");
		}
	}

	public void unregisterService(IService service) {
		if (services.contains(service)) {
			services.remove(service);
		} else {
			System.out.println(service.serviceName() + " с таким именем не зарегистрирован!");
		}
	}

	public void showStatusList() {
		int PID = 0;
		for (IService service : services) {
			System.out.format("[%d] %s : %s - %s\n",PID, service.serviceSysId(),
					service.serviceName(), service.status());
			PID++;
		}
	}

	public void killAll() {
		for (IService service : services) {
			stopService(service);
		}
	}

}
