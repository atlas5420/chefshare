package com.chefshare.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
	
	@NotBlank(message = "아이디를 입력해주세요")
	private String username;
	
	@NotBlank(message = "이메일을 입력해주세요")
	@Email(message = "이메일 형식이 맞지 않습니다")
	private String email;
	
	@NotBlank
	@Pattern(regexp = "(?=.*[0-9)(?=.*[a-zA-Z])(?=.*\\w_)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요")
	private String password;
	
}
