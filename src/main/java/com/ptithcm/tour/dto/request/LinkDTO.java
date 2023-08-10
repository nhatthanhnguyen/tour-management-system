package com.ptithcm.tour.dto.request;

import com.ptithcm.tour.utils.Helpers;
import lombok.Data;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

@Data
public class LinkDTO {
    private String searchText;
    private List<Order> sort;

    public LinkDTO() {
        this("", List.of("id,asc"));
    }

    public LinkDTO(String searchText, List<String> sort) {
        this.searchText = searchText;
        List<Order> orders = new ArrayList<>();
        if (sort.get(0).contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(Helpers.getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Order(Helpers.getSortDirection(sort.get(1)), sort.get(0)));
        }
        this.sort = orders;
    }
}
