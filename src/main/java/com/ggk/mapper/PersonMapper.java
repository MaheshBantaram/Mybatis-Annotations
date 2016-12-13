package com.ggk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.ggk.myapp.domain.Person;

public interface PersonMapper {
	
	public final String SELECT_QUERY = "SELECT * FROM PERSON"; 
	
	@Select(SELECT_QUERY)
	public List<Person> selectAllPerson();
	
	
	@Results({
        @Result(property = "id", column = "id"),
    })
	@Select("SELECT id FROM PERSON WHERE id = #{id}")
	public Person selectPerson(@Param("id") int id);

	@Insert("INSERT INTO PERSON (ID,NAME) VALUES (#{id}, #{name})")
	public int insertPerson(Person person);

	@Select(value = "{CALL GetPersonsByIdAndName(#{id}, #{name})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<Person> getPersonsByIdAndName(Map<String, Object> params);
}
