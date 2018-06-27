package com.znsd.bean;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import hibernate.util.HibernateUtil;

/**
 * 测试 注解方式
 * 多对多
 * @author Administrator
 *
 */
public class ClassesTest {
	
	
	@Test
	public void testClass(){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Classes classes = (Classes)session.load(Classes.class,1);
		
		//Classes cl = new Classes();
		Student stu = new Student();
		
		//cl.setClassName("1班");
		stu.setName("赵六");
		stu.setAge(18);
		
		stu.getSetCl().add(classes);
		
		session.save(stu);
		session.getTransaction().commit();
	}
	
	@Test
	public void testQuery(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Student> stu  = session.createCriteria(Student.class).list();
		for (Student student : stu) {
			Set<Classes> cl = student.getSetCl();
			for(Classes classes: cl){
				System.out.println(student.getName() + ",对应的班级" + classes.getClassName());
			}
		}
	}
}
