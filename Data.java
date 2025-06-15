/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 371 - LINGUAGEM DE PROGRAMAÇÃO I
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.DateFormat;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    private Scanner ler = new Scanner(System.in);

    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    public Data(int dia, int mes, int ano) {
        entraDia(dia);
        entraMes(mes);
        entraAno(ano);
    }

    public void entraDia(int dia) {
            try {
                if (dia < 1 || dia > 31) {
                    System.out.println("Dia invalido. Deve estar entre 1 e 31.");
                } else {
                    this.dia = dia;
                }
            } catch (InputMismatchException error) {
                    System.out.println("Numero inteiro invalido.");
            }
    }

    public void entraMes(int mes) {
            try {
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes invalido. Deve estar entre 1 e 12.");
                } else if ((mes == 2 && dia > 29) || (mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                    System.out.println("Mes invalido para o dia " + dia);
                } else {
                    this.mes = mes;
                }
            } catch (InputMismatchException error) {
                System.out.println("Numero inteiro invalido.");
            }
    }

    public void entraAno(int ano) {
            try {
                if (ano < 1900 || ano > 2100) {
                    System.out.println("Ano invalido. Deve estar entre 1900 e 2100.");
                } else if (mes == 2 && dia ==29 && !(this.bissexto())) {
                    System.out.println("Ano invalido. Dia 29 de fevereiro so existe em anos bissextos.");
                } else {
                    this.ano = ano;
                }
            } catch (InputMismatchException error) {
                System.out.println("Numero inteiro invalido.");
            } 
    }

    public void entraDia() {
        int dia;
        boolean verif = true;

        while(verif) {
            try {
                System.out.print("Digite o dia (1-31): ");
                dia = ler.nextInt();
                if (dia < 1 || dia > 31) {
                    System.out.println("Dia invalido. Deve estar entre 1 e 31.");
                } else {
                    this.dia = dia;
                    verif = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("Digite um numero inteiro valido.");
                ler.next();
            }
        }
    }

    public void entraMes() {
        int mes;
        boolean verif = true;

        while(verif) {
            try {
                System.out.print("Digite o mes (1-12): ");
                mes = ler.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes invalida. Deve estar entre 1 e 12.");
                } else if ((this.mes == 2 && this.dia > 29) || (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && this.dia > 30) {
                    System.out.println("Mes invalido. A data para o mes nao existe.");
                } else {
                    this.mes = mes;
                    verif = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("Digite um numero inteiro valido.");
                ler.next();
            }
        }
    }

    public void entraAno() {
        int ano;
        boolean verif = true;

        while(verif) {
            try {
                System.out.print("Digite o ano (1900-2100): ");
                ano = ler.nextInt();
                if (ano < 1900 || ano > 2100) {
                    System.out.println("Ano invalido. Deve estar entre 1900 e 2100.");
                } else if (this.mes == 2 && this.dia ==29 && !(ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    System.out.println("Ano invalido. Dia 29 de fevereiro so existe em anos bissextos.");
                } else {
                    this.ano = ano;
                    verif = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("Digite um numero inteiro valido.");
                ler.next();
            }
        }
    }

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public void mostra1() {
	System.out.println("--------------------");
	System.out.println("| Dia | Mes | Ano  |");
	System.out.println("--------------------");
        System.out.println(String.format("|  %02d |  %02d | %04d |", this.dia, this.mes, this.ano));
	System.out.println("--------------------");
    }

    public String mostra2() {
        String mesExt;
        switch(this.mes) {
            case 1: 
                mesExt = "Janeiro"; 
                break;
            case 2: 
                mesExt = "Fevereiro"; 
                break;
            case 3: 
                mesExt = "Março"; 
                break;
            case 4: 
                mesExt = "Abril"; 
                break;
            case 5: 
                mesExt = "Maio"; 
                break;
            case 6: 
                mesExt = "Junho"; 
                break;
            case 7: 
                mesExt = "Julho"; 
                break;
            case 8: 
                mesExt = "Agosto"; 
                break;
            case 9: 
                mesExt = "Setembro"; 
                break;
            case 10: 
                mesExt = "Outubro"; 
                break;
            case 11: 
                mesExt = "Novembro"; 
                break;
            case 12: 
                mesExt = "Dezembro"; 
                break;
            default:
                throw new IllegalArgumentException("Mes invalido: " + this.mes);
        }
        return String.format("%02d/%s/%04d", this.dia, mesExt, this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int dias = this.dia;
        for (int ii = 1; ii < this.mes; ii++) {
            switch (ii) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dias += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dias += 30;
                    break;
                case 2:
                    if (this.bissexto()) {
                        dias += 29;
                    } else {
                        dias += 28;
                    }
                    break;
            }
        }
        return dias;
    }

    public void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + dataFormat.format(dataAtual));
    }
}