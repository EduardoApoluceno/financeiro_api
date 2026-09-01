package com.meufinanceiro.financeiro_api.transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    @Column(precision = 14, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "A data é obrigatória")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo é obrigatório")
    private TransactionType type;
}
