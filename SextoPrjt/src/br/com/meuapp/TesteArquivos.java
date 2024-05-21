package br.com.meuapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TesteArquivos {
    public static void main(String[] args) {
        String path = "teste.txt";
        try {
            escritor(path);
            leitor(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        Scanner in = new Scanner(System.in);
        String linha;
        System.out.println("Escreva algo: ");
        while (true) {
            linha = in.nextLine();
            if (linha.isEmpty()) {
                break;
            }
            buffWrite.append(linha);
            buffWrite.newLine();
        }
        buffWrite.close();
        in.close();
    }

    private static void leitor(String path) throws IOException {
        File arquivo = new File(path);
        if (arquivo.exists()) {
            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha;
            while ((linha = buffRead.readLine()) != null) {
                System.out.println(linha);
            }
            buffRead.close();
        } else {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }
}
