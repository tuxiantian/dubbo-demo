package test.dubbo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dubbo.service.TestRegistryService;

/**
 * Servlet implementation class TestDubboServlet
 */
public class TestDubboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDubboServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dubbo-consumer.xml");  
        context.start();  
        TestRegistryService demoService = (TestRegistryService)context.getBean("testRegistryService"); // 获取远程服务代理  
        String hello = demoService.hello("world"); // 执行远程方法  
        System.out.println(hello);
	}

}
