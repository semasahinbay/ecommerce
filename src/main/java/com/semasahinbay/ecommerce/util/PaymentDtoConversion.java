package com.semasahinbay.ecommerce.util;

import com.semasahinbay.ecommerce.entity.Payment;
import com.semasahinbay.ecommerce.dto.PaymentDto;

import java.util.ArrayList;
import java.util.List;

public class PaymentDtoConversion {

    public static PaymentDto convertToDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getCardHolder(),
                payment.getCardNumber(),
                payment.getExpirationDate(),
                payment.getUser().getId());
    }

    public static Payment convertToEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.id());
        payment.setCardHolder(paymentDto.cardHolder());
        payment.setCardNumber(paymentDto.cardNumber());
        payment.setExpirationDate(paymentDto.expirationDate());
        return payment;
    }

    public static List<PaymentDto> convertPaymentList(List<Payment> payments) {
        List<PaymentDto> paymentDtos = new ArrayList<>();
        payments.forEach(payment -> paymentDtos.add(convertToDto(payment)));
        return paymentDtos;
    }
}
