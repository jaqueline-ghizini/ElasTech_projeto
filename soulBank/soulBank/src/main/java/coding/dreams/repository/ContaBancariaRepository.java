package coding.dreams.repository;


import coding.dreams.model.ContaBancaria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    public ContaBancaria findByContaAndAgencia(String numConta, String numAgencia);//Decidimos criar esse medoto de consulta por conta e agencia alem do padrao por id porque ele é mais usual
    public ContaBancaria findByChavePix(String chavePix);// Como implementamos a chave pix, também é possivel fazer a colsulta por meio dela
}
