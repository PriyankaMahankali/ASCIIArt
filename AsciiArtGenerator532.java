package class10;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class AsciiArtGenerator532 {

    public static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        double aspectRatio = (double) originalWidth / originalHeight;

        if (newWidth / aspectRatio <= newHeight) {
            newHeight = (int) (newWidth / aspectRatio);
        } else {
            newWidth = (int) (newHeight * aspectRatio);
        }

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    public static int applyGammaCorrection(int value, double gamma) {
        return (int) (255 * Math.pow((value / 255.0), gamma));
    }

    public static void generateAsciiArt(String imagePath, int maxWidth, int maxHeight, String outputFilePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage resizedImage = resizeImage(image, maxWidth, maxHeight);

            String asciiChars = "@#%*+=-:. ";
            int charWidth = 10, charHeight = 15;
            double gamma = 1.8; // Adjusted for better contrast
            double brightnessFactor = 1.3; // Boost brightness

            BufferedImage asciiImage = new BufferedImage(
                    resizedImage.getWidth() * charWidth,
                    resizedImage.getHeight() * charHeight,
                    BufferedImage.TYPE_INT_RGB
            );

            Graphics2D g2d = asciiImage.createGraphics();
            g2d.setFont(new Font("Monospaced", Font.BOLD, charHeight));

            for (int y = 0; y < resizedImage.getHeight(); y++) {
                for (int x = 0; x < resizedImage.getWidth(); x++) {
                    int pixel = resizedImage.getRGB(x, y);
                    int red = (int) (applyGammaCorrection((pixel >> 16) & 0xff, gamma) * brightnessFactor);
                    int green = (int) (applyGammaCorrection((pixel >> 8) & 0xff, gamma) * brightnessFactor);
                    int blue = (int) (applyGammaCorrection(pixel & 0xff, gamma) * brightnessFactor);
                    
                    red = Math.min(red, 255);
                    green = Math.min(green, 255);
                    blue = Math.min(blue, 255);

                    int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                    int charIndex = (gray * (asciiChars.length() - 1)) / 255;
                    String asciiChar = String.valueOf(asciiChars.charAt(charIndex));

                    g2d.setColor(new Color(red, green, blue));
                    g2d.fillRect(x * charWidth, y * charHeight, charWidth, charHeight); // Set background
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(asciiChar, x * charWidth, (y + 1) * charHeight);
                }
            }
            g2d.dispose();

            ImageIO.write(asciiImage, "png", new File(outputFilePath));
            System.out.println("Enhanced ASCII art saved as: " + outputFilePath);
        } catch (Exception e) {
            System.out.println("Error generating ASCII art: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the image file path: ");
        String imagePath = scanner.nextLine();
        File file = new File(imagePath);
        if (!file.exists()) {
            System.out.println("Invalid file path!");
            return;
        }

        System.out.print("Enter the maximum width: ");
        int maxWidth = scanner.nextInt();
        System.out.print("Enter the maximum height: ");
        int maxHeight = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        generateAsciiArt(imagePath, maxWidth, maxHeight, outputFilePath);
        scanner.close();
    }
}
