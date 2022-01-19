import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bank extends JFrame implements ActionListener {

    JPanel panelCont = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    CardLayout cl = new CardLayout();

    private JLabel lLogin, lPin;
    private JTextField tLogin;
    private JTextField tPin, StanT1;
    private JLabel LoginT, StanT;
    private JButton bCLear, bLogowanie, bWylogowanie, bPrzelew, bWykazTransakcji, bWypłatGotowki;
    private JMenuBar menuBar;
    private JMenu menuPomoc, menuNarzędzia, menuInne;
    private JMenuItem mWyjscie, mHelp, mTools1, mTools2;
    private JCheckBox chReset;
    private JRadioButton rMałaCzcionka, rDuzaCzcionka;
    private ArrayList<User> users;
    private User Uzytkownik;


    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob1 = e.getSource();
        if (ob1 == mWyjscie) {
            dispose();
        } else if (ob1 == mHelp) {
            JOptionPane.showMessageDialog(null, "Konsultant Nr1 : 123 456 789");
            JOptionPane.showMessageDialog(null, "Konsultant Nr2 : 987 654 321");
        } else if (ob1 == rMałaCzcionka) {
            tLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
            tPin.setFont(new Font("SansSerif", Font.PLAIN, 15));
        } else if (ob1 == rDuzaCzcionka) {
            tLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
            tPin.setFont(new Font("SansSerif", Font.PLAIN, 20));
        } else if (ob1 == chReset) {
            tLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
            tPin.setFont(new Font("SansSerif", Font.PLAIN, 15));
        } else if (ob1 == bCLear) {
            tLogin.setText("");
            tPin.setText("");
        } else if (ob1 == bLogowanie) {
            CheckLogin();
        } else if (ob1 == bWylogowanie) {
            Logout();
        } else if (ob1 == bPrzelew) {
            Transwer(Double.parseDouble(StanT1.getText()));
        } else if (ob1 == bWypłatGotowki) {
            cashWithDrawal(Double.parseDouble(StanT1.getText()));
        } else if (ob1 == bWykazTransakcji) {
            accountStatements(Uzytkownik.getStanKonta());
        }

    }


    public Bank() {

        this.setContentPane(panelCont);

        this.setLayout(cl);
        panelCont.setLayout(cl);
        panelCont.add(panelFirst, "1");
        panelCont.add(panelSecond, "2");
        panelFirst.setLayout(null);
        panelSecond.setLayout(null);

        users = new ArrayList<User>();
        int szerokosc = 600;
        int wysokosc = 400;
        setTitle("Bank XYZ");
        setSize(szerokosc, wysokosc);
        getContentPane().setBackground(Color.lightGray);
        lLogin = new JLabel("Login");
        lLogin.setBounds(50, 20, 100, 50);
        lLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panelFirst.add(lLogin);

        lPin = new JLabel("Pin");
        lPin.setBounds(50, 120, 100, 50);
        lPin.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panelFirst.add(lPin);

        tLogin = new JTextField();
        tLogin.setBounds(150, 20, 350, 50);
        panelFirst.add(tLogin);

        tPin = new JPasswordField();
        tPin.setBounds(150, 120, 350, 50);
        panelFirst.add(tPin);

        bCLear = new JButton("Wyczyść");
        bCLear.setBounds(150, 220, 100, 50);
        bCLear.addActionListener(this);
        panelFirst.add(bCLear);

        bLogowanie = new JButton("Logowanie");
        bLogowanie.setBounds(300, 220, 100, 50);
        bLogowanie.addActionListener(this);
        panelFirst.add(bLogowanie);

        bWylogowanie = new JButton("Wylogowanie");
        bWylogowanie.setBounds(250, 220, 150, 50);
        bWylogowanie.addActionListener(this);
        panelSecond.add(bWylogowanie);

        bPrzelew = new JButton("Przelew");
        bPrzelew.setBounds(50, 150, 150, 50);
        bPrzelew.addActionListener(this);
        panelSecond.add(bPrzelew);

        bWypłatGotowki = new JButton("Wypłata Gotówki");
        bWypłatGotowki.setBounds(50, 220, 150, 50);
        bWypłatGotowki.addActionListener(this);
        panelSecond.add(bWypłatGotowki);

        bWykazTransakcji = new JButton("Wykaz Transakcji");
        bWykazTransakcji.setBounds(250, 150, 150, 50);
        bWykazTransakcji.addActionListener(this);
        panelSecond.add(bWykazTransakcji);

        menuBar = new JMenuBar();

        setJMenuBar(menuBar);
        menuPomoc = new JMenu("Pomoc");
        mHelp = new JMenuItem("Kontakt z Konsulatnem");
        mHelp.addActionListener(this);
        menuPomoc.add(mHelp);

        menuNarzędzia = new JMenu("Narzedzia");
        mTools1 = new JMenuItem("Powieksz ekran");
        mTools1.addActionListener(this);
        menuNarzędzia.add(mTools1);

        mTools2 = new JMenuItem("Zmiejsz ekran");
        mTools2.addActionListener(this);
        menuNarzędzia.add(mTools2);


        menuInne = new JMenu("Inne");
        mWyjscie = new JMenuItem("Wyjscie");
        mWyjscie.addActionListener(this);
        menuInne.add(mWyjscie);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));


        menuBar.add(menuPomoc);
        menuBar.add(menuNarzędzia);
        menuBar.add(menuInne);

        chReset = new JCheckBox("Reset Czcionki", false);
        chReset.setBounds(320, 300, 320, 50);
        chReset.addActionListener(this);
        panelFirst.add(chReset);


        rMałaCzcionka = new JRadioButton("Mała Cziciona");
        rMałaCzcionka.setBounds(20, 300, 150, 50);
        rMałaCzcionka.addActionListener(this);
        panelFirst.add(rMałaCzcionka);

        rDuzaCzcionka = new JRadioButton("Duza Cziciona");
        rDuzaCzcionka.setBounds(170, 300, 150, 50);
        rDuzaCzcionka.addActionListener(this);
        panelFirst.add(rDuzaCzcionka);


    }

    public void Logowanie(String login, String pin, String stanKonta) {
        System.out.println("Login : " + login + "|| PIN:  " + pin);
        cl.show(panelCont, String.valueOf(2));
        LoginT = new JLabel(login);
        LoginT.setBounds(50, 20, 300, 50);
        LoginT.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panelSecond.add(LoginT);
        StanT = new JLabel("Stan Konta: ");
        StanT.setBounds(50, 80, 150, 50);
        StanT.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panelSecond.add(StanT);
        StanT1 = new JTextField(stanKonta);
        StanT1.setBounds(200, 80, 350, 50);
        StanT1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panelSecond.add(StanT1);
    }

    public void Logout() {
        cl.show(panelCont, String.valueOf(1));
        LoginT.setText("");
        StanT1.setText("");

    }


    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setVisible(true);
        bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        User s1 = new User("User", 123, 2300.12);
        User s2 = new User("User2", 1232, 0);
        User s3 = new User("Ala Mroczka", 1233, 15.50);
        User s4 = new User("Marcin Bor", 1234, 2221.23);
        User s5 = new User("Rysiu Sousa", 3333, 4000000.23);
        User s6 = new User("Adam Kras", 1235, 4221.55);
        User s7 = new User("Jan Kowalski", 4321, 12345.67);
        User s8 = new User("Janina Kowalska", 3234, 99.12);
        User s9 = new User("Zbigniew Najman", 5234, 1000000.00);


        bank.addUser(s1);
        bank.addUser(s2);
        bank.addUser(s3);
        bank.addUser(s4);
        bank.addUser(s5);
        bank.addUser(s6);
        bank.addUser(s7);
        bank.addUser(s8);
        bank.addUser(s9);
    }


    public void addUser(User s) {
        users.add(s);

    }

    public void CheckLogin() {
        int i = 0;
        boolean looged = false;
        for (User s : users) {
            i++;
            if (i == users.size() && !looged) {
                if (tLogin.getText().trim().isEmpty() || tPin.getText().trim().isEmpty()) {
                    System.out.println("Podaj Login i Pin nie mogą być puste");
                } else if (!tLogin.getText().equals(s.getLogin()) || !tPin.getText().equals(s.getPin())) {
                    System.out.println("Zły Login lub Pin");
                } else {
                    looged = true;
                }
            }
            if (tLogin.getText().equals(s.getLogin()) && tPin.getText().equals(s.getPin())) {
                System.out.println("Logowanie pomyślne");
                Logowanie(s.getLogin(), s.getPin(), s.getStanKonta());
                Uzytkownik = s;
                looged = true;
                Clear();
            }
        }
    }

    public void Clear() {
        tLogin.setText("");
        tPin.setText("");
    }

    public void cashWithDrawal(double stanKonta) {
        String wypłataGotówki = JOptionPane.showInputDialog("Podaj kwote którą chcesz wypłacić");
        double kwota1 = Double.parseDouble(wypłataGotówki);
        System.out.println("Kwota: " + kwota1);
        double banknoty[] = {500, 200, 100, 50, 20, 10};
        ArrayList<Double> banknoty1 = new ArrayList<>();
        if (kwota1 > stanKonta) {
            JOptionPane.showMessageDialog(null, "Nie Posiadasz wystarczajacych środków na koncie");
        } else if (kwota1 < stanKonta && kwota1 % 10 == 0) {
            double temp1 = Double.parseDouble(StanT1.getText());
            temp1 = temp1 - kwota1;
            StanT1.setText(String.format("%.2f",(temp1)).replace(',','.' ));
            Math.round(temp1);
            JOptionPane.showMessageDialog(null, "Wyplaciles srodki o kwocie: " + kwota1 + "!");
            int i = 0;
            double kwota = kwota1;
            while (kwota > 0) {
                if(kwota == 0){
                    break;
                }
                if(banknoty[i] <= kwota) {
                    banknoty1.add(banknoty[i]);
                    kwota = kwota - banknoty[i];
                }
                else {
                    i++;
                }
            }
            for (Double j : banknoty1) {
                System.out.print(" " + j);
                System.out.println(" ");
            }
            Uzytkownik.setStanKonta(Double.parseDouble(Uzytkownik.getStanKonta()) - kwota1);
            Uzytkownik.addTransakcje("Wypłata", kwota1);
        }else{
            JOptionPane.showMessageDialog(null, "Wskazana kwota nie jest podzielna przez 10!");
        }
    }


    public void Transwer(double stanKonta){
        String przelew = JOptionPane.showInputDialog("Podaj kwote przelewu");
        User odbiorca = null;
        String doKogo = JOptionPane.showInputDialog("Podaj nazwe uzytkownika do ktorego chcesz przelac srodki");

        for (User u : this.users) {

            if (u.getLogin().equals(doKogo) ) {
                odbiorca = u;
            }

        }
        if(odbiorca != null){
            double kwota = Double.parseDouble(przelew);
            if (kwota > stanKonta) {
                JOptionPane.showMessageDialog(null, "Nie Posiadasz wystarczajacych środków na koncie");
            } else if (kwota < stanKonta) {
                double temp = Double.parseDouble(StanT1.getText());
                temp = temp - kwota;
                Math.round(temp);
                StanT1.setText(String.valueOf(temp));
                Uzytkownik.setStanKonta(Double.parseDouble(Uzytkownik.getStanKonta()) - kwota);
                Uzytkownik.addTransakcje("Przelew", kwota);
                odbiorca.setStanKonta(Double.parseDouble(odbiorca.getStanKonta()) + kwota);
                JOptionPane.showMessageDialog(null, "Wyslaleś przelew o kwocie: " + kwota + "!");
            }
        }else JOptionPane.showMessageDialog(null,"Błędny odbiorca");




    }


    public void accountStatements (String stanKonta){

        JFrame f = new JFrame();
        JPanel jp = new JPanel();

        f.setContentPane(jp);
        String [] t = new String[Uzytkownik.Transakcje.size()];

        for (int i = 0; i < Uzytkownik.Transakcje.size(); i++) {
            t[i] = String.valueOf(Uzytkownik.Transakcje.get(i));
        };

        JList lista = new JList(t);
        jp.add(lista);

        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


