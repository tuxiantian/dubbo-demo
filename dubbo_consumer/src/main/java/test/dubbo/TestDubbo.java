package test.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dubbo.service.TestRegistryService;

public class TestDubbo {

	public static void main(String[] args) {
		//E:/eclipse/dubbo_consumer/src/main/webapp/WEB-INF/web.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dubbo-consumer.xml");  
        context.start();  
        TestRegistryService demoService = (TestRegistryService)context.getBean("testRegistryService"); // 获取远程服务代理  
        String hello = demoService.hello("world"); // 执行远程方法  
        System.out.println(hello); 
       
	}

}
