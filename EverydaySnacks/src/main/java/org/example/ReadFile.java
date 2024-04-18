package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String filePath = "src/main/resources/orderInformation.txt";
        String[] linesArray= null;
        try {
            // created BufferedReader for reading
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Create a list to store the lines from the file
            List<String> lines = new ArrayList<>();

            // Read each line from the file and add it to the list
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Convert the list of lines into an array of strings
            linesArray = lines.toArray(new String[0]);


            for (String str : linesArray) {
                System.out.println(str);
            }

            reader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        Map<Integer, Product> allProducts = new HashMap<>();
        Map<Integer, Client> allClients = new HashMap<>();

        allProducts.put(1, new Product(1,"Danish Muffin",0.52,0.80,"none"));
        allProducts.put(2, new Product(2,"Granny’s Cup Cake", 0.38, 1.20,"30% off"));
        allProducts.put(3, new Product(3,"Frenchy’s Croissant", 0.41, 0.90,"none"));
        allProducts.put(4, new Product(4,"Crispy chips", 0.60, 1.00,"Buy 2, get 3rd free"));



        allClients.put(1, new Client(1, "ABC Distribution", 0.05, 0.00,0.02));
        allClients.put(2, new Client(2, "DEF Foods", 0.04, 0.01,0.02));
        allClients.put(3, new Client(3, "GHI Trade", 0.03, 0.01,0.03));
        allClients.put(4,new Client(4, "JKL Kiosks", 0.02, 0.03,0.05));
        allClients.put(5, new Client(4, "MNO Vending", 0.00, 0.05,0.07));

        for (int y = 0; y < linesArray.length; y++) {

            Map<Integer, Integer> productsMap = new HashMap<>();
            System.out.println("Order details:");
            String input = linesArray[y];
            String[] inputArr = input.split(",");
            int clientId = Integer.parseInt(inputArr[0]);

            for (int i = 1; i < inputArr.length; i++) {
                int productId = 0;
                int productQuantity = 0;
                String[] productsData = inputArr[i].split("=");
                productId = Integer.parseInt(productsData[0]);
                productQuantity = Integer.parseInt(productsData[1]);
                productsMap.put(productId, productQuantity);
            }
            Client client = allClients.get(clientId);
            String clientName = client.getName();
            if (client == null) {
                System.out.println("Invalid client ID");
                return;
            }
            System.out.printf("Client:      %s" + System.lineSeparator(), clientName);
            System.out.println("Product      Quantity        Standard Unit Price     Promotional Unit Price      Line Total");

            double totalBeforeDiscounts = 0;

            for (Map.Entry<Integer, Integer> entry : productsMap.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = allProducts.get(productId);
                if (product == null) {
                    System.out.println("Invalid product ID: " + productId);
                    return;
                }
                double standardUnitPrice = product.calculateStandardUnitPrice();
                double promotionalUnitPrice = 0;
                if (product.getPromotion().equals("Buy 2, get 3rd free")) {
                    promotionalUnitPrice = product.calculatePromotionalUnitPrice(quantity);
                } else {
                    promotionalUnitPrice = product.calculatePromotionalUnitPrice();
                }
                double lineTotal = promotionalUnitPrice == 0 ? standardUnitPrice * quantity : promotionalUnitPrice * quantity;
                totalBeforeDiscounts += lineTotal;

                System.out.printf("%s      %d      EUR %f                ", product.getProductName(), quantity, standardUnitPrice);
                if (promotionalUnitPrice == 0) {
                    System.out.print("                        ");
                } else {
                    System.out.print("EUR " + promotionalUnitPrice + "              ");
                }
                System.out.printf("EUR %.2f" + System.lineSeparator(), lineTotal);

            }
            System.out.println("Total Before Client Discounts: " + String.format("EUR %.2f", totalBeforeDiscounts));
            double clientDiscountTotal = 0;
            double volumeDiscountTotal = 0;
            if (client.getBasicDiscount() == 0) {
                System.out.println("Client discount: No discount");
                if (totalBeforeDiscounts > 30000 && client.getVolumeDiscountAbove30000() != 0) {
                    volumeDiscountTotal = client.discountAbove(totalBeforeDiscounts);
                    double discount = totalBeforeDiscounts - volumeDiscountTotal;
                    System.out.printf("Additional Volume Discount: %.0f%%  EUR %.2f" + System.lineSeparator(), client.getVolumeDiscountAbove30000() * 100, discount);
                } else {
                    if (totalBeforeDiscounts > 10000 && client.getVolumeDiscountAbove30000() != 0) {
                        volumeDiscountTotal = client.discountAbove(totalBeforeDiscounts);
                        double discount = totalBeforeDiscounts - volumeDiscountTotal;
                        System.out.printf("Additional Volume Discount: %.0f%%  EUR %.2f" + System.lineSeparator(), client.getVolumeDiscountAbove10000() * 100, discount);
                    }
                }
            } else {
                clientDiscountTotal = client.clientDiscount(totalBeforeDiscounts);
                double clDiscount = totalBeforeDiscounts - clientDiscountTotal;
                System.out.printf("Client discount: %.0f%%  EUR %.2f" + System.lineSeparator(), client.getBasicDiscount() * 100, clDiscount);
                if (clientDiscountTotal > 30000 && client.getVolumeDiscountAbove30000() != 0) {
                    volumeDiscountTotal = client.discountAbove(clientDiscountTotal);
                    double discount = clientDiscountTotal - volumeDiscountTotal;
                    System.out.printf("Additional Volume Discount: %.0f%%  EUR %.2f" + System.lineSeparator(), client.getVolumeDiscountAbove30000() * 100, discount);
                } else {
                    if (clientDiscountTotal > 10000 && clientDiscountTotal < 30000 && client.getVolumeDiscountAbove10000() != 0) {
                        volumeDiscountTotal = client.discountAbove(clientDiscountTotal);
                        double discount = clientDiscountTotal - volumeDiscountTotal;
                        System.out.printf("Additional Volume Discount: %.0f%%  EUR %.2f/n", client.getVolumeDiscountAbove10000() * 100, discount);
                    }
                }
            }
            double totalPrice = client.allDiscount(totalBeforeDiscounts);
            System.out.printf("Order Total Amount:  EUR %.2f", totalPrice);
            System.out.println();
            System.out.println();
        }

    }

}
