package com.kce.app;

import java.util.List;
import java.util.Scanner;
import com.kce.entity.Gardener;
import com.kce.service.GardenService;

public class GardenMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GardenService service = new GardenService();

        while (true) {

            System.out.println("\n--- Community Garden Management Console ---");
            System.out.println("1. Register Gardener");
            System.out.println("2. View Gardener by ID");
            System.out.println("3. View All Gardeners");
            System.out.println("4. Update Gardener");
            System.out.println("5. Delete Gardener");
            System.out.println("6. Allocate Plot");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    Gardener g = new Gardener();  

                    System.out.print("Gardener ID: ");
                    g.setGardenerID(sc.nextLine());

                    System.out.print("Full Name: ");
                    g.setFullName(sc.nextLine());

                    System.out.print("Email: ");
                    g.setEmail(sc.nextLine());

                    System.out.print("Mobile: ");
                    g.setMobile(sc.nextLine());

                    System.out.print("Street: ");
                    g.setStreetName(sc.nextLine());

                    System.out.print("House No: ");
                    g.setHouseOrApartmentNo(sc.nextLine());

                    System.out.print("Category: ");
                    g.setPreferredCategory(sc.nextLine());

                    g.setStatus("ACTIVE");

                    service.registerGardener(g);
                    break;

              
                case 2:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();   

                    Gardener found = service.getGardener(id);

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Gardener Not Found");
                    break;

             
                case 3:
                    List<Gardener> list = service.getAllGardeners();
                    list.forEach(System.out::println);
                    break;

            
                case 4:
                    System.out.print("Enter ID to Update: ");
                    String uid = sc.nextLine();

                    Gardener update = service.getGardener(uid);

                    if (update != null) {
                        System.out.print("New Mobile: ");
                        update.setMobile(sc.nextLine());
                        service.updateGardener(update);
                    } else {
                        System.out.println("Gardener Not Found");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to Delete: ");
                    String did = sc.nextLine();

                    service.deleteGardener(did);
                    break;

                case 6:
                    System.out.print("Enter Gardener ID: ");
                    String gid = sc.nextLine();
                    Gardener gardener = service.getGardener(gid);

                    if (gardener == null) {
                        System.out.println("Gardener Not Found!");
                        break;
                    }

                    System.out.print("Plot No: ");
                    String plotNo = sc.nextLine();

                    System.out.print("Season Name: ");
                    String season = sc.nextLine();

                    System.out.print("Start Date (yyyy-mm-dd): ");
                    String start = sc.nextLine();

                    System.out.print("End Date (yyyy-mm-dd): ");
                    String end = sc.nextLine();

                    service.allocatePlot(gardener, plotNo, season, start, end);
                    break;
                    
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
        }
            
    }
}
}
