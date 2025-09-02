package com.order.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    @Email
    private String userEmail;
    private Long phoneNumber;
}
