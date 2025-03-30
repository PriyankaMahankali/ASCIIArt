package class10;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AsciiArtGenerator535 {

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

    public static void generateAsciiArtSmall(String imagePath, int maxWidth, int maxHeight) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage resizedImage = resizeImage(image, maxWidth, maxHeight);

            String asciiChars = "@#%*+=-:. "; // Improved character set for better detail
            StringBuilder asciiArt = new StringBuilder();

            for (int y = 0; y < resizedImage.getHeight(); y++) {
                for (int x = 0; x < resizedImage.getWidth(); x++) {
                    int pixel = resizedImage.getRGB(x, y);
                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = pixel & 0xff;
                    int gray = (int) (0.2989 * red + 0.5870 * green + 0.1140 * blue); // More accurate grayscale conversion
                    int charIndex = (gray * (asciiChars.length() - 1)) / 255;
                    char asciiChar = asciiChars.charAt(charIndex);
                    asciiArt.append(asciiChar == '.' ? ' ' : asciiChar); // Replace dots with spaces

                }
                asciiArt.append("\n");
            }

            String asciiString = asciiArt.toString();
            copyToClipboard(asciiString);
            System.out.println("ASCII Art copied to clipboard!\n");
            System.out.println(asciiString);
        } catch (Exception e) {
            System.out.println("Error generating ASCII art: " + e.getMessage());
        }
    }

    private static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter the image file path: ");
            String imagePath = reader.readLine();
            File file = new File(imagePath);
            if (!file.exists()) {
                System.out.println("Invalid file path!");
                return;
            }

            System.out.print("Enter the maximum width: ");
            int maxWidth = Integer.parseInt(reader.readLine());
            System.out.print("Enter the maximum height: ");
            int maxHeight = Integer.parseInt(reader.readLine());

            generateAsciiArtSmall(imagePath, maxWidth, maxHeight);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
