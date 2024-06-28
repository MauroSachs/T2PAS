package com.t1.t1.application.dtos;
import java.time.LocalDate;

public record PagamentoRequestDTO(LocalDate day, Long codAss, double valorPago, String promocao) {
}
