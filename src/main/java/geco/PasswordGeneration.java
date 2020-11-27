package geco;


import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGeneration {
    private String passwordGenerated;

    public String getRandomPassword(){
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        passwordGenerated = RandomStringUtils.random(length, useLetters, useNumbers);

        return passwordGenerated;
    }
}
