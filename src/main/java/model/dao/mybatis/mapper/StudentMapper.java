package model.dao.mybatis.mapper;

import java.util.List;

import model.dto.StudentDTO;

public interface StudentMapper {
	
	public int insertStudent(StudentDTO stu);

	public int updateStudent(StudentDTO stu);

	public int deleteStudent(String stuId);
	
	public StudentDTO findStudent(String stuId);

	public List<StudentDTO> selectAllStudent();

	public StudentDTO selectStudentByPrimaryKey(String stuID);

	public boolean isExistStudentCheck(String stuID);

}