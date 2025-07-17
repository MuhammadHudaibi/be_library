package com.library.demo.dto.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String name;
    private String address;
    private String phoneNumber;
}
