package com.ipi.jva320.model;

import java.time.LocalDate;
import java.util.*;

public final class Entreprise {

    private static final Map<Integer, LocalDate> datePaque = new HashMap<>();

    private Entreprise() {

    }

    static {
        datePaque.put(2012, LocalDate.of(2012, 4, 8));
        datePaque.put(2013, LocalDate.of(2013, 3, 31));
        datePaque.put(2014, LocalDate.of(2014, 4, 20));
        datePaque.put(2015, LocalDate.of(2015, 4, 5));
        datePaque.put(2016, LocalDate.of(2016, 3, 27));
        datePaque.put(2017, LocalDate.of(2017, 4, 16));
        datePaque.put(2018, LocalDate.of(2018, 4, 1));
        datePaque.put(2019, LocalDate.of(2019, 4, 21));
        datePaque.put(2020, LocalDate.of(2020, 4, 12));
        datePaque.put(2021, LocalDate.of(2021, 4, 4));
        datePaque.put(2022, LocalDate.of(2022, 4, 17));
        datePaque.put(2023, LocalDate.of(2023, 4, 9));
        datePaque.put(2024, LocalDate.of(2024, 3, 31));
        datePaque.put(2025, LocalDate.of(2025, 4, 20));
        datePaque.put(2026, LocalDate.of(2026, 4, 5));
        datePaque.put(2027, LocalDate.of(2027, 3, 28));
        datePaque.put(2028, LocalDate.of(2028, 4, 16));
        datePaque.put(2029, LocalDate.of(2029, 4, 1));
        datePaque.put(2030, LocalDate.of(2030, 4, 21));
        datePaque.put(2031, LocalDate.of(2031, 4, 13));
        datePaque.put(2032, LocalDate.of(2032, 3, 28));
        datePaque.put(2033, LocalDate.of(2033, 4, 17));
        datePaque.put(2034, LocalDate.of(2034, 4, 9));
        datePaque.put(2035, LocalDate.of(2035, 3, 25));
    }


    public static List<LocalDate> joursFeries(LocalDate now){

        return Arrays.asList(
                // 1er janvier	Jour de l’an
                LocalDate.of(now.getYear(), 1,1),
                // Lendemain du dimanche de Pâques.	Lundi de Pâques
                datePaque.get(now.getYear()).plusDays(1L),
                // 1er mai	Fête du Travail
                LocalDate.of(now.getYear(), 5,1),
                // 8 mai Fête de la Victoire
                LocalDate.of(now.getYear(), 5,8),
                // Jeudi 40 jours après Pâques Ascension Fête chrétienne célébrant la montée de Jésus aux cieux.
                datePaque.get(now.getYear()).plusDays(40L),
                // Le lundi suivant le dimanche de Pentecôte (le septième après Pâques).
                datePaque.get(now.getYear()).plusDays(50L),
                // 14 juillet Fête nationale
                LocalDate.of(now.getYear(), 7,14),
                // 15 août Assomption
                LocalDate.of(now.getYear(), 8,15),
                // 1er novembre	Toussaint Fête de tous les saints de l’Église catholique.
                LocalDate.of(now.getYear(), 11,1),
                // 11 novembre Armistice de 1918
                LocalDate.of(now.getYear(), 11,11),
                // 25 décembre Noël
                LocalDate.of(now.getYear(), 12,25)

        );
    }

    public static boolean bissextile(int y) {
        String tmp = String.valueOf(y);
        if (tmp.charAt(2) == '1' || tmp.charAt(2) == '3' || tmp.charAt(2) == 5 || tmp.charAt(2) == '7' || tmp.charAt(2) == '9') {
            if (tmp.charAt(3)=='2'||tmp.charAt(3)=='6') return true;
            else
                return false;
        }else{
            if (tmp.charAt(2) == '0' && tmp.charAt(3) == '0') {
                return false;
            }
            if (tmp.charAt(3)=='0'||tmp.charAt(3)=='4'||tmp.charAt(3)=='8')return true;
        }
        return false;
    }

    public static double proportionPondereeDuMois(LocalDate moisDuConge) {
        int proportionPonderee = 8;
        int mois = 1 + (moisDuConge.getMonthValue() + 6) % 12;
        if (mois >= 2) {
            proportionPonderee += 20;
        }
        if (mois >= 3) {
            proportionPonderee += 20;
        }
        if (mois >= 4) {
            proportionPonderee += 8;
        }
        if (mois >= 5) {
            proportionPonderee += 8;
        }
        if (mois >= 6) {
            proportionPonderee += 8;
        }
        if (mois >= 7) {
            proportionPonderee += 8;
        }
        if (mois >= 8) {
            proportionPonderee += 8;
        }
        if (mois >= 9) {
            proportionPonderee += 8;
        }
        if (mois >= 10) {
            proportionPonderee += 8;
        }
        if (mois >= 11) {
            proportionPonderee += 8;
        }
        if (mois >= 12) {
            proportionPonderee += 8;
        }
        return proportionPonderee / 12d / 10d;
    }


    public static LocalDate getPremierJourAnneeDeConges(LocalDate d) {
        return d == null ? null
                : d.getMonthValue() > 5 ? LocalDate.of(d.getMonthValue(), 6, 1)
                : LocalDate.of(d.getYear() - 1, 6, 1);
    }

    public static boolean estJourFerie(LocalDate jour) {
        int monEntier = (int) Entreprise.joursFeries(jour).stream().filter(d ->
                d.equals(jour)).count();
        int test = bissextile(jour.getYear()) ? 1 : 0;
        if (test != 0 && !(monEntier > 1)) {
            test--;
        }
        return monEntier != test;
    }

    /**
     * Calcule si une date donnée est dans une plage (intervalle) de date (inclusif)
     * @param d
     * @param debut date de début de la plage
     * @param fin date de fin de la plage
     * @return
     */
    public static boolean estDansPlage(LocalDate d, LocalDate debut, LocalDate fin) {
        // à implémenter en TDD !
        throw new RuntimeException("à implémenter en TDD !");
    }

}