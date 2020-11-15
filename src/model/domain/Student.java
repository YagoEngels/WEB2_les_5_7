package model.domain;

public class Student {
    private String naam, voornaam;
    private String studierichting;
    private int leeftijd;

    public Student(){}
    public Student(String naam, String voornaam, String studierichting, int leeftijd) {
        setNaam(naam);
        setVoornaam(voornaam);
        setStudierichting(studierichting);
        setLeeftijd(leeftijd);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam.trim().isEmpty() || naam == null)throw new IllegalArgumentException("No valid name");
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam.trim().isEmpty() || voornaam == null)throw new IllegalArgumentException("No valid first name");
        this.voornaam = voornaam;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        if (studierichting.trim().isEmpty() || studierichting == null)throw new IllegalArgumentException("No valid studierichting");
        this.studierichting = studierichting;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public static boolean isValidLeeftijd(int leeftijd) {
        return leeftijd > 0;
    }

    public void setLeeftijd(int leeftijd) {
        if (isValidLeeftijd(leeftijd))
            this.leeftijd = leeftijd;
        else throw new IllegalArgumentException("No valid leeftijd");
    }

    public String leeftijdEnRichting(){
        return "deze student is " + getLeeftijd() + " jaar oud en zit in  " + getStudierichting();
    }
}
