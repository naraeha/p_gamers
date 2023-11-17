package com.project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	@NonNull private int b_num;
	@NonNull private int g_num;
	@NonNull private String b_sender;
	@NonNull private String b_title;
	@NonNull private String b_content;
	private String b_date;
}
