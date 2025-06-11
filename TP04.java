/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 371 - LINGUAGEM DE PROGRAMAÇÃO I
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

public class TP04 {
	public static void main (String [] args) {
            // Criação do objeto Hora
            Data data = new Data();

            System.out.println(data.mostra1());
            System.out.println(data.mostra2());
            System.out.println(data.bissexto());
            System.out.println(data.diasTranscorridos());
            data.apresentaDataAtual();
    }
}
