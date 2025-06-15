/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 371 - LINGUAGEM DE PROGRAMAÇÃO I
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

public class TP04 {
	public static void main (String [] args) {
            // Instâncias da classe Data
            Data data = new Data();
	    int[] dataParams = {16,8,2025}; 
	    Data data2 = new Data(dataParams[0], dataParams[1], dataParams[2]);

            data.mostra1();
            System.out.println(data.mostra2());
	    System.out.println("--------------------");
            System.out.println(data.bissexto()? "Eh ano bissexto" : "Nao eh ano bissexto");
	    System.out.println("--------------------");
            System.out.println(data.diasTranscorridos() + " dia(s) do ano.");
	    
            data2.mostra1();
            System.out.println(data2.mostra2());
	    System.out.println("--------------------");
            System.out.println(data2.bissexto()? "Eh ano bissexto" : "Nao eh ano bissexto.");
	    System.out.println("--------------------");
            System.out.println(data2.diasTranscorridos() + " dia(s) do ano.");
            System.out.println("--------------------");
            data.apresentaDataAtual();
    }
}
