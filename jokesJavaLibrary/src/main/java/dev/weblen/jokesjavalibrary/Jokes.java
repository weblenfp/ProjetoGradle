package dev.weblen.jokesjavalibrary;

import java.util.Random;

public class Jokes {
    private static final String[] JOKES = {
            "Na aula de química o professor pergunta:\n" +
                    "- Quais as principais reações do álcool?\n" +
                    "O aluno responde:\n" +
                    "- Chorar pela ex, achar que esta rico, ficar valente e pegar mulher feia ...\n" +
                    "Professor:\n" +
                    "- Tirou 10!\n",

            "Na delegacia\n" +
                    "– Seu delegado meu marido saiu de casa ontem a noite, disse que ia comprar arroz e até agora não voltou.\n" +
                    "O que eu faço doutor?\n" +
                    "– Sei lá, faz macarrão!!\n",

            "Um homem está em casa, quando sua namorada chega, toca a campainha e então ele pergunta:\n" +
                    "- Quem é?\n" +
                    "E ela responde:\n" +
                    "- É o amor da sua vida!\n",

            "A esposa estava lavando a louça, enquanto seu marido tomava uma cerveja sentado no sofá.\n" +
                    "De repente o marido se vira para esposa e pergunta:\n" +
                    "- Amor, o que você fazia antes de casar comigo?\n" +
                    "E a mulher, sem pensar duas vezes, responde:\n" +
                    "Eu vivia!\n",

            "Quantos graus tem um leão morto?\n" +
                    "R: 360 graus, pois ele é uma ex-fera.",

            "Um homem rindo muito conta para o amigo:\n" +
                    "- Hoje às 03:30 da manhã entrou um ladrão lá em casa...\n" +
                    "O amigo diz:\n" +
                    "- Caramba, cara!!!! Um ladrão entrou na sua casa e você está rindo??E o que ele levou?\n" +
                    "E o homem responde:\n" +
                    "- Levou uma surra ... minha mulher achou que era eu chegando bêbado.\n",

            "O filho diz para a mãe:\n" +
                    "- Mãe, comprei um relógio!\n" +
                    "Que marca???\n" +
                    "- As horas!\n",

            "Um homem no consultório de um psiquiatra:\n" +
                    "- Doutor, estou preocupado com minha esposa. Quando estou no trabalho, ela passa o dia conversando com o abajur!\n" +
                    "- Mas você a viu falando com o abajur? - pergunta o médico.\n" +
                    "- Não, o abajur me contou e pediu segredo!!!\n",

            "Por que a mulher não pode ser eletricista?\n" +
                    "Porque ela leva 9 meses para dar a luz!\n",

            "Por que os índios odeiam a Copa?\n" +
                    "Porque eles só vivem na reserva.\n",

            "Querido, o que você mais prefere? Uma mulher bonita ou uma mulher inteligente?\n" +
                    "- Nem uma, nem outra.. meu amor.. Você sabe que eu gosto só de você!\n",

            "Por que os portugueses preocupados com a violência em São Paulo estão instalando para-raios no teto do carro?\n" +
                    "R: Para evitar os sequestro relâmpago!"
    };

    public static void main(String[] args) {
        System.out.println(getJoke());
    }

    public static String getJoke() {
        return JOKES[new Random(System.currentTimeMillis()).nextInt(3)];
    }
}
