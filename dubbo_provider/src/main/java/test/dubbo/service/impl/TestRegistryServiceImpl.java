package test.dubbo.service.impl;

import test.dubbo.service.TestRegistryService;

public class TestRegistryServiceImpl implements TestRegistryService {

	public String hello(String name) {
		return "hello "+name;
	}

}
