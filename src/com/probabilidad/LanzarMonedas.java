package com.probabilidad;

import java.util.Random;

public class LanzarMonedas {

    public static void main(String[] args) {
        int lanzamientosPorExperimento = 5;
        int carasDeseadas = 3;
        int totalExperimentos = 100000; // número de simulaciones

        Random random = new Random();
        int exitos = 0;

        for (int i = 0; i < totalExperimentos; i++) {
            int caras = 0;

            // Lanzar la moneda 5 veces
            for (int j = 0; j < lanzamientosPorExperimento; j++) {
                boolean esCara = random.nextBoolean(); // true = cara, false = sello
                if (esCara) caras++;
            }

            if (caras == carasDeseadas) {
                exitos++;
            }
        }

        double probabilidadEmpirica = (double) exitos / totalExperimentos;

        // Probabilidad teórica (distribución binomial)
        int n = lanzamientosPorExperimento;
        int k = carasDeseadas;
        double p = 0.5;
        double probabilidadTeorica = combinatoria(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);

        System.out.println("----- Lanzamiento de Monedas -----");
        System.out.println("Lanzamientos por experimento: " + lanzamientosPorExperimento);
        System.out.println("Caras deseadas: " + carasDeseadas);
        System.out.println("Número de experimentos: " + totalExperimentos);
        System.out.println("Probabilidad empírica (simulada): " + probabilidadEmpirica);
        System.out.println("Probabilidad teórica (binomial):  " + probabilidadTeorica);
    }

    // Método para calcular combinaciones C(n,k)
    public static int combinatoria(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int factorial(int num) {
        int resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
/*
📊 Ejemplo de salida en consola :
        ----- Lanzamiento de Monedas -----
Lanzamientos por experimento: 5
Caras deseadas: 3
Número de experimentos: 100000
Probabilidad empírica (simulada): 0.3128
Probabilidad teórica (binomial):  0.3125 */