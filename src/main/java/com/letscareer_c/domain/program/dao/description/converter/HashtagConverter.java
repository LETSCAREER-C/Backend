package com.letscareer_c.domain.program.dao.description.converter;

import com.letscareer_c.domain.program.dao.description.dto.HashtagDto;
import com.letscareer_c.domain.program.domain.Hashtag;

public class HashtagConverter {
    public static HashtagDto toHashtagDto(Hashtag hashtag) {
        return HashtagDto.builder()
                .hashtag(hashtag.getHashtag())
                .order(hashtag.getOrderNumber())
                .build();
    }
}
