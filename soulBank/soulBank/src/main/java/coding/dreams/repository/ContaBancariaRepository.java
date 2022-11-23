package coding.dreams.repository;


import coding.dreams.model.ContaBancaria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    public ContaBancaria findByContaAndAgencia(String numConta, String numAgencia);
    public ContaBancaria findByChavePix(String chavePix);
}
