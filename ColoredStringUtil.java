/*
 * Written by: Colin Kinzel (Colink02Dev)
 * Website: colink02dev.com
 * Description: use to convert hex colors to their proper color and normal chat colors
 * Uses &# for Hex colors and the '&' for normal chat colors.
 * This is Licensed under The Mozilla Public License 2.0
 */
import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ColoredStringUtil {

    public static String colorHex(String s) {
        s = findandReplaceRegex("&#[0-9,a-f,A-F]{6}", s);
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }


    public static String findandReplaceRegex(String regex, String input) {
        int i = 0;
        ArrayList<String> matches = new ArrayList<>();
        ArrayList<ChatColor> colorSet = new ArrayList<>();
        Matcher patternMatcher = Pattern.compile(regex).matcher(input);
        while(patternMatcher.find()) {
            matches.add(patternMatcher.group());
        }
        for(String match : matches) {
            colorSet.add(ChatColor.of(match.substring(1)));
        }
        Iterator<String> matchIterator = matches.iterator();
        Iterator<ChatColor> colorIterator = colorSet.iterator();
        while(matchIterator.hasNext() && colorIterator.hasNext()) {
            input = input.replaceFirst(matchIterator.next(), colorIterator.next().toString());
        }
        return input;
    }
    
    public static String rainbowText(String message) {
        StringBuilder finalizedMessage = new StringBuilder();
        int hue = 0;
        for(int messageChar = 0; messageChar < message.toCharArray().length; messageChar++) {
            Color color = Color.getHSBColor(((float)hue/360), 1f, 1f);
            String red = Integer.toHexString(color.getRed());
            String green = Integer.toHexString(color.getGreen());
            String blue = Integer.toHexString(color.getBlue());


            String hexColor = "&#" + (red.length() <= 2 ? StringUtils.repeat( "0",2-red.length()) + red : red) +
                    (green.length() <= 2 ? StringUtils.repeat( "0",2-green.length()) + green : green) +
                    (blue.length() <= 2 ? StringUtils.repeat( "0",2-blue.length()) + blue : blue);
            finalizedMessage.append(hexColor).append(message.toCharArray()[messageChar]);
            hue += (360/message.toCharArray().length);
        }
        return colorHex(finalizedMessage.toString());
    }

}
