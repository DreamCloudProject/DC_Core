package ru.dreamcloud.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ru.dreamcloud.core.interfaces.IKernel;
import ru.dreamcloud.core.managers.ServiceManager;
import ru.dreamcloud.core.services.StorageService;
import ru.dreamcloud.entities.TestEntity;
import ru.dreamcloud.entities.TestEntity_1;
import ru.dreamcloud.storage.DC_Storage;
import ru.dreamcloud.storage.DataAccessor;
import ru.dreamcloud.storage.DataIndex;
import ru.dreamcloud.storage.StorageSource;

public class DC_Kernel implements IKernel {
	static ServiceManager services = new ServiceManager();
	static DC_Storage storage = StorageService.getInstance().getStorage();
	
	public static void main(String[] args) {
		run();
		//readEntityProperties("TestEntity_1");
	}

	public static void run() {		
		services.runAll();
		
		
		//storage.createDatabase("sampleDB");
		//storage.createDatabase("sampleDB1");
		//storage.createEntityStore("eStore");
		
		System.out.println("\n--------Список сервисов-------");
		services.showStatusList();
		System.out.println("--------------------------------\n");		
		
		
		System.out.println("-----Список источников данных------");
		storage.showAllDataSources();
		System.out.println("-----------------------------------\n");
		
		DataAccessor da = storage.getDataAccessor("eStore");
		StorageSource<?> store = da.getStore();
		
		DataIndex<TestEntity_1> dIndex = new DataIndex<TestEntity_1>(store);		
		dIndex.setPrimIndex(String.class, TestEntity_1.class);
		dIndex.setSecIndex(String.class, "name");	
	
		//storage.createEntity("eStore","TestEntity_1");
		
		//TestEntity_1 test = new TestEntity_1();
		//test.setName("Ivan");
		//test.setRank("Captain");
		//test.setAge(31);
		//test.setActive(true);
		
		//dIndex.addRecord(test);
		
		//test.setName("Dmitry");
		//test.setRank("Major");
		//test.setAge(32);
		//test.setActive(true);		
		
		//dIndex.addRecord(test);
		
		da.addAccessor(TestEntity_1.class.getName(), dIndex);		
		da.getAccessor(TestEntity_1.class.getName()).readAllRecords();
		
		DataIndex<TestEntity> dIndex1 = new DataIndex<TestEntity>(store);		
		dIndex1.setPrimIndex(String.class, TestEntity.class);
		//dIndex1.setSecIndex(String.class, "name");	
		
		//TestEntity test1 = new TestEntity();
		//test1.setName("Petr");
		//test1.setRank("Lieutenant");
		//test1.setAge(27);
		
		//dIndex1.addRecord(test1);
		
		da.addAccessor(TestEntity.class.getName(), dIndex1);		
		da.getAccessor(TestEntity.class.getName()).readAllRecords();

		//storage.closeDatabase("sampleDB");
		//storage.deleteDataSource("sampleDB");
		
		//storage.closeEntityStore("eStore");
		//storage.deleteDataSource("eStore");
		
		//services.killAll();		
		
		//System.out.println("-----Список источников данных------");
		//storage.showAllDataSources();
		//System.out.println("-----------------------------------\n");		
	
		//System.out.println("--------Список сервисов-------");
		//services.showStatusList();
		//System.out.println("------------------------------\n");	
		
	}
	
	
	public String getData(){
		//services.runAll();
		
		DataAccessor da = storage.getDataAccessor("eStore");
		StorageSource<?> store = da.getStore();
		
		DataIndex<TestEntity_1> dIndex = new DataIndex<TestEntity_1>(store);		
		dIndex.setPrimIndex(String.class, TestEntity_1.class);
		dIndex.setSecIndex(String.class, "name");	
		
		da.addAccessor(TestEntity_1.class.getName(), dIndex);		
		return da.getAccessor(TestEntity_1.class.getName()).readAllRecordsToString();
	}
	
	public String testStore() {
		services.runAll();	

		// Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
		System.out.println("\n--------Список сервисов-------");
		services.showStatusList();
		System.out.println("--------------------------------\n");	
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    System.out.println(baos.toString());
		return baos.toString();
	}
	
	

}
