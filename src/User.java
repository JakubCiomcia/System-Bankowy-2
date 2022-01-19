import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    public static List Uzytkownicy = new LinkedList<User>();
    public ArrayList<String> Transakcje = new ArrayList<>();

    public void addTransakcje(String nazwaTransakcji, Double liczba){
        String t = nazwaTransakcji + " " + liczba + ", stan konta: " + this.getStanKonta();
        this.Transakcje.add(t);

    }


    public double stanKonta;
    public List getLista(){
        return this.Uzytkownicy;
    }

    public String getStanKonta() {
        return String.valueOf(stanKonta);
    }

    public void setStanKonta(double stanKonta) {
        this.stanKonta = stanKonta;
    }
    String login;
    public User(String login, int pin , double stanKonta) {
        this.login = login;
        Pin = pin;
        this.stanKonta = stanKonta;

        this.Uzytkownicy.add(this);
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPin() {
        String check;
        check = Pin + "";
        return check;
    }

    public void setPin(int pin) {
        Pin = pin;
    }

    int Pin;
}
