package com._520it.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor@ToString
public class UserInfo {
	private String username;
	private String password;
	//需要返回的json数据为正确日期格式时,配置该标签
	//@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inputTime;
	public UserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
