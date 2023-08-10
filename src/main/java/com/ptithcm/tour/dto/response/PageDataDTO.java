package com.ptithcm.tour.dto.response;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class PageDataDTO<T> {
    private final List<T> data;
    private final int totalPages;
    private final long totalElements;
    private final boolean hasNext;

    public PageDataDTO() {
        this(Collections.emptyList(), 0, 0, false);
    }

    public PageDataDTO(List<T> data, int totalPages, long totalElements, boolean hasNext) {
        this.data = data;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.hasNext = hasNext;
    }
}
