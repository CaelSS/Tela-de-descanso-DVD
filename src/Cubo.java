public class Cubo {
	public static void main(String[] args) {

		int tamanho = 5;
		int dimensaoI = tamanho, dimensaoJ = tamanho, dimensaoZ = tamanho;
		int direita = 0, esquerda = 0, cima = 0, baixo = 0, soma = 0, dez = 10, posicao = 0, atras = 0, frente = 0,
				ciclos = 0;

		int[][][] matriz = new int[tamanho][tamanho][tamanho];
		int[][][] matrizAuxiliar = new int[tamanho][tamanho][tamanho];

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				for (int z = 0; z < tamanho; z++) {
					matriz[i][j][z] = 1000;
				}
			}
		}

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				for (int z = 0; z < tamanho; z++) {
					System.out.print(matriz[i][j][z] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		boolean parar = false;
		while (!parar) {
			parar = true;

			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
					for (int z = 0; z < tamanho; z++) {

						// Atribui valor às variáveis

						if (i == 0) {
							cima = dez;
						} else {
							cima = matriz[i - 1][j][z];
						}

						if (i == (dimensaoI - 1)) {
							baixo = dez;
						} else {
							baixo = matriz[i + 1][j][z];
						}

						if (j == 0) {
							esquerda = dez;
						} else {
							esquerda = matriz[i][j - 1][z];
						}

						if (j == (dimensaoJ - 1)) {
							direita = dez;
						} else {
							direita = matriz[i][j + 1][z];
						}

						if (z == 0) {
							frente = dez;
						} else {
							frente = matriz[i][j][z - 1];
						}

						if (z == (dimensaoZ - 1)) {
							atras = dez;
						} else {
							atras = matriz[i][j][z + 1];
						}

						posicao = matriz[i][j][z];

						soma = (esquerda + direita + cima + baixo + frente + atras + posicao) / 7;
						matrizAuxiliar[i][j][z] = soma;
						System.out.println(
								"- (Resfriando) Posição " + i + "/" + j + "/" + z + ": " + matrizAuxiliar[i][j][z]);

						if (matrizAuxiliar[i][j][z] > 100) {
							parar = false;
						}

					}
				}
			}

			if (!parar) {
				for (int i = 0; i < tamanho; i++) {
					for (int j = 0; j < tamanho; j++) {
						for (int z = 0; z < tamanho; z++) {
							matriz[i][j][z] = matrizAuxiliar[i][j][z];
						}
					}
				}
			}
			ciclos++;
		}

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				for (int z = 0; z < tamanho; z++) {
					System.out.print(matrizAuxiliar[i][j][z] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		System.out.println("Ciclos: " + ciclos);
	}
}
