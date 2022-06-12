package sistemaLivraria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import sistemaLivraria.interfaces.IConsumidor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumidor implements IConsumidor {
    private String nome;
    private Long cpf;
    private Long rg;
    private String dataNascimento;


    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public Long getCpf() {
        return this.cpf;

    }

    @Override
    public Long getRg() {
        return this.rg;

    }

    @Override
    public LocalDate getDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataNascimento, formatter);
    }
}
