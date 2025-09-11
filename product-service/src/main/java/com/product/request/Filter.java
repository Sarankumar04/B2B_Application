package com.product.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Filter {

    @NotEmpty
    private String filedName;
    @NotEmpty
    private String pageNumber;
    @NotEmpty
    private String pageSize;
    private int sortType;
}
