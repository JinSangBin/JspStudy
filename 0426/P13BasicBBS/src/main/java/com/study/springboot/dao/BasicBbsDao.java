package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.BasicBbsDTO;

@Repository
public class BasicBbsDao implements IBasicBbsDao{
	
	@Autowired
	JdbcTemplate jtemplete;
	
	
	@Override
	public List<BasicBbsDTO> listDao() {
		System.out.println("listDao()");
		String query="select * from basic_bbs order by id desc";
		List<BasicBbsDTO> dtos = jtemplete.query(query, new BeanPropertyRowMapper<BasicBbsDTO>(BasicBbsDTO.class));
		return dtos;
	}

	@Override
	public BasicBbsDTO viewDao(String id) {
		System.out.println("viewDao()");
		String query="select * from basic_bbs where id =" + id;
		BasicBbsDTO dto = jtemplete.queryForObject(query, new BeanPropertyRowMapper<BasicBbsDTO>(BasicBbsDTO.class));//한개씩 할 떄는 queryForObject 
		return dto;
	}

	@Override
	public int writerDao(String writer, String title, String content) {
		System.out.println("writerDao()");
		String query="select * from basic_bbs(id,writer,title,content) values (basic_bbs_seq.nextval,?,?,?)";
		return jtemplete.update(query,writer,title,content);
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		String query="delete from basic_bbs where id=?";
		return jtemplete.update(query,Integer.parseInt(id));
	}

}
