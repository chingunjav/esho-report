package edu.miu.shop.eshopreport.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchHistory {
	private String id;
    private String userName;
    private String searchWord;
    private String customerIP;
    private LocalDateTime searchDate;
}
