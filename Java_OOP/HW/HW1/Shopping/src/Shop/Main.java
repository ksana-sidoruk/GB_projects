package Shop;
// Авторские права на название предметов принадлежат замечательным авторам Годвилля.
// Используются в некоммерческих и обучающих целях, поэтому норм.


public class Main {
    public static void main(String[] args) {
        Catalogue shop = new Catalogue();
        Category cutlery = new Category("Колюще-режущие");
        Good swordaxe = new Good("Топорный меч", cutlery, 100);
        Good naileDesk = new Good("Доска с гвоздем", cutlery, 3);
        Good boomerang = new Good("Носок-бумеранг", cutlery, 55);
        shop.addCategory(cutlery);

        Category shields = new Category("Щиты");
        Good boneShield = new Good("Костяной щит", shields, 105);
        Good sheet = new Good("Булл-щит", shields, 50);
        Good allsheet = new Good("Совсехсторонний щит", shields, 500);
        shop.addCategory(shields);

        shop.printCatalogue();

        User tolik = new User("тролль Толя", "111");
        User galia = new User("амазонка Галина", "g1rlp0wEr");
        tolik.buysGood(naileDesk);
        tolik.buysGood(sheet);
        galia.buysGood(boomerang);
        galia.buysGood(swordaxe);

        shop.printCatalogue();
    }
}