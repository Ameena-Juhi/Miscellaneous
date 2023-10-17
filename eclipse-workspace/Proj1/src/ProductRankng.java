import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ProductRankng {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            List<String> productsData = readFromFile(inputFilePath);
            Map<String, Integer> productRatings = parseProductRatings(productsData);
            List<ProductEntry> rankedProducts = rankProducts(productRatings);
            writeToFile(outputFilePath, rankedProducts);
            System.out.println("Ranking completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFromFile(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }

    private static Map<String, Integer> parseProductRatings(List<String> productsData) {
        Map<String, Integer> productRatings = new HashMap<>();
        for (String entry : productsData) {
            String[] parts = entry.split(", ");
            if (parts.length == 2) {
                String productName = parts[0];
                int rating = Integer.parseInt(parts[1]);
                productRatings.put(productName, rating);
            }
        }
        return productRatings;
    }

    private static List<ProductEntry> rankProducts(Map<String, Integer> productRatings) {
        List<ProductEntry> rankedProducts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : productRatings.entrySet()) {
            rankedProducts.add(new ProductEntry(entry.getKey(), entry.getValue()));
        }

        rankedProducts.sort(Comparator.comparingInt(ProductEntry::getRating).reversed());

        int rank = 1;
        for (int i = 0; i < rankedProducts.size(); i++) {
            if (i > 0 && rankedProducts.get(i).getRating() < rankedProducts.get(i - 1).getRating()) {
                rank = i + 1;
            }
            rankedProducts.get(i).setRank(rank);
        }

        return rankedProducts;
    }

    private static void writeToFile(String filePath, List<ProductEntry> rankedProducts) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ProductEntry entry : rankedProducts) {
                writer.write(entry.getRank() + ", " + entry.getProductName() + "\n");
            }
        }
    }

    private static class ProductEntry {
        private final String productName;
        private final int rating;
        private int rank;

        public ProductEntry(String productName, int rating) {
            this.productName = productName;
            this.rating = rating;
        }

        public String getProductName() {
            return productName;
        }

        public int getRating() {
            return rating;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
