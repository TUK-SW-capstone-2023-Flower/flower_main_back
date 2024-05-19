package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseViewPostGetDTO {
    Long postId;
    String title;
    Integer viewCount;
}
