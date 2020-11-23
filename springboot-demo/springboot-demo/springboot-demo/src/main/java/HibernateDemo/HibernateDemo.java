package HibernateDemo;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class HibernateDemo {

	private static SessionFactory sessionFactory = null;

	// 查询
	private static void query() throws Exception {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createQuery("FROM Student").list();
		session.close();

		for (Student student : studentList) {
			System.out.println("id:" + student.getId() + " stuNo:" + student.getStuNo() + " name:" + student.getName()
					+ " age:" + student.getAge());
		}
	}

	// 添加
	private static void insert(Student student) throws IOException {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		session.save(student);
		txTransaction.commit();
		session.close();
	}

	// 修改
	private static void update(int id, int age) throws IOException {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		student.setAge(age);
		session.update(student);
		txTransaction.commit();
		session.close();
	}

	// 删除
	private static void delete(int id) throws IOException {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
		txTransaction.commit();
		session.close();
	}

	// 分页查询
	public static void searchWithPagination() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setFirstResult(1);
		criteria.setMaxResults(3);
		List<Student> students = criteria.list();
		for (Student student : students) {
			System.out.print("stuno: " + student.getStuNo());
			System.out.print("  age: " + student.getAge());
			System.out.println("  name: " + student.getName());
		}
		transaction.commit();
		session.close();
	}

	public HibernateDemo() {
		// TODO Auto-generated constructor stub
	}

	// 排序
	public static void searchWithSorting() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.gt("age", 2000));
//		criteria.addOrder(Order.asc("salary"));//按照salary升序排序
		criteria.addOrder(Order.desc("age"));// 按照salary降序排序
		List<Student> students = criteria.list();
		for (Student student : students) {
			System.out.print("stuno: " + student.getStuNo());
			System.out.print("  age: " + student.getAge());
			System.out.println("  name: " + student.getName());
		}
		transaction.commit();
		session.close();
	}
	/*
	 * 
	 * 统计查询 统计查询用Projection来表示，可以由Projections的静态方法得到
	 */

	public static void searchWithAggregations() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection(Projections.sum("age"));
		Object obj = criteria.uniqueResult();
		System.out.println(obj);
		transaction.commit();
		session.close();
	}

	public static void main(String[] args) throws Exception {

		sessionFactory = new Configuration().configure().buildSessionFactory();

		// 查询
		query();

		// 添加
		// Student student = new Student();
		// student.setStuNo("2-003");
		// student.setName("吕布");
		// student.setAge(20);

		// insert(student);

		// 修改
//		Student student = new Student();
//		student.setStuNo("2-003");
//		student.setAge(26);
//		update(9, 26);

		// 删除
//		Student student = new Student();
//		student.setStuNo("2-003");
		/* delete(9); */
		// 分页
//		searchWithPagination();

		// 排序
		// searchWithSorting();

		// 汇总
		// searchWithAggregations();
	}

}
