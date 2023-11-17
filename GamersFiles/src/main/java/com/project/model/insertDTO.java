package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class insertDTO {
	private int i_num;
	private int g_num;
	@NonNull private String m_id;
	@NonNull private String m_position;
	@NonNull private String m_nick;
	private String i_date;

}
