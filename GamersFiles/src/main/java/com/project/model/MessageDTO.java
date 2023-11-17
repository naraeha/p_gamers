package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
	private int m_num;
	@NonNull private String m_sender;
	@NonNull private String m_recipient;
	@NonNull private String m_title;
	@NonNull private String m_content;
	private String m_date;
}
