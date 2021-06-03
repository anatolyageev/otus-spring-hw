package org.example.ageev;

import org.example.ageev.utils.DataVisualisation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        DataVisualisation dataVisualisation = context.getBean(DataVisualisation.class);
        dataVisualisation.showAllQuestions();
    }
}
