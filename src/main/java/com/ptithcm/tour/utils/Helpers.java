package com.ptithcm.tour.utils;

import org.springframework.data.domain.Sort;

public class Helpers {
    public static Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("asc"))
            return Sort.Direction.ASC;
        else
            return Sort.Direction.DESC;
    }
}
