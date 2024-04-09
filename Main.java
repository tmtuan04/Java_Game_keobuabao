package keo_bua_bao;

import java.util.Scanner;

class Game {
    String userPick;
    String computerPick; // Quy ước 1 - Búa ; 2 - Bao ; 3 - Kéo
    String result;

    String getComputerPick() {
        int randomNumber =(int)(Math.random() * 3) + 1;
        if (randomNumber == 1) {
            computerPick = "bua";
        }
        else if (randomNumber == 2) {
            computerPick = "bao";
        }
        else {
            computerPick = "keo";
        }
        return computerPick; 
    }
    String getUserInput() {
        Scanner input = new Scanner(System.in);
        String userPick;
        while (true) {

            System.out.print("Nhap vao (keo, bua hoac bao): ");
            userPick = input.nextLine();
            
            if (userPick.equals("keo") || userPick.equals("bua") || userPick.equals("bao")) {
                break;
            }
            else System.out.println("Du lieu dao vao khong hop le, vui long nhap lai!");
        }
        return userPick;
    }
    String getResult(String userPick, String computerPick) {
        if (userPick.equals(computerPick)) {
            return "hoa";
        }
        else if ((userPick.equals("keo") && computerPick.equals("bao")) ||
        (userPick.equals("bua") && computerPick.equals("keo")) ||
        (userPick.equals("bao") && computerPick.equals("bua"))) {
            return "thang";
        }
        else return "thua";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        try {
            while (true) {
                Game game = new Game();
                String userPick = game.getUserInput();
                String computerPick = game.getComputerPick();
                String result = game.getResult(userPick, computerPick);
        
                System.out.println("Ban chon: " + userPick);
                System.out.println("May chon: " + computerPick);
                System.out.println("Ban " + result + " !");
    
                System.out.print("Ban co muon choi lai khong (y/n): ");
    
                String tmp = input.nextLine();
                if (tmp.equals("y")) {}
                else {
                    System.out.println("Game ket thuc!");
                    break;
                }
            }
            input.close();
        }
        catch(Exception e){
            System.out.println("Chuong trinh loi!");
        }
    }
}
