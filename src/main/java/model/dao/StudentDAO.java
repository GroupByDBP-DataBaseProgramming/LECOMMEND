package model.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.StudentMapper;
import model.dto.StudentDTO;

public class StudentDAO {


	/**
	 * Student 테이블에서 추가, 수정, 삭제, 검색 수행 
	 */
		private SqlSessionFactory sqlSessionFactory;

		public StudentDAO() {
			String resource = "mybatis-config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}



		/*학생 정보 추가 (create)*/
		public int insertStudent(StudentDTO stu) {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			try {
				int isJoin= sqlSession.getMapper(StudentMapper.class).insertStudent(stu);
				if (isJoin > 0) {
					sqlSession.commit();
				} 
				return isJoin;
			} finally {
				sqlSession.close();
			}
		}


		/*학생 정보 삭제(remove)*/
		public int deleteStudent(String stuId) {
			SqlSession sqlSession = sqlSessionFactory.openSession();

			try {
				int isDelete = sqlSession.getMapper(StudentMapper.class).deleteStudent(stuId);
				return isDelete;

			} finally {
				sqlSession.close();
			}

		}

		/*학생 정보 수정(Update)*/

		public int updateStudent(StudentDTO stu) {
			SqlSession sqlSession = sqlSessionFactory.openSession();

			try {
				int isUpdate = sqlSession.getMapper(StudentMapper.class).updateStudent(stu);
				return isUpdate;
			} finally {
				sqlSession.close();
			}
		}

		/*학생 정보 가져오기(select)*/
		public StudentDTO findStudent (String stuID) {

			SqlSession sqlSession = sqlSessionFactory.openSession();

			try {
				return sqlSession.getMapper(StudentMapper.class).selectStudentByPrimaryKey(stuID);
			} finally {
				sqlSession.close();
			}


		}
		
		/*학생 아이디가 존재하는지*/
		public boolean isExistingStudent(String stuID) {
			boolean isExist = false;
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				 if(sqlSession.getMapper(StudentMapper.class).isExistStudentCheck(stuID)) {
					 
				 };
				
			} finally {
				// TODO: handle finally clause
			}
			
			
			return isExist;
		}

}