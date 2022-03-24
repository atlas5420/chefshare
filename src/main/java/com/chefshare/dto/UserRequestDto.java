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
	
	@NotBlank(message = "���̵� �Է����ּ���")
	private String username;
	
	@NotBlank(message = "�̸����� �Է����ּ���")
	@Email(message = "�̸��� ������ ���� �ʽ��ϴ�")
	private String email;
	
	@NotBlank
	@Pattern(regexp = "(?=.*[0-9)(?=.*[a-zA-Z])(?=.*\\w_)(?=\\S+$).{8,16}", message = "��й�ȣ�� 8~16�� ���� �� �ҹ���, ����, Ư�����ڸ� ����ϼ���")
	private String password;
	
}
