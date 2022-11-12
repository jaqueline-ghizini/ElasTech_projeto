package codingDreams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class SoulBankApplication {

	public static void main(String[] args) {



		SpringApplication.run(SoulBankApplication.class, args);

		/*
		Scanner teclado = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		sb.append("===========================================");
		sb.append(System.getProperty("line.separator"));
		sb.append("|                                         |");
		sb.append(System.getProperty("line.separator"));
		sb.append("|         Bem Vindo ao SoulBank!          |");
		sb.append(System.getProperty("line.separator"));
		sb.append("|   Um Banco Feito de Coração para Você   |");
		sb.append(System.getProperty("line.separator"));
		sb.append("|                                         |");
		sb.append(System.getProperty("line.separator"));
		sb.append("===========================================");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		int opcao;

		do{

			//StringBuffer menu = new StringBuffer();//verificar com a Cami se toda vez que for usar tem que declarar
			sb.append("==============================================================");
			sb.append(System.getProperty("line.separator"));
			sb.append("|     Digite o numero correspondente a opção desejada        |");
			sb.append(System.getProperty("line.separator"));
			sb.append("==============================================================");
			sb.append(System.getProperty("line.separator"));
			sb.append("|                                         |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|                  Pessoa Física                             |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|             1 - Cadastrar e Abrir Conta                    |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|                                                            |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|                  Pessoa Jurídica                           |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|             2 - Cadastrar e Abrir Conta                    |");
			sb.append(System.getProperty("line.separator"));
			sb.append("|                                                            |");
			sb.append(System.getProperty("line.separator"));
			sb.append("==============================================================");
			sb.append(System.getProperty("line.separator"));
			sb.append(System.getProperty("line.separator"));

			opcao = teclado.nextInt();//pega a opcao informada

			switch (opcao){
				case 1:
					System.out.println("Voce escolheu conta para pessoa fisica");
					break;
				case 2:
					System.out.println("Voce escolheu conta para pessoa jurídica");
					break;
				default:
					break;
			}

		}while(opcao!=0); // enquanto for diferente de 0


		 */
	}

}
