package com.shop.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class OrderDto {

    @NotNull(message="상품 아이디는 필수 입력 값입니다.")
    private Long itemId;

    @Min(value = 1, message = "최소 주문수량 1개")
    @Max(value = 999, message = "최대 주문수량 999개")
    private int count;

}
