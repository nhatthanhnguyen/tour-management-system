package com.ptithcm.tour.utils;

import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Helpers {
    public static Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("asc"))
            return Sort.Direction.ASC;
        else
            return Sort.Direction.DESC;
    }

    public static String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }
}
