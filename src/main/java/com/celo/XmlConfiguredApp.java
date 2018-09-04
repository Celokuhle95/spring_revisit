package com.celo;

import com.celo.xml_based_wiring.interfaces.Perfomer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author  Clokuhle Myeza
 */
public class XmlConfiguredApp {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("revisit-beans.xml");
        Perfomer dancer = (Perfomer) ac.getBean("dancer");
        dancer.perform();

        Perfomer singingDancer = (Perfomer) ac.getBean("singing_dancer");
        singingDancer.perform();

    }
}
