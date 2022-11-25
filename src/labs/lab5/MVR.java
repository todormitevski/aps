package labs.lab5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Citizen {
    private final String fullName;
    private final int IDCard;
    private final int passport;
    private final int driversLicense;

    public String getFullName() {
        return fullName;
    }

    public int getIDCard() {
        return IDCard;
    }

    public int getPassport() {
        return passport;
    }

    public int getDriversLicense() {
        return driversLicense;
    }

    public Citizen(String fullName, int IDCard, int passport, int driversLicense) {
        this.fullName = fullName;
        this.IDCard = IDCard;
        this.passport = passport;
        this.driversLicense = driversLicense;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        int N = Integer.parseInt(br.nextLine());

        Queue<Citizen> IDCards = new LinkedList<Citizen>();
        Queue<Citizen> passports = new LinkedList<Citizen>();
        Queue<Citizen> driversLicenses = new LinkedList<Citizen>();

        for (int i = 1; i <= N; i++) {
            String fullName = br.nextLine();
            int IDCard = Integer.parseInt(br.nextLine());
            int passport = Integer.parseInt(br.nextLine());
            int driversLicense = Integer.parseInt(br.nextLine());
            Citizen citizen = new Citizen(fullName, IDCard, passport, driversLicense);
            if (citizen.getIDCard() == 1) IDCards.add(citizen);
            else if (citizen.getPassport() == 1) passports.add(citizen);
            else driversLicenses.add(citizen);
        }
        while (IDCards.peek() != null) {
            Citizen citizen = IDCards.poll();
            if (citizen.getPassport() == 1) passports.add(citizen);
            else if (citizen.getDriversLicense() == 1) driversLicenses.add(citizen);
            else System.out.println(citizen.getFullName());
        }
        while (passports.peek() != null) {
            Citizen citizen = passports.poll();
            if (citizen.getDriversLicense() == 1) driversLicenses.add(citizen);
            else System.out.println(citizen.getFullName());
        }
        while (driversLicenses.peek() != null) {
            Citizen citizen = driversLicenses.poll();
            System.out.println(citizen.getFullName());
        }
    }
}