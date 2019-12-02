package com.nt.test;

import java.util.List;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.HotelVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {

		MainController controller = null;
		List<HotelVO> listvo = null;

		// create parent container
		DefaultListableBeanFactory pFactory = null;
		XmlBeanDefinitionReader pReader = null;

		//create  child container
		DefaultListableBeanFactory cFactory = null;
		XmlBeanDefinitionReader cReader = null;

		pFactory = new DefaultListableBeanFactory();
		pReader = new XmlBeanDefinitionReader(pFactory);
		pReader.loadBeanDefinitions("com/nt/cfgs/business-beans.xml");

		cFactory = new DefaultListableBeanFactory(pFactory);
		cReader = new XmlBeanDefinitionReader(cFactory);
		cReader.loadBeanDefinitions("com/nt/cfgs/presentation-beans.xml");

		// get bean
	controller =cFactory.getBean("controller", MainController.class);
		// invoke b.method
		try {
			System.out.println("hi");
			listvo = controller.getData("chicken biriyani", "mutton biriyani");
			for (HotelVO vo : listvo) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
