public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Utilisation: java Calculateur <nombre> <nombre> <opérateur>");
            return;
        }
        
        int nb1, nb2;
        String operateur;
        try {
            nb1 = Integer.valueOf(args[0]);
            nb2 = Integer.valueOf(args[1]);
            operateur = args[2];
        } catch (NumberFormatException e) {
            System.out.println("Mauvais format.");
            return;
        }

        int resultat;
        switch (operateur) {
            case "+":
                resultat = nb1 + nb2;
                break;
            case "-":
                resultat = nb1 - nb2;
                break;
            case "*":
                resultat = nb1 * nb2;
                break;
            default:
                System.out.println("Opérateur invalide. Utilisez l'un des opérateurs suivants: +, -, *");
                return;
        }
        
        System.out.println("Résultat: " + resultat);
    }
}
