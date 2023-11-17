package com.project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class ChattingDTO {
	@NonNull private int c_num;
	@NonNull private int g_num;
	@NonNull private String c_sender;
	@NonNull private String c_content;
	private String c_date;	
}
