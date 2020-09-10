package MilitaryElite;


import MilitaryElite.Enums.State;
import MilitaryElite.entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Private 1 Pesho Peshev 22.22
        //Commando 13 Stamat Stamov 13.1 Airforces
        //Private 222 Toncho Tonchev 80.08
        //LieutenantGeneral 3 Joro Jorev 100 222 1
        //End

        List<PrivateImpl> allPrivates = new ArrayList<>();
        File file = new File("src\\MilitaryElite\\example.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String command = br.readLine();
            while (!command.equals("End")){
                String [] commands = command.split(" ");
                String soldierType = commands[0];
                int id = Integer.parseInt(commands[1]);
                String firstName = commands[2];
                String lastName = commands[3];
                double salary = Double.parseDouble(commands[4]);

                switch (soldierType){
                    case "Private":
                        PrivateImpl priv = new PrivateImpl(id,firstName,lastName, salary);
                        allPrivates.add(priv);
                        System.out.println(priv);
                        break;
                    case "LeutenantGeneral":
                        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id,firstName,lastName,salary);
                        addPrivates(lieutenantGeneral, allPrivates,commands);
                        System.out.println(lieutenantGeneral.toString());
                        break;
                    case "Commando":
                        try {
                            String corp = commands[5];
                            CommandoImpl commando = new CommandoImpl(id,firstName,lastName,salary,corp);
                            addMissions(commands,commando);
                            System.out.println(commando);
                            printMission(commando);
                            break;
                        }catch (IllegalArgumentException ignored){
                            command = br.readLine();
                            continue;
                        }
                        //Engineer 7 Pencho Penchev 12.23 Marines Boat 2 Crane 17
                    case "Engineer":
                        try {
                            String corp = commands[5];
                            EngineerImpl engineer = new EngineerImpl(id,firstName,lastName,salary,corp);
                            addRepairs(commands,engineer);
                            System.out.println(engineer);
                            printRepairs(engineer);
                        }catch (IllegalArgumentException ignored){
                            command = br.readLine();
                            continue;
                        }
                        break;

                    case"Spy":
                        String codeName = commands[4];
                        SpyImpl spy = new SpyImpl(id,firstName,lastName,codeName);
                        System.out.println(spy.toString());

                }


                command = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printRepairs(EngineerImpl engineer) {
        for (Repair repair : engineer.getRepair()) {
            System.out.println(repair.toString());
        }
    }

    private static void addRepairs(String[] commands, EngineerImpl engineer) {
        for (int i = 6; i < commands.length; i+=2) {
            String repairName = commands[i];
            int hours = Integer.parseInt( commands[i+1]);
            Repair repair = new Repair(repairName,hours);
            engineer.addRepair(repair);
        }
    }

    private static void printMission(CommandoImpl commando) {
        for (Mission mission : commando.getMissions()) {
            if (mission.getState().equals(State.inProgress)){
                System.out.println(mission.toString());
            }
        }
    }

    private static void addMissions(String[] commands, CommandoImpl commando) {
        for (int i = 6; i < commands.length; i+=2) {
            String missionName = commands[i];
            String state = commands[i+1];
            Mission mission = new Mission(missionName,state);
            commando.addMission(mission);
        }
    }

    private static void addPrivates(
            LieutenantGeneralImpl lieutenantGeneral
            , List<PrivateImpl> allPrivates
            , String[] commands) {



        for (int i = 5; i < commands.length; i++) {
            for (PrivateImpl p : allPrivates) {
                if (p.getId() == Integer.parseInt( commands[i])){
                    lieutenantGeneral.addPrivate(p);
                    allPrivates.remove(p);
                    break;
                }
            }
        }
    }

}
