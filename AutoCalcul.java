import java.io.*;

public class AutoCalcul {
    public static void main(String[] args) {
        File dir = new File("test1");
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Le répertoire n'existe pas ou n'est pas accessible.");
            return;
        }

        File[] liste = dir.listFiles();
        if (liste == null) {
            System.out.println("Le répertoire est vide.");
            return;
        }

        for (File item : liste) {
            if (item.isFile()) {
                //System.out.format("Nom du fichier: %s%n", item.getName());
                lireFichier(item);
            } else if (item.isDirectory()) {
                System.out.format("Nom du répertoire: %s%n", item.getName());
            }
        }
    }

    public static void lireFichier(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            double nb1, nb2;
            String operateur;
            StringBuilder resultat = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                resultat.append(line).append("\n");
                String[] op = line.split(" ");
                try {
                    nb1 = Double.parseDouble(op[0]);
                    nb2 = Double.parseDouble(op[1]);
                    operateur = op[2];
                } catch (NumberFormatException e) {
                    System.out.println("Mauvais format.");
                    return;
                }
                double res = ;
                switch (operateur) {
                    case "+":
                        res = nb1 + nb2;
                        break;
                    case "-":
                        res = nb1 - nb2;
                        break;
                    case "*":
                        res = nb1 * nb2;
                        break;
                    default:
                        System.out.println("Opération invalide.");
                        break;
                }
                resultat.append("Résultat: ").append(res).append("\n");

                // Écrire le résultat dans un fichier .res
                String nomFichierRes = file.getName().replaceFirst("[.][^.]+$", "") + ".res";
                try (FileWriter writer = new FileWriter(nomFichierRes)) {
                    writer.write(resultat.toString());
                } catch (IOException ex) {
                    System.out.println("Erreur lors de l'écriture dans le fichier résultat.");
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
