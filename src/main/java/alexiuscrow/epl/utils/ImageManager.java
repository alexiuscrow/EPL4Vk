package alexiuscrow.epl.utils;

import alexiuscrow.epl.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
public class ImageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageManager.class);

    private static int profileImgWidth = 20;
    private static int profileImgHeight = profileImgWidth;

    public static int getProfileImgWidth() {
        return profileImgWidth;
    }

    public static void setProfileImgWidth(int profileImgWidth) {
        ImageManager.profileImgWidth = profileImgWidth;
    }

    public static int getProfileImgHeight() {
        return profileImgHeight;
    }

    public static void setProfileImgHeight(int profileImgHeight) {
        ImageManager.profileImgHeight = profileImgHeight;
    }

    public static FileInputStream saveAndGetImageForProfile(URL url) {
        try {
            BufferedImage originalImage = ImageIO.read(url);
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            BufferedImage resizeImageJpg = resizeImage(originalImage, profileImgWidth, profileImgHeight, type);

            File folder = new File("./" + Settings.getAppFolderName());

            if (!folder.exists()) {
                if (folder.mkdir())
                    LOGGER.debug("Created folder: " + folder.getPath());
                else
                    return null;
            }

            LOGGER.debug("Going to save image to path: " + folder.getPath() + "\\" + Settings.getProfileAvatarName());
            ImageIO.write(resizeImageJpg, "jpg", new File(folder.getPath() + "\\" + Settings.getProfileAvatarName()));

            return new FileInputStream(folder.getPath() + "\\" + Settings.getProfileAvatarName());

        } catch (IOException e) {
            LOGGER.error("!!!", e);
            return null;
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int toWidth, int toHeight, int type){
        BufferedImage resizedImage = new BufferedImage(toWidth, toHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, toWidth, toHeight, null);
        g.dispose();

        return resizedImage;
    }
}
