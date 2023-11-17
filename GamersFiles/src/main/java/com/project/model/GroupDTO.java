package com.project.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class GroupDTO {

	private int g_num;
	@NonNull
	private String m_id;
	private int c_num;
	@NonNull
	private String g_start;
	@NonNull
	private String g_end;
	@NonNull
	private int g_member;
	@NonNull
	private String m_position;
	private int g_date;

}
