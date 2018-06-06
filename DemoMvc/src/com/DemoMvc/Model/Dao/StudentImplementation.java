package com.DemoMvc.Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.DemoMvc.Configuration.DbConfiguration;
import com.DemoMvc.Model.Student;
import com.mysql.jdbc.Statement;

@Repository("daoInterface")
public class StudentImplementation implements StudentInterface {

	Connection conn;

	@Override
	public void studentInsert(Student stu) {

		try {
			conn = DbConfiguration.getSqlConnection();
			PreparedStatement pst1 = conn
					.prepareStatement("insert into student(name,degree,phone,address) values(?,?,?,?)");
			pst1.setString(1, stu.getName());
			pst1.setString(2, stu.getDegree());
			pst1.setInt(3, (int) stu.getPhone());
			pst1.setString(4, stu.getAddress());

			pst1.execute();
			pst1.close();

			conn.close();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getStudent(String name) {
		// TODO Auto-generated method stub

		List<Student> stuList = new ArrayList<Student>();

		try {

			String query = "SELECT * FROM student WHERE name='" + name + "'";
			conn = DbConfiguration.getSqlConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Student stu = new Student();

				stu.setName(rs.getString("name"));
				stu.setDegree(rs.getString("degree"));
				// System.out.println(stu.getDegree());
				stu.setPhone(rs.getInt("phone"));
				stu.setAddress(rs.getString("address"));
				stuList.add(stu);

			}

			rs.close();
			conn.close();

		} catch (Exception e) {

			System.out.println(e);
			// TODO: handle exception
		}

		return stuList;
	}

	@Override
	public void update(Student stu) {
		// TODO Auto-generated method stub

		try {

			conn = DbConfiguration.getSqlConnection();
			PreparedStatement pst1 = conn
					.prepareStatement("update student set degree=?,phone=?,address=?  where name=?");
			pst1.setString(1, stu.getDegree());
			pst1.setInt(2, (int) stu.getPhone());
			pst1.setString(3, stu.getAddress());
			pst1.setString(4, stu.getName());

			pst1.execute();
			pst1.close();

			conn.close();

		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}

	}

	@Override
	public void stuDelete(Student stu) {
		// TODO Auto-generated method stub

		try {
                
			
			
			conn = DbConfiguration.getSqlConnection();
			PreparedStatement pst1 = conn
					.prepareStatement("update student set  status=?  where name=?");
			pst1.setInt(1, 0);
			pst1.setString(2,  stu.getName());
			
			pst1.execute();
			pst1.close();

			conn.close();

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

	}

}
