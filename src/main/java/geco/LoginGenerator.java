package geco;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Classe representant un generateur de login
 */
public class LoginGenerator {
 
    private LoginService loginService;

    /**
     * Construit un login generator
     * @param loginService le service de login
     */
    public LoginGenerator(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Genere un login unique a partir d'un nom et d'un prenom en prenant la premiere lettre du prenom, concatenee avec
     * les 3 premieres lettres du nom, le tout mis en lettres capitales et desaccentue. Le login genere doit etre unique
     * par rapport a la liste des logins existants. En cas de doublon, on incremente le doublon d'un indice. Ci dessous des
     * exemples :
     * <ul>
     *     <li>Paul Dupond -> PDUP </li>
     *     <li>Pierre Dupard -> PDUP1</li>
     *     <li>Jacques Durand -> JDUR</li>
     *     <li>Lionel R&eacute;gal -> LREG</li>
     * </ul>
     * @param nom le nom
     * @param prenom le prenom
     * @return le login genere
     */
    public String generateLoginForNomAndPrenom(String nom, String prenom) {
        String p = deAccent(prenom.substring(0,1).toUpperCase());
        String n;
        if(nom.length() < 3){
            n = deAccent(nom.substring(0,2).toUpperCase());
        }else {
            n = deAccent(nom.substring(0, 3).toUpperCase());
        }
        String login = p+n ;
        int suffixe = 1;
        if (loginService.loginExists(login)) {
            while(loginService.loginExists(login + Integer.toString(suffixe))){
                suffixe++;
            }
            login += Integer.toString(suffixe);
        }
        loginService.addLogin(login);
        return login;
    }

    /**
     * Supprime les accents d'une chaine de caractere
     *
     * @param str la chaine de caractere
     * @return la chaine de caractere sans accents
     */
    private String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }






}
